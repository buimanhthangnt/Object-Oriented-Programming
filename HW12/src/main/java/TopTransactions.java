import javafx.util.Pair;
import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class TopTransactions {
    public static void main(String[] args) {
        int number = Integer.parseInt(args[0]);
        Comparator<Pair<String, Double>> comparator = new TransactionComparator();
        PriorityQueue<Pair<String, Double>> queue = new PriorityQueue<Pair<String, Double>>(100, comparator);
        try {
            Scanner sc = new Scanner(new File("textfile2.txt"));
            int count = 0;
            String s = "";
            while (sc.hasNext()) {
                count++;
                if (count % 3 == 1) s += sc.next();
                else if (count % 3 == 2) s += "\t" + sc.next();
                else {
                    Pair<String, Double> pair = new Pair<String, Double>(s, sc.nextDouble());
                    queue.add(pair);
                    s = "";
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (queue.size() != 0 && number != 0) {
            number--;
            Pair<String, Double> pair = queue.remove();
            System.out.println(pair.getKey() + "\t" + pair.getValue());
        }
    }

    public static class TransactionComparator implements Comparator<Pair<String, Double>> {
        public int compare(Pair<String, Double> o1, Pair<String, Double> o2) {
            if (o1.getValue() > o2.getValue()) return -1;
            if (o1.getValue() < o2.getValue()) return 1;
            return 0;
        }
    }
}
