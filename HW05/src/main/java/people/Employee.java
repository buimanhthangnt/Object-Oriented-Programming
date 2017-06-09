package people;
import java.util.Date;

public class Employee extends Person {
    private double salary;

    public Employee (String n, Date b, double s) {
        super(n, b);
        salary = s;
    }
    public double getSalary() {
        return salary;
    }
    public String toString() {
        String str = super.toString();
        str += "\n" + "Salary: " + Double.toString(salary);
        return str;
    }
}
