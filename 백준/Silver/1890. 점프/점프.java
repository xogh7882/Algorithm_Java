import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int map[][];
	static long dp[][];
	static long result = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
				
		dp = new long[N][N];
		dp[0][0] = 1;
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				cale(i,j);
			}
		}
		
//		printDp();
		
		
		System.out.println(dp[N-1][N-1]);
	}

	

	private static void cale(int r, int c) {
		if(map[r][c] == 0) return;
		
		int nr,nc;
		
		nr = r + map[r][c];
		if(check(nr,c)) {
			dp[nr][c] = dp[nr][c] + dp[r][c];
		}
		
		nc = c + map[r][c];
		if(check(r,nc)) {
			dp[r][nc] = dp[r][nc] + dp[r][c];
		}
		
	}

	private static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<N;
	}
	
	private static void printDp() {
		System.out.println("==========Print DP Map==========");
		for(int i=0;i<N;i++) {
			System.out.println(Arrays.toString(dp[i]));
		}
	}
}
