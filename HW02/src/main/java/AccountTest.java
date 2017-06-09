import java.util.Scanner;

public class AccountTest {
    public static void main(String[] args) {
        Account account1 = new Account(50.00);
        Account account2 = new Account(-7.53);

        System.out.println("Account1 balance: " + account1.getBalance());
        System.out.println("Account2 balance: "+ account2.getBalance());
        Scanner sc = new Scanner(System.in);
        double depositAmount;

        System.out.print("Enter the deposit amount for account1: ");
        depositAmount = sc.nextDouble();
        System.out.println(depositAmount+" adding to account1 balance");
        account1.credit(depositAmount);
        System.out.println("account1 balance: " + account1.getBalance());
        System.out.println("account2 balance: " + account2.getBalance());

        System.out.print("Enter the deposit amount for account2: ");
        depositAmount = sc.nextDouble();
        System.out.println(depositAmount+" adding to account2 balance");
        account2.credit(depositAmount);
        System.out.println("account1 balance: " + account1.getBalance());
        System.out.println("account2 balance: " + account2.getBalance());
        System.out.println("");
        System.out.println("");
        System.out.print("Enter the amount of money you want to debit from account1: ");
        depositAmount = sc.nextDouble();
        account1.debit(depositAmount);
        System.out.println("The balance of account1 is "+account1.getBalance());

        System.out.print("Enter the amount of money you want to debit from account2: ");
        depositAmount = sc.nextDouble();
        account2.debit(depositAmount);
        System.out.println("The balance of account2 is "+account2.getBalance());

    }
}