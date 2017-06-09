public class SavingsAccount {
    private static double annualInterestRate;
    private double savingsBalance;

    public SavingsAccount(double sb) {savingsBalance = sb;};
    public double getSavingsBalance() {return savingsBalance;}
    public double calculateMonthlyInterest() {
        double monthlyInterest = annualInterestRate*savingsBalance/12;
        savingsBalance += monthlyInterest;
        return monthlyInterest;
    }
    public static void modifyInterestRate(double newRate) {
        annualInterestRate = newRate;
    }
}