public class CurrentAccount extends BankAccount {

    private double overdraftLimit;

    public CurrentAccount(String name,
                          String accountNumber,
                          String phoneNumber,
                          double initialBalance,
                          double overdraftLimit) {

        super(name, accountNumber, phoneNumber, initialBalance);

        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public String getAccountType() {
        return "Current Account";
    }

    @Override
    public void calculateInterest() {

        System.out.println(
            "Current accounts do not earn interest."
        );
    }

    @Override
    public boolean withdraw(double amount) {

        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
            return false;
        }

        if (amount > getBalance() + overdraftLimit) {
            System.out.println("Overdraft limit exceeded.");
            return false;
        }

        deductAmount(amount);

        System.out.println(
            "Amount withdrawn successfully."
        );

        return true;
    }
}