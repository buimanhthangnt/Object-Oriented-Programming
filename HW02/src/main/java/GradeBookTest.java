import java.util.Scanner;

public class GradeBookTest {
	public static void main(String[] args) {
		GradeBook course = new GradeBook("opp","Chau");
		course.displayMessage();
		System.out.print("Enter your new instructor name: ");
		Scanner sc = new Scanner(System.in);
		course.setInstructorName(sc.nextLine());
		course.displayMessage();
	}
}