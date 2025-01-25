import java.util.Scanner;

public class Main {
	static int N;
	static int[][] board;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		board = new int[N][N];
		
		star(0,0,N);
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(board[i][j] == 1) sb.append("*");
				else sb.append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
		
	}
	
	public static void star(int r, int c, int N) {
		if(N==3) {
			for(int i=0;i<3;i++) {
				for(int j=0;j<3;j++) {
					if(i==1 && j==1) continue;
					board[r+i][c+j] = 1;
				}
			}
		}
		
		else {
			for(int i=0;i<3;i++) {
				for(int j=0;j<3;j++) {
					if(i==1 && j==1) continue;
					star(r+i*N/3, c+j*N/3, N/3);
				}
			}
		}
	
	
	
	}

}
