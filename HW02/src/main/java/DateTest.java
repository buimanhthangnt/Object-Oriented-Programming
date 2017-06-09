public class DateTest {
    public static void main(String[] args) {
        Date date1 = new Date(29,2,1900);
        Date date2 = new Date(29,2,2016);
        Date date3 = new Date(-1,13,-2017);

        Date date4 = new Date(28,2,2015);
        System.out.println("\nThe next date of "+date4.toString()+" is "+date4.nextDay().toString()+"\n");
        Date date5 = new Date(29,2,2016);
        System.out.println("The next date of "+date5.toString()+" is "+date5.nextDay().toString()+"\n");
        Date date6 = new Date(15,6,1997);
        System.out.println("The next date of "+date6.toString()+" is "+date6.nextDay().toString()+"\n");
        Date date7 = new Date(31,12,2016);
        System.out.println("The next date of "+date7.toString()+" is "+date7.nextDay().toString()+"\n");
    }
}