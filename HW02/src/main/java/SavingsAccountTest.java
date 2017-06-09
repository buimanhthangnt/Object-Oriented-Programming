public class SavingsAccountTest {
    public static  void main(String[] args) {
        SavingsAccount saver1, saver2;
        saver1 = new SavingsAccount(2000);
        saver2 = new SavingsAccount(3000);
        SavingsAccount.modifyInterestRate(0.04);
        System.out.print("Monthly interest of saver1 is "+saver1.calculateMonthlyInterest());
        System.out.println("\nNew balance of saver1 is "+ saver1.getSavingsBalance());
        System.out.print("Monthly interest of saver2 is "+saver2.calculateMonthlyInterest());
        System.out.println("\nNew balance of saver2 is "+ saver2.getSavingsBalance());
        SavingsAccount.modifyInterestRate(0.05);
        System.out.print("\nAnnual interest rate has changed to 5%\n");
        System.out.print("Monthly interest of saver1 is "+saver1.calculateMonthlyInterest());
        System.out.println("\nNew balance of saver1 is "+ saver1.getSavingsBalance());
        System.out.print("Monthly interest of saver2 is "+saver2.calculateMonthlyInterest());
        System.out.println("\nNew balance of saver2 is "+ saver2.getSavingsBalance());
    }
}