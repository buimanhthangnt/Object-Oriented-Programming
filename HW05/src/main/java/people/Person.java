package people;
import java.util.Date;

public class Person {
    private String name;
    private Date birthday;

    public Person(String n, Date b) {
        name = n;
        birthday = b;
    }
    public String getName() {
        return name;
    }
    public String toString() {
        String str = "";
        str += "Name: " + name;
        str += ", Birthday: " + birthday.toString();
        return str;
    }
}
