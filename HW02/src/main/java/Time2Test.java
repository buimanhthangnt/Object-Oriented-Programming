public class Time2Test {
    public static void main(String[] args) {
        Time2 time = new Time2(12,22,29);
        System.out.println("The number of seconds from midnight to "+time.toString()+" is "+time.secondTime()+" seconds");
        time.setHour(8);
        time.setMinute(12);
        time.setSecond(59);
        System.out.println("It is "+time.toString()+" now");
        time.tick();
        System.out.println("After increasing a second, it is "+time.toString()+" now\n");

        time.setHour(8);
        time.setMinute(59);
        time.setSecond(32);
        System.out.println("It is "+time.toString()+" now");
        time.incrementMinute();
        System.out.println("After increasing a minute, it is "+time.toString()+" now\n");

        time.setHour(23);
        time.setMinute(59);
        time.setSecond(59);
        System.out.println("It is "+time.toString()+" now");
        time.incrementHour();
        System.out.println("After increasing a hour, it is "+time.toString()+" now\n");

        time.setHour(23);
        time.setMinute(59);
        time.setSecond(59);
        System.out.println("It is "+time.toString()+" now");
        time.tick();
        System.out.println("After increasing a second, it is "+time.toString()+" now\n");
    }
}