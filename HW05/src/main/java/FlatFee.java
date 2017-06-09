public class FlatFee extends BankAccount {

    private static final double FLAT_MONTHLY_FEE = 10000.0;

    public FlatFee(double money) {
        super(money);
    }

    public double endMonthCharge() {
        return FLAT_MONTHLY_FEE;
    }
}
