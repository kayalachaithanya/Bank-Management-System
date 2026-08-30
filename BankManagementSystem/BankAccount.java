import java.util.ArrayList;
import java.util.List;

public abstract class BankAccount {

    // Encapsulation
    private String accountHolderName;
    private String accountNumber;
    private String phoneNumber;
    private double balance;

    private List<Transaction> transactions;

    // Constructor
    public BankAccount(String accountHolderName,
                       String accountNumber,
                       String phoneNumber,
                       double initialBalance) {

        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.phoneNumber = phoneNumber;

        if (initialBalance < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative");
        }

        this.balance = initialBalance;
        this.transactions = new ArrayList<>();
    }

    // Getters
    public String getAccountHolderName() {
        return accountHolderName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public double getBalance() {
        return balance;
    }

    // Deposit
    public void deposit(double amount) {

        if (amount <= 0) {
            System.out.println("Invalid deposit amount.");
            return;
        }

        balance += amount;

        transactions.add(
            new Transaction("DEPOSIT", amount, balance)
        );

        System.out.println("Amount deposited successfully.");
    }

    // Withdraw
    public boolean withdraw(double amount) {

        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
            return false;
        }

        if (amount > balance) {
            System.out.println("Insufficient balance.");
            return false;
        }

        balance -= amount;

        transactions.add(
            new Transaction("WITHDRAW", amount, balance)
        );

        System.out.println("Amount withdrawn successfully.");

        return true;
    }

    // Protected method for child classes
    protected void deductAmount(double amount) {
        balance -= amount;
    }

    protected void addAmount(double amount) {
        balance += amount;
    }

    // Transaction history
    public void showTransactions() {

        if (transactions.isEmpty()) {
            System.out.println("No transactions available.");
            return;
        }

        System.out.println("\n===== TRANSACTION HISTORY =====");

        for (Transaction transaction : transactions) {
            transaction.display();
        }
    }

    // Account details
    public void showAccountDetails() {

        System.out.println("\n===== ACCOUNT DETAILS =====");

        System.out.println("Account Holder : " + accountHolderName);
        System.out.println("Account Number : " + maskAccountNumber());
        System.out.println("Phone Number   : " + maskPhoneNumber());
        System.out.println("Account Type   : " + getAccountType());
        System.out.println("Balance        : ₹" + balance);
    }

    private String maskAccountNumber() {

        if (accountNumber.length() <= 4) {
            return accountNumber;
        }

        return "XXXXXX" +
               accountNumber.substring(accountNumber.length() - 4);
    }

    private String maskPhoneNumber() {

        if (phoneNumber.length() <= 4) {
            return phoneNumber;
        }

        return "XXXXXX" +
               phoneNumber.substring(phoneNumber.length() - 4);
    }

    // Abstraction
    public abstract String getAccountType();

    public abstract void calculateInterest();
}