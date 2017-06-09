public class Date {
    private int day;
    private int month;
    private int year;
    private int dayPerMonth[] = {0,31,28,31,30,31,30,31,31,30,31,30,31};

    public Date(int d, int m, int y) {
        month = checkMonth(m);
        year = checkYear(y);
        day = checkDay(d);
        System.out.println("Date object constructor for date "+day+"/"+month+"/"+year);
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
    public Date nextDay() {
        day++;
        if ((month!=2 && day>dayPerMonth[month]) || (month==2 && (isLeap(year) && day==30 || !isLeap(year) && day==29))) {
            day = 1;
            month++;
        }
        if (month>12) {
            month = 1;
            year++;
        }
        return this;
    }
    public String toString() {
        return String.format("%d/%d/%d",day,month,year);
    }
}