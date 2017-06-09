public class DateAndTime {
    private int hour;
    private int minute;
    private int second;
    private int day;
    private int month;
    private int year;
    private int dayPerMonth[] = {0,31,28,31,30,31,30,31,31,30,31,30,31};

    public DateAndTime(int h, int m, int s, int d, int mon, int y) {
        hour = h; minute = m; second = s;
        day = d; month = mon; year = y;
        System.out.println("Date object constructor for "+this.toUniversalTime());
    }
    //Time
    public void setTime(int h, int m, int s) {
        setHour(h);
        setMinute(m);
        setSecond(s);
        System.out.println("Time has changed to "+hour+":"+minute+":"+second);
    }
    public int getHour() {return hour;}
    public void setHour(int h) {
        if (h>=0 && h<24) hour = h;
        else System.out.println("Invalid time, please check again!");
    }
    public int getMinute() {return minute;}
    public void setMinute(int m) {
        if (m>=0 && m<60) minute = m;
        else System.out.println("Invalid time, please check again!");
    }
    public int getSecond() {return second;}
    public void setSecond(int s) {
        if (s>=0 && s<60) second = s;
        else System.out.println("Invalid time, please check again!");
    }

    public String toUniversalTime() {
        return String.format("%02d:%02d:%02d, %d/%d/%d",getHour(),getMinute(),getSecond(),day,month,year);
    }
    public String toStringTime() {
        return String.format("%02d:%02d:%02d %s, %d/%d/%d",(hour<=12)?hour:hour%12,minute,second,(hour<12)?"AM":"PM",day,month,year);
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
        if (hour==24) {
            hour = 0;
            nextDay();
        }
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

    //Date
    public void setDate(int d, int m, int y) {
        month = checkMonth(m);
        year = checkYear(y);
        day = checkDay(d);
        System.out.println("Date has changed to "+this.toStringDate());
    }
    private int checkMonth(int m) {
        if (m>0 && m<13) return m;
        else {
            System.out.println("Invalid month "+m+" is set to 6 as default");
            return 6;
        }
    }
    private int checkYear(int y) {
        if (y>0) return y;
        else {
            System.out.println("Invalid year "+y+" is set to 1997 as default");
            return 1997;
        }
    }
    private int checkDay(int d) {
        if (d>0 && d<=dayPerMonth[month]) return d;
        if (month==2 && d==29 && ((year%4==0 && year%100!=0)|| (year%4==0 && year%400==0))) return d;
        System.out.println("Invalid day "+d+" is set to 15 as default");
        return 15;
    }
    private boolean isLeap(int y) {
        return (year%4==0 && year%100!=0)|| (year%100==0 && year%400==0);
    }
    public void nextDay() {
        day++;
        if ((month!=2 && day>dayPerMonth[month]) || (month==2 && (isLeap(year) && day==30 || !isLeap(year) && day==29))) {
            day = 1;
            month++;
        }
        if (month>12) {
            month = 1;
            year++;
        }
    }
    public String toStringDate() {
        return String.format("%d/%d/%d",day,month,year);
    }
}