import java.time.LocalDateTime;

public class Transaction {

    private String type;
    private double amount;
    private double balanceAfterTransaction;
    private LocalDateTime dateTime;

    public Transaction(String type,
                       double amount,
                       double balanceAfterTransaction) {

        this.type = type;
        this.amount = amount;
        this.balanceAfterTransaction =
                balanceAfterTransaction;

        this.dateTime = LocalDateTime.now();
    }

    public void display() {

        System.out.println(
            "Type: " + type +
            " | Amount: ₹" + amount +
            " | Balance: ₹" + balanceAfterTransaction +
            " | Date: " + dateTime
        );
    }
}
