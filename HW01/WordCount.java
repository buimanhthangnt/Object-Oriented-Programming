import java.util.Scanner;

public class WordCount {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] input = new char[1000];
		String temp = sc.nextLine();
		input = temp.toCharArray();
		int l = temp.length();
		int count = 1;
		for (int i=0; i<l-1; i++) {
			if (input[i]==32) {
				if (i>0 && input[i+1]>64 && input[i+1]<123) {
					count++;
				}
			}
		}
		System.out.print("The number of words is: " + count);
	}
}