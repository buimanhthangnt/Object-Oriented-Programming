public class DateAndTimeTest {
    public static void main(String[] args) {
        DateAndTime dt = new DateAndTime(23,59,59,31,12,2000);
        dt.tick();
        System.out.println(dt.toUniversalTime());
        dt.tick();
        System.out.println(dt.toUniversalTime());
        dt.incrementHour();
        System.out.println(dt.toUniversalTime());
        dt.nextDay();
        System.out.println(dt.toUniversalTime());
        dt.setDate(29,2,2016);
        dt.setTime(23,11,12);
        dt.tick();
        System.out.println(dt.toUniversalTime());
        dt.incrementHour();
        System.out.println(dt.toUniversalTime());
    }
}