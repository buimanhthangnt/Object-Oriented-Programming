public class RandomWalk { 

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        StdDraw.setXscale(-n, +n);
        StdDraw.setYscale(-n, +n);
        StdDraw.clear(StdDraw.GRAY);
        StdDraw.enableDoubleBuffering();

        int x = 0, y = 0;
        int left = 1, right = 0, top = 0, bottom = 0; 

        while (inRange(x,y,n)) {
            for ( y=bottom; y>=top; y--) draw(x,y,n);
            left--;
            for ( x=left; x<=right; x++) draw(x,y,n);
            top--;
            for ( y=top; y<=bottom; y++) draw(x,y,n);
            right++;
            for ( x=right; x>=left; x--) draw(x,y,n);
            bottom++;
        }
    }
    public static boolean inRange(int x, int y, int n) {
        return Math.abs(x) < n && Math.abs(y) < n;
    }
    public static void draw(int x, int y, int n) {
        if (!inRange(x,y,n)) return;
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.filledSquare(x, y, 0.45);
        StdDraw.show();
        StdDraw.pause(20);
        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.filledSquare(x, y, 0.45);
        StdDraw.show();
        StdDraw.pause(40);
        return ;
    }
}