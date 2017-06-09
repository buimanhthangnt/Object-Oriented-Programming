package sort;

public class Demo {
    public static void main(String[] args) {
        BankAccount[] account = new BankAccount[12];
        for (int i = 0; i < 12; i++) {
            account[i] = new BankAccount(12 - i);
        }
        InsertionSort.sort(account);
        for (int i = 0; i < 12; i++) {
            System.out.print((int)account[i].getBalance() + " ");
        }

    }
}
