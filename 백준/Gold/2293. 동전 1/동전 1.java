import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N,K;
	static int coin[];
	static int dp[][];
	static int result = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		coin = new int[N+1];
		
		for(int i=1;i<=N;i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		
		dp = new int[N+1][K+1];
		for(int i=0;i<=N;i++) {
			dp[i][0] = 1;
		}
		
		for(int i=1;i<=N;i++) {
			for(int j=0;j<=K;j++) {
				if(j-coin[i] < 0) dp[i][j] = dp[i-1][j];
				else {
					dp[i][j] = dp[i-1][j] + dp[i][j-coin[i]];
				}
			}
		}
		
		
		
		System.out.println(dp[N][K]);
	}
	

}
