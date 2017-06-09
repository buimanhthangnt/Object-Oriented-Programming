import java.util.Scanner;

public class EmployeeTest {
    public static void main(String[] args) {
        Employee e1 = new Employee();
        Employee e2 = new Employee();
        System.out.print("Enter first name of Employee1: ");
        Scanner input = new Scanner(System.in);
        e1.setFirstName(input.next());
        System.out.print("Enter last name of Employee1: ");
        e1.setLastName(input.next());
        System.out.print("Enter monthly salary of Employee1: ");
        e1.setmSalary(input.nextDouble());

        System.out.print("Enter first name of Employee2: ");
        e2.setFirstName(input.next());
        System.out.print("Enter last name of Employee2: ");
        e2.setLastName(input.next());
        System.out.print("Enter monthly salary of Employee2: ");
        e2.setmSalary(input.nextDouble());

        System.out.println("Employee1: "+e1.getFirstName()+" "+e1.getLastName()+"\t\tMonthly Salary: "+e1.getmSalary());
        System.out.println("Employee2: "+e2.getFirstName()+" "+e2.getLastName()+"\t\tMonthly Salary: "+e2.getmSalary());

        System.out.println("Yearly salary of Employee1 is "+ 12*e1.getmSalary());
        System.out.println("Yearly salary of Employee2 is "+ 12*e2.getmSalary());

        System.out.println("Yearly salary of Employee1 after raising 10% is: "+12*e1.getmSalary()*1.1);
        System.out.println("Yearly salary of Employee2 after raising 10% is: "+12*e2.getmSalary()*1.1);
    }
}