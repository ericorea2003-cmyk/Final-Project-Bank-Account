import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
/**
 * Bank AccountGUI Application
 * Description: Visually repesents a graphicall user interface for a bank account. It
 * allows users to deposit and withdraw funds, displaying the current balance in real-time.
 * 
 * @Author: Eric Orea
 * @Date: 5/13/2026
 */


public class BankAccountGUI extends JFrame {
    private ArrayList<BankAccount> accounts = new ArrayList<>();
    private JTextArea displayArea;

    public BankAccountGUI() {
        setTitle("Bank Management System");
        setSize(600, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        displayArea = new JTextArea();
        displayArea.setEditable(false);
        displayArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        
        // This ensures that it will be scrollable if the content exceeds the visible area
        add(new JScrollPane(displayArea), BorderLayout.CENTER);

        JButton addBtn = new JButton("Create");
        JButton depositBtn = new JButton("Deposit");
        JButton withdrawBtn = new JButton("Withdraw");
        JButton editBtn = new JButton("Edit Name");
        JButton removeBtn = new JButton("Remove");

        JPanel buttonPanel = new JPanel(new GridLayout(1, 5));
        buttonPanel.add(addBtn);
        buttonPanel.add(depositBtn);
        buttonPanel.add(withdrawBtn);
        buttonPanel.add(editBtn);
        buttonPanel.add(removeBtn);
        add(buttonPanel, BorderLayout.SOUTH);

        // Action Listeners
        addBtn.addActionListener(e -> {
            String name = JOptionPane.showInputDialog(this, "Enter Name:");
            if (name != null && !name.trim().isEmpty()) {
                accounts.add(new BankAccount(name));
                updateDisplay();
            }
        });

        depositBtn.addActionListener(e -> handleTransaction(true));
        withdrawBtn.addActionListener(e -> handleTransaction(false));

        editBtn.addActionListener(e -> {
            BankAccount selected = selectAccount();
            if (selected != null) {
                String newName = JOptionPane.showInputDialog(this, "Enter new name:", selected.getHolderName());
                if (newName != null && !newName.trim().isEmpty()) {
                    int index = accounts.indexOf(selected);
                    if (index >= 0) {
                        BankAccount updated = new BankAccount(newName);
                        updated.deposit(selected.getBalance());
                        accounts.set(index, updated);
                        updateDisplay();
                    }
                }
            }
        });

        removeBtn.addActionListener(e -> {
            BankAccount selected = selectAccount();
            if (selected != null) {
                accounts.remove(selected);
                updateDisplay();
            }
        });

        updateDisplay();
        setVisible(true); // Makes the GUI visible after all components are added
    }

    private void updateDisplay() {
    StringBuilder sb = new StringBuilder();
    if (accounts.isEmpty()) {
        sb.append("No accounts available.");
    } else {
        for (BankAccount account : accounts) {
            // Added account.getAccountNumber() to the string format
            sb.append(String.format("ID: %d | %s - $%.2f%n", 
                account.getAccountNumber(), 
                account.getHolderName(), 
                account.getBalance()));
        }
    }
    displayArea.setText(sb.toString());
}

    private BankAccount selectAccount() {
        if (accounts.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No accounts available.", "Select Account", JOptionPane.INFORMATION_MESSAGE);
            return null;
        }
        String[] options = accounts.stream()
            .map(a -> a.getHolderName() + " - $" + String.format("%.2f", a.getBalance()))
            .toArray(String[]::new);
        int selected = JOptionPane.showOptionDialog(this, "Select an account:", "Select Account",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        return selected >= 0 ? accounts.get(selected) : null;
    }

    private void handleTransaction(boolean isDeposit) {
        BankAccount selected = selectAccount();
        if (selected == null) return;
        String action = isDeposit ? "deposit" : "withdraw";
        String input = JOptionPane.showInputDialog(this, "Enter amount to " + action + ":");
        if (input == null || input.trim().isEmpty()) return;
        try {
            double amount = Double.parseDouble(input);
            if (amount <= 0) {
                JOptionPane.showMessageDialog(this, "Amount must be positive.", "Invalid Amount", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (isDeposit) {
                selected.deposit(amount);
            } else {
                if (selected.getBalance() < amount) {
                    JOptionPane.showMessageDialog(this, "Insufficient funds.", "Transaction Failed", JOptionPane.ERROR_MESSAGE);
                } else {
                    selected.withdraw(amount);
                }
            }
            updateDisplay();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // Main method to launch the GUI application
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BankAccountGUI());
    }
}