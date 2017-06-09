package sort;

public class InsertionSort {
    public static <T extends MyComparator<T>> void sort(T[] input) {
        for (int i = 1; i < input.length; i++) {
            int j = i;
            while (j > 0 && input[j].compareTo(input[j-1])) {
                T temp = input[j];
                input[j] = input[j-1];
                input[j-1] = temp;
                j--;
            }
        }
    }
}