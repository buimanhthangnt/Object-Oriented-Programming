public class Employee {
    private String firstName;
    private String lastName;
    private double mSalary;

    public Employee() {};
    public Employee (String f, String l, double s) {
        firstName = f;
        lastName = l;
        mSalary = s;
    }
    public String getFirstName() {return firstName;}
    public void setFirstName(String f) {firstName = f;}
    public String getLastName() {return lastName;}
    public void setLastName(String l) {lastName = l;}
    public double getmSalary() {return mSalary;}
    public void setmSalary(double s) {
        if (s<0) mSalary = 0;
        else mSalary = s;
    }

}