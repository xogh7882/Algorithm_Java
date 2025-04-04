import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int map[][];
	static int dp[][];
	static int dr[] = {-1,0,-1};
	static int dc[] = {0,-1,-1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp = new int[N][M];
		
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				dp[i][j] = calc(i,j);
//				System.out.println(i + ", " + j + " : " + dp[i][j]);
			}
		}
		
		
		System.out.println(dp[N-1][M-1]);
	}
	
	
	private static int calc(int r, int c) {
		int sum = 0;
		
		for(int i=0;i<3;i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if(check(nr,nc)) sum = Math.max(sum, dp[nr][nc]);
		}
		return sum + map[r][c];
	}


	private static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<M;
	}


	

}
