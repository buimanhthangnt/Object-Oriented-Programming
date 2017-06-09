import java.sql.Time;

public class Time2 {
    private int hour;
    private int minute;
    private int second;

    public Time2() { this(0,0,0);}
    public Time2(int h) {this(h,0,0);}
    public Time2(int h, int m) {this(h,m,0);}
    public Time2(int h, int m, int s) {setTime(h,m,s);}

    public Time2(Time2 time) {
        this(time.getHour(), time.getMinute(), time.getSecond());
    }

    private void setTime(int h, int m, int s) {
        setHour(h);
        setMinute(m);
        setSecond(s);
    }
    public int getHour() {return hour;}
    public boolean setHour(int h) {
        if (h>=0 && h<24) {
            hour = h;
            return true;
        } else {
            System.out.println("Invalid time, please check again!");
            return false;
        }
    }
    public int getMinute() {return minute;}
    public boolean setMinute(int m) {
        if (m>=0 && m<60) {
            minute = m;
            return true;
        } else {
            System.out.println("Invalid time, please check again!");
            return false;
        }
    }
    public int getSecond() {return second;}
    public boolean setSecond(int s) {
        if (s>=0 && s<60) {
            second = s;
            return true;
        } else {
            System.out.println("Invalid time, please check again!");
            return false;
        }
    }

    public String toUniversalTime() {
        return String.format("%02d:%02d:%02d",getHour(),getMinute(),getSecond());
    }
    public String toString() {
        return String.format("%02d:%02d:%02d %s",(hour<=12)?hour:hour%12,minute,second,(hour<12)?"AM":"PM");
    }
    public long secondTime() {
        return 3600*hour + 60*minute + second;
    }
    public void authenticate() {
        if (second==60) {
            second = 0;
            minute++;
        }
        if (minute==60) {
            minute = 0;
            hour++;
        }
        if (hour==24) hour = 0;
    }
    public void tick() {
        second++;
        authenticate();
    }
    public void incrementMinute() {
        minute++;
        authenticate();
    }
    public void incrementHour() {
        hour++;
        authenticate();
    }

    public static void main(String[] args) {
        Time2 time = new Time2(12,22,29);
        System.out.println("Time in univarsal format is "+time.toUniversalTime());
        time.setHour(22);
        time.setMinute(12);
        time.setSecond(29);
        System.out.println("Time in standard format is " +time.toString());
        System.out.print("The number of seconds from midnight to "+time.toString()+" is "+time.secondTime()+" seconds");
    }
}