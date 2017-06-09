public class NickelNDime extends BankAccount {
    private static final double WITHDRAW_FEE = 2000.0;
    private int withdrawCount = 0;

    public NickelNDime(long money) {
        super(money);
    }

    public void withdraw(long money) {
        super.withdraw(money);
        withdrawCount++;
    }

    public double endMonthCharge() {
        return WITHDRAW_FEE * withdrawCount;
    }

    public void endMonth() {
        super.endMonth();
        withdrawCount = 0;
    }
}
