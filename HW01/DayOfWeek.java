public class DayOfWeek {
	public static void main(String[] args) {
		int y, m, d, y0, m0, d0;
		y = Integer.parseInt(args[2]);
		m = Integer.parseInt(args[0]);
		d = Integer.parseInt(args[1]);
		y0 = y - (14 - m)/12;
		int x = y0 + y0/4 - y0/100 + y0/400;
		m0 = m + 12 * ((14 - m)/12) - 2;
		d0 = (d + x + 31*m0/12) % 7;
		switch (d0) {
			case 0: System.out.println("Sunday"); break;
			case 1: System.out.println("Monday"); break;
			case 2: System.out.println("Tuesday"); break;
			case 3: System.out.println("Wednesday"); break;
			case 4: System.out.println("Thursday"); break;
			case 5: System.out.println("Friday"); break;
			case 6: System.out.println("Saturday"); break;
		}
	}
}