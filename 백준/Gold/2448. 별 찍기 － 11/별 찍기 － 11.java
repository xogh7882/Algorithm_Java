import java.util.Scanner;

public class Main {
	static int N;
	static int[][] board;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		board = new int[2*N][2*N];
		
		tree(0,0,N);
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<2*N;j++) {
				if(board[i][j] == 1) sb.append("*");
				else sb.append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
		
	}
	
	public static void tree(int r, int c, int N) {
		
		if(N==3) {
			for(int i=0;i<3;i++) {
				for(int j=0;j<5;j++) {
					if(i==0 && j==2) board[r+i][c+j] = 1;
					else if(i==1 && (j==1 || j==3)) board[r+i][c+j] = 1;
					else if(i==2) board[r+i][c+j] = 1;
					else board[r+i][c+j] = 0;
				}
			}
		}
		
		else {
			tree(r+0,c+N/2,N/2);
			tree(r+N/2,c+0,N/2);
			tree(r+N/2,c+N,N/2);
	
		}

	}
}