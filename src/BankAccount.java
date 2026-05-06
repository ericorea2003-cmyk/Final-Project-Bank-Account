
/**
 * Bank Account Application
 * Description: Represents an individual bank account containing an account number,
 * owner name, and current balance.
 * @Author: Eric Orea
 * @Date:5/4/26
 */

public class BankAccount {
    
    // Static variable to generate unique account numbers
    private static int nextAccountNumber = 1000;
    
    private int accountNumber;
    private String ownerName;
    private double balance;
    
    /**
     * Constructor to initialize a new bank account.
     */
    public BankAccount(String ownerName, double initialBalance) {
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative.");
        }
        this.accountNumber = nextAccountNumber++;
        this.ownerName = ownerName;
        this.balance = initialBalance;
    }
    
    /**
     * Retrieves the account number.
     */
    public int getAccountNumber() {
        return accountNumber;
    }