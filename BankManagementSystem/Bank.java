import java.util.ArrayList;
import java.util.List;

public class Bank {

    private List<BankAccount> accounts;

    public Bank() {
        accounts = new ArrayList<>();
    }

    // Create account
    public void addAccount(BankAccount account) {

        accounts.add(account);

        System.out.println(
            "Account created successfully."
        );
    }

    // Find account
    public BankAccount findAccount(String accountNumber) {

        for (BankAccount account : accounts) {

            if (account.getAccountNumber()
                      .equals(accountNumber)) {

                return account;
            }
        }

        return null;
    }

    // Transfer money
    public void transfer(String fromAccount,
                         String toAccount,
                         double amount) {

        BankAccount sender =
                findAccount(fromAccount);

        BankAccount receiver =
                findAccount(toAccount);

        if (sender == null) {
            System.out.println(
                "Sender account not found."
            );
            return;
        }

        if (receiver == null) {
            System.out.println(
                "Receiver account not found."
            );
            return;
        }

        if (sender.withdraw(amount)) {

            receiver.deposit(amount);

            System.out.println(
                "Transfer successful."
            );
        }
    }

    // Show all accounts
    public void showAllAccounts() {

        if (accounts.isEmpty()) {

            System.out.println(
                "No accounts available."
            );

            return;
        }

        System.out.println(
            "\n===== ALL BANK ACCOUNTS ====="
        );

        for (BankAccount account : accounts) {

            System.out.println(
                "Name    : " +
                account.getAccountHolderName()
            );

            System.out.println(
                "Account : " +
                account.getAccountNumber()
            );

            System.out.println(
                "Type    : " +
                account.getAccountType()
            );

            System.out.println(
                "Balance : ₹" +
                account.getBalance()
            );

            System.out.println("---------------------------");
        }
    }
}