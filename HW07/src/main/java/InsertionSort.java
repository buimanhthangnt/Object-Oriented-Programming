
public class InsertionSort {
    public static void sort(BankAccount[] account, MyComparator compare) {
        for (int i = 1; i < account.length; i++) {
            int j = i;
            while (j > 0 && compare.less(account[j],account[j-1])) {
                BankAccount temp = account[j];
                account[j] = account[j-1];
                account[j-1] = temp;
                j--;
            }
        }
    }
}
