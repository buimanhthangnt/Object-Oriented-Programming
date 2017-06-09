public class FunctionGraph {
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		StdDraw.setXscale(0,3*Math.PI);
		StdDraw.setYscale(-2,2);
		double[] x  = new double[n+1];
		double[] y = new double[n+1];
		for (int i=0; i<=n; i++) {
			x[i] = 3*Math.PI*i/n;
			y[i] = Math.sin(2*x[i]);
		}
		for (int i=0; i<n; i++) {
			StdDraw.line(x[i],y[i],x[i+1],y[i+1]);
		}
	}
}