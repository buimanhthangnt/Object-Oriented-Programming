public class Time2Test2 {
    public static void main(String[] args) {
        Time2 time = new Time2(25);
        Time2 time2 = new Time2(21,60);
        Time2 time3 = new Time2(21,59,-1);
        time3.setHour(29);
        time.setMinute(-32);
        time2.setSecond(65);
    }
}