import people.Employee;

import java.util.Date;

public class Manager extends Employee {
    private Employee assistant;

    public Manager(String n, Date b, double s) {
        super(n, b, s);
    }
    public void setAssistant(Employee e) {
        assistant = e;
    }
    public String toString() {
        String str = super.toString();
        str += "\n" + "Assistant: " + assistant.getName();
        return str;
    }
}
