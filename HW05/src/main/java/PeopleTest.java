
import people.Employee;
import people.Person;

import java.util.Date;

public class PeopleTest {
    public static void main(String[] args) {
        Person[] list = new Person[3];
        Employee newbie = new Employee("Newbie", new Date("2/10/1989"), 1000000);
        list[0] = newbie;
        Manager boss = new Manager("Boss", new Date(2 / 23 / 1986), 4000000);
        boss.setAssistant(newbie);
        list[1] = boss;
        Manager biggerBoss = new Manager("Big Boss", new Date(3/12/1969), 10000000);
        biggerBoss.setAssistant(boss);
        list[2] = biggerBoss;
        for (int i = 0; i < 3; i++) {
            System.out.println(list[i] + "\n");
        }
    }
}
