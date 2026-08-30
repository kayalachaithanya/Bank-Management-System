import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static Bank bank = new Bank();

    public static void main(String[] args) {

        int choice;

        do {

            System.out.println("\n================================");
            System.out.println("       BANK MANAGEMENT SYSTEM");
            System.out.println("================================");

            System.out.println("1. Create Savings Account");
            System.out.println("2. Create Current Account");
            System.out.println("3. Account Details");
            System.out.println("4. Show Balance");
            System.out.println("5. Deposit Money");
            System.out.println("6. Withdraw Money");
            System.out.println("7. Transfer Money");
            System.out.println("8. Transaction History");
            System.out.println("9. Calculate Interest");
            System.out.println("10. Show All Accounts");
            System.out.println("11. Exit");

            System.out.print("\nEnter your choice : ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    createSavingsAccount();
                    break;

                case 2:
                    createCurrentAccount();
                    break;

                case 3:
                    showAccountDetails();
                    break;

                case 4:
                    showBalance();
                    break;

                case 5:
                    depositMoney();
                    break;

                case 6:
                    withdrawMoney();
                    break;

                case 7:
                    transferMoney();
                    break;

                case 8:
                    showTransactions();
                    break;

                case 9:
                    calculateInterest();
                    break;

                case 10:
                    bank.showAllAccounts();
                    break;

                case 11:
                    System.out.println(
                        "\nThank you for using our bank."
                    );
                    break;

                default:
                    System.out.println(
                        "Invalid choice."
                    );
            }

        } while (choice != 11);

        sc.close();
    }

    // Create Savings Account
    static void createSavingsAccount() {

        sc.nextLine();

        System.out.print(
            "Enter account holder name : "
        );
        String name = sc.nextLine();

        System.out.print(
            "Enter account number : "
        );
        String accountNumber = sc.nextLine();

        System.out.print(
            "Enter phone number : "
        );
        String phoneNumber = sc.nextLine();

        System.out.print(
            "Enter initial deposit : "
        );
        double balance = sc.nextDouble();

        System.out.print(
            "Enter interest rate (%) : "
        );
        double interestRate = sc.nextDouble();

        SavingsAccount account =
            new SavingsAccount(
                name,
                accountNumber,
                phoneNumber,
                balance,
                interestRate
            );

        bank.addAccount(account);
    }

    // Create Current Account
    static void createCurrentAccount() {

        sc.nextLine();

        System.out.print(
            "Enter account holder name : "
        );
        String name = sc.nextLine();

        System.out.print(
            "Enter account number : "
        );
        String accountNumber = sc.nextLine();

        System.out.print(
            "Enter phone number : "
        );
        String phoneNumber = sc.nextLine();

        System.out.print(
            "Enter initial deposit : "
        );
        double balance = sc.nextDouble();

        System.out.print(
            "Enter overdraft limit : "
        );
        double overdraft = sc.nextDouble();

        CurrentAccount account =
            new CurrentAccount(
                name,
                accountNumber,
                phoneNumber,
                balance,
                overdraft
            );

        bank.addAccount(account);
    }

    // Find account
    static BankAccount getAccount() {

        sc.nextLine();

        System.out.print(
            "Enter account number : "
        );

        String accountNumber = sc.nextLine();

        BankAccount account =
                bank.findAccount(accountNumber);

        if (account == null) {

            System.out.println(
                "Account not found."
            );
        }

        return account;
    }

    // Account details
    static void showAccountDetails() {

        BankAccount account = getAccount();

        if (account != null) {
            account.showAccountDetails();
        }
    }

    // Balance
    static void showBalance() {

        BankAccount account = getAccount();

        if (account != null) {

            System.out.println(
                "Current Balance : ₹" +
                account.getBalance()
            );
        }
    }

    // Deposit
    static void depositMoney() {

        BankAccount account = getAccount();

        if (account != null) {

            System.out.print(
                "Enter deposit amount : "
            );

            double amount = sc.nextDouble();

            account.deposit(amount);
        }
    }

    // Withdraw
    static void withdrawMoney() {

        BankAccount account = getAccount();

        if (account != null) {

            System.out.print(
                "Enter withdrawal amount : "
            );

            double amount = sc.nextDouble();

            account.withdraw(amount);
        }
    }

    // Transfer
    static void transferMoney() {

        sc.nextLine();

        System.out.print(
            "Enter sender account number : "
        );

        String sender = sc.nextLine();

        System.out.print(
            "Enter receiver account number : "
        );

        String receiver = sc.nextLine();

        System.out.print(
            "Enter transfer amount : "
        );

        double amount = sc.nextDouble();

        bank.transfer(
            sender,
            receiver,
            amount
        );
    }

    // Transaction history
    static void showTransactions() {

        BankAccount account = getAccount();

        if (account != null) {
            account.showTransactions();
        }
    }

    // Interest
    static void calculateInterest() {

        BankAccount account = getAccount();

        if (account != null) {

            account.calculateInterest();
        }
    }
}