public class NickelNDime extends BankAccount {
    private static final double WITHDRAW_FEE = 2000.0;
    private int withdrawCount = 0;

    public NickelNDime(long money) {
        super(money);
    }

    public boolean withdraw(long money) {
        boolean isSuccessful =  super.withdraw(money);
        if (isSuccessful) {
            withdrawCount++;
            return true;
        } else return false;
    }

    public double endMonthCharge() {
        return WITHDRAW_FEE * withdrawCount;
    }

    public void endMonth() {
        super.endMonth();
        withdrawCount = 0;
    }
}
