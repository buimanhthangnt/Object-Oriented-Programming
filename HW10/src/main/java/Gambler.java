import java.util.Random;

public class Gambler extends BankAccount {

    public Gambler(double money) {
        super(money);
    }

    public void withdraw(long money) {
        super.withdraw(money);
        Random rand = new Random();
        int value = rand.nextInt(100) + 1;
        if (value > 49) super.withdraw(money * 2);
    }

    public double endMonthCharge() {
        return 0;
    }
}
