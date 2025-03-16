import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int map[][];
	
	static long dp[][][];
	
	static int dr[] = {0,1,1};
	static int dc[] = {1,1,0};
	static long result = 0L;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 가로(0) = 가로(0) + 대각(1)
		
		// 대각(1) = 가로(0) + 대각(1) + 세로(2)
		
		// 세로(2) = 대각(1) + 세로(2)
		
		dp = new long[3][N][N];
		
		dp[0][0][0] = 1;
		dp[0][0][1] = 1;
		
		for(int i=0;i<N;i++) {
			for(int j=2;j<N;j++) {
				if(map[i][j] == 1) continue;
				if(j-1>=0) {
					dp[0][i][j] = dp[0][i][j-1] + dp[1][i][j-1];
				}
				if(i-1>=0 && j-1>=0)
					if(map[i-1][j] == 0 && map[i][j-1]==0)
						dp[1][i][j] = dp[0][i-1][j-1] + dp[1][i-1][j-1] + dp[2][i-1][j-1];
				if(i-1>=0)
					dp[2][i][j] = dp[1][i-1][j] + dp[2][i-1][j];
			}
		}
		result = dp[0][N-1][N-1] + dp[1][N-1][N-1] + dp[2][N-1][N-1];
		System.out.println(result);
	}
	
}
