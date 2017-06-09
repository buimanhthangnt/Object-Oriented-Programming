public class GradeBook {
	private String courseName;
	private String instructorName;

	public GradeBook(String cName, String iName) {
		courseName = cName;
		instructorName = iName;
	}
	public void setInstructorName(String name) {
		instructorName = name;
	}
	public String getInstructorName() {
		return instructorName;
	}
	public void setCourseName(String name) {
		courseName = name;
	}
	public String getCourseName() {
		return courseName;
	}
	public void displayMessage() {
		System.out.println( "Welcome to the grade book for "+ getCourseName() );
		System.out.println("This course is presented by " + getInstructorName());
	}
}