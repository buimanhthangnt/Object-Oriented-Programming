public class Sin {
	public static void main(String[] args) {
		double n = Double.parseDouble(args[0]);
		double sinx = 0, cosx = 1;
		for (int i=1; i<=13; i=i+2) {
			sinx += Math.pow(n,i)*Math.pow(-1,(i-1)/2)/permutation(i);
		}
		for (int i=2; i<=14; i=i+2) {
			cosx += Math.pow(n,i)*Math.pow(-1,i/2)/permutation(i);
		}
		System.out.println("sin x = " + sinx + ", cos x = " + cosx);
		//System.out.println(Math.pow(2,3));
	}
	public static long permutation(int n) {
		long res = 1;
		for (int i=1; i<=n; i++) {
			res *= i;
		}
		return res;
	}
}