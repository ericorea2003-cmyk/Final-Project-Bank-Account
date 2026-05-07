import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Bank Account Application
 * Description: This is the main application that manages multiple bank accounts.
 * @author Eric Orea
 * @date 5/4/26
 */
public class BankApp {

    /**
     * The main method runs the interactive banking application loop.
     * 
     * @param args Command line arguments (not used).
     */
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
                
            