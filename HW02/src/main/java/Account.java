public class Account {
    private double balance;

    public Account(double initialBalance) {
        if (initialBalance>0.0) {
            balance = initialBalance;
        }
    }
    public void credit (double amount) {
        balance += amount;
    }
    public double getBalance() {
        return balance;
    }
    public void debit(double money) {
        if (money>balance) {
            System.out.println("Debit amount exceeded acount balance!");
        }
        else {
            balance -= money;
            System.out.println("You have debited " + money + " from your account");
        }
    }
}