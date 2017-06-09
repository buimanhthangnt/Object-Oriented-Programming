import java.util.Random;

public class Gambler extends BankAccount {

    public Gambler(double money) {
        super(money);
    }

    public boolean withdraw(long money) {
        boolean isSuccessful =  super.withdraw(money);
        Random rand = new Random();
        int value = rand.nextInt(100) + 1;
        if (isSuccessful && value > 49) super.withdraw(money * 2);
        else super.withdraw(0);
        return isSuccessful;
    }

    public double endMonthCharge() {
        return 0;
    }
}
