import java.io.File;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Files {
    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(new File("D:\\Studying\\Semester3\\Object-Oriented_Programming\\HW02\\src\\main\\java\\test.txt"));
            input.useDelimiter(Pattern.compile("[^a-zA-Z]"));
            //input.skip("[^a-zA-Z]*");
            while(input.hasNext()) {
                String word = input.next();
                System.out.print(word+" ");
            }
        } catch (java.io.FileNotFoundException e) {}
    }
}