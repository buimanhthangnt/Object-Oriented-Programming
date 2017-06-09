import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TopWordCount {
    public static void main(String[] args) {
        int minLength = Integer.parseInt(args[0]);
        Map map = new HashMap();
        try {
            Scanner sc = new Scanner(new File("textfile.txt"));
            while (sc.hasNext()) {
                String s = sc.next();
                String res = "";
                for (int i = 0; i < s.length(); i++) {
                    char c = s.charAt(i);
                    if (c > 64 && c < 91) res += (char) (c + 32);
                    else if ((c > 96 && c < 123)) res += c;
                }
                if (res.length() >= minLength) {
                    if (map.containsKey(res)) map.put(res, (Integer) map.get(res) + 1);
                    else map.put(res, 1);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Collection<String> collection = map.keySet();
        String topWord = "";
        int topFrequency = 0;
        for (String s : collection) {
            int temp = (Integer) map.get(s);
            if (temp > topFrequency) {
                topFrequency = temp;
                topWord = s;
            }
        }
        System.out.println(topWord + "  " + topFrequency);
    }
}
