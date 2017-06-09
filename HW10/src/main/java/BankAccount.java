public abstract class BankAccount {
    private double balance;
    private int transactionCount = 0;

    public BankAccount(double b) {
        balance = b;
        System.out.println("Create new account with balance: " + b);
    }

    public double getBalance() {
        return balance;
    }

    public int getTransactionCount() {
        return transactionCount;
    }

    public void deposit(long money) throws InvalidAmountException {
        if (money < 0) throw new InvalidAmountException();
        balance += money;
        transactionCount++;
        System.out.println("Deposit: " + money);
    }

    public void withdraw(long money) throws InvalidAmountException, OverdrawException {
        if (money < 0) throw new InvalidAmountException();
        if (money > balance) throw new OverdrawException();
        balance -= money;
        transactionCount++;
        System.out.println("WithDraw: " + money);
    }

    public void endMonth() {
        double charge = endMonthCharge();
        System.out.println("The number of transactions: " + getTransactionCount());
        System.out.println("Fee: " + charge);
        balance -= charge;
        System.out.println("Current Balance: " + getBalance());
        transactionCount = 0;
    }
    public abstract double endMonthCharge();
}