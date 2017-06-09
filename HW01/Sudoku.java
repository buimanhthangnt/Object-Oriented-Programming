import java.util.Scanner;

public class Sudoku {
	public static void main(String[] args) {
		int[][] board = new int[9][9];
		Scanner input = new Scanner(System.in);
		for (int i=0; i<9; i++) {
			for (int j=0; j<9; j++) {				
				board[i][j] = input.nextInt();
			}
		}
		boolean OK = true;
		for (int i=0; i<9; i++) {
			if (!checkRow(i,board,true)) OK = false;
			if (!checkRow(i,board,false)) OK = false;
		}
		for (int i=0; i<7; i=i+3) {
			for (int j=0; j<7; j=j+3) {
				if (!checkSquare(i,j,board)) OK = false;
			}
		}
		if (OK) System.out.print("Valid");
		else System.out.print("Invalid");
	}
	public static boolean checkRow(int row, int[][] board, boolean isRow) {
		boolean[] mark = new boolean[10];
		int count = 0;
		for (int i=0; i<9; i++) {
			int j;
			if (isRow) j = board[row][i] - 1;
			else j = board[i][row] - 1;
			if (mark[j]==false) {
				count++;
				mark[j] = true;
			}
		}
		if (count==9) return true;
		else return false;
	}
	public static boolean checkSquare(int x, int y, int[][] board) {
		boolean[] mark = new boolean[10];
		int count = 0;
		for (int i=x; i<=x+2; i++) {
			for (int j=y; j<=y+2; j++) {
				int k = board[i][j] - 1;
				if (mark[k]==false) {
					mark[k] = true;
					count++;
				}
			}
		}
		if (count==9) return true;
		else return false;
	}
}