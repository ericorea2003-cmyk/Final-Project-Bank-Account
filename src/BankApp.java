import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * BankAPP Application
 * Description: The main application that manages multiple bank accounts. It allows users
 * to create, edit, remove accounts, as well as deposit, withdraw, and generate statements.
 * Uses an ArrayList to store account objects and handles potential exceptions.
 * 
 *@Author: Eric Orea    
 * @Date: 5/13/2026
 */

public class BankApp {

    public static void main(String[] args) {
        ArrayList<BankAccount> accounts = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        
        System.out.println("Welcome to the Bank Account Manager!");
        
        while (running) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Create a new account");
            System.out.println("2. Edit an account (Change Owner Name)");
            System.out.println("3. Remove an account");
            System.out.println("4. Deposit funds");
            System.out.println("5. Withdraw funds");
            System.out.println("6. Generate account statement(s)");
            System.out.println("7. Exit");
            System.out.print("Select an option: ");
            
            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); 
                
                switch (choice) {
                    case 1:
                        System.out.print("Enter owner name: ");
                        String name = scanner.nextLine();
                        // This creates a new BankAccount object with the provided name and adds it to the accounts list.
                        BankAccount newAccount = new BankAccount(name);
                        accounts.add(newAccount);
                        System.out.println("Success! " + newAccount.getDetails());
                        break;
                        
                    case 2:
                        System.out.print("Enter the account ID to edit: ");
                        int editAccNum = scanner.nextInt();
                        scanner.nextLine(); 
                        
                        BankAccount accToEdit = findAccount(accounts, editAccNum);
                        if (accToEdit != null) {
                             
                        } else {
                            System.out.println("Account not found.");
                        }
                        break;
                        
                    case 3:
                        System.out.print("Enter the account ID to remove: ");
                        int removeAccNum = scanner.nextInt();
                        
                        BankAccount accToRemove = findAccount(accounts, removeAccNum);
                        if (accToRemove != null) {
                            accounts.remove(accToRemove);
                            System.out.println("Account successfully removed.");
                        } else {
                            System.out.println("Account not found.");
                        }
                        break;
                        
                    case 4:
                        System.out.print("Enter account ID for deposit: ");
                        int depAccNum = scanner.nextInt();
                        
                        BankAccount depAcc = findAccount(accounts, depAccNum);
                        if (depAcc != null) {
                            System.out.print("Enter amount to deposit: ");
                            double depAmount = scanner.nextDouble();
                            depAcc.deposit(depAmount);
                            System.out.println("Deposit successful.");
                        } else {
                            System.out.println("Account not found.");
                        }
                        break;
                        
                    case 5:
                        System.out.print("Enter account ID for withdrawal: ");
                        int withAccNum = scanner.nextInt();
                        scanner.nextLine();

                        BankAccount withAcc = findAccount(accounts, withAccNum);
                        if (withAcc != null) {
                            System.out.print("Enter amount to withdraw: ");
                            double withAmount = scanner.nextDouble();
                            withAcc.withdraw(withAmount);
                            System.out.println("Withdrawal successful.");
                        } else {
                            System.out.println("Account not found.");
                        }
                        break;

                    case 6:
                        if (accounts.isEmpty()) {
                            System.out.println("No accounts available.");
                        } else {
                            System.out.println("--- Account Statements ---");
                            for (BankAccount account : accounts) {
                                System.out.println(account.getDetails());
                            }
                        }
                        break;

                    case 7:
                        running = false;
                        System.out.println("Goodbye!");
                        break;

                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter valid values.");
                scanner.nextLine();
            }
        }
        scanner.close();
    }

    // Helper method to find an account by its ID
    private static BankAccount findAccount(ArrayList<BankAccount> accounts, int accountId) {
        if (accountId <= 0 || accountId > accounts.size()) {
            return null;
        }
        return accounts.get(accountId - 1);
    }
}

