import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BankAccountGUI extends JFrame {
   public static void main(String[] args) {
      JFrame mainFrame = new JFrame();
      mainFrame.setTitle("Welcome");
      mainFrame.setSize(400, 300);
      mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      mainFrame.setLayout(new GridLayout(3, 1,  10, 10));

      // Top Section
      JPanel topPanel = new JPanel();
      JLabel lbFirstName = new JLabel("Enter Bank Account:");
      topPanel.add(lbFirstName);

      // Central Section
      JPanel centralPanel = new JPanel();
      JTextField tfFirstName = new JTextField(10  );
      centralPanel.add(tfFirstName);

      
      

      // Bottom Section
      JPanel bottomPanel = new JPanel();
      JButton OkButton = new JButton("OK");
      bottomPanel.add(OkButton);

      // Action Listener Logic
      OkButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            String firstName = tfFirstName.getText(); 
            lbFirstName.setText("Hello " + firstName); 
         }
      });

      // Adding panels to the frame
      mainFrame.add(topPanel);
      mainFrame.add(centralPanel);
      mainFrame.add(bottomPanel);

      mainFrame.setVisible(true); // Final statement to display the UI
   }
}

