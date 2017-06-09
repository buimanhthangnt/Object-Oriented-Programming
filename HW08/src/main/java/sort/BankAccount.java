package sort;

public class BankAccount implements MyComparator<BankAccount> {
    private double balance;
    private int transactionCount = 0;

    public BankAccount(double b) {
        balance = b;
    }

    public double getBalance() {
        return balance;
    }

    public int getTransactionCount() {
        return transactionCount;
    }

    public boolean deposit(long money) {
        if (money <= 0) return false;
        balance += money;
        transactionCount++;
        return true;
    }

    public boolean withdraw(long money) {
        if (money <= 0 || money > balance) return false;
        balance -= money;
        transactionCount++;
        return true;
    }

    public void endMonth() {
        double charge = endMonthCharge();
        System.out.println("The number of transactions: " + getTransactionCount());
        System.out.println("Fee: " + charge);
        balance -= charge;
        System.out.println("Current Balance: " + getBalance());
        transactionCount = 0;
    }
    public double endMonthCharge() {
        return 0;
    }

    public boolean compareTo(BankAccount other) {
        if (this.balance < other.balance) return true;
        else return true;
    }

}