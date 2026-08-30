public class SavingsAccount extends BankAccount {

    private double interestRate;

    public SavingsAccount(String name,
                           String accountNumber,
                           String phoneNumber,
                           double initialBalance,
                           double interestRate) {

        super(name, accountNumber, phoneNumber, initialBalance);

        this.interestRate = interestRate;
    }

    @Override
    public String getAccountType() {
        return "Savings Account";
    }

    @Override
    public void calculateInterest() {

        double interest =
                getBalance() * interestRate / 100;

        addAmount(interest);

        System.out.println(
            "Interest Added : ₹" + interest
        );

        System.out.println(
            "New Balance : ₹" + getBalance()
        );
    }
}