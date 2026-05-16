/**
 * Bank Account Application
 * Description: Represents an individual bank account containing an account number,
 * owner name, and current balance. Provides functional methods for banking operations.
 * 
 * @Author: Eric Orea
 * @Date: 5//2026
 */
public class BankAccount {
    private static int nextId = 1000; // Static variable shared by all instances
    private int accountNumber;
    private String holderName;
    private double balance;

    public BankAccount(String name) {
        this.holderName = name;
        this.balance = 0.0;
        this.accountNumber = nextId++; // Assigns current value then increments for the next account
    }

    public int getAccountNumber() { return accountNumber; }

    /**
     * Deposits money into the account.
     * @param amount The amount to add.
     * @throws IllegalArgumentException if amount is non-positive.
     */
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive.");
        }
        this.balance += amount;
    }

    /**
     * Withdraws money from the account.
     * @param amount The amount to subtract.
     * @throws IllegalArgumentException if amount is invalid or exceeds balance.
     */
    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive.");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient funds.");
        }
        this.balance -= amount;
    }

    public double getBalance() {
        return balance;
    }

    public String getHolderName() {
        return holderName;
    }

    /**
     * Returns account details as a string formatted for the GUI display.
     * @return A formatted string of account info.
     */
    public String getDetails() {
        return String.format("ID: %d | Name: %-10s | Balance: $%.2f", 
                             accountNumber, holderName, balance);
    }
}