import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N,K,W,V;

	static int dp[][];
	static int weight[];
	static int profits[];
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		weight = new int[N+1];
		profits = new int[N+1];
		
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			weight[i] = Integer.parseInt(st.nextToken());
			profits[i] = Integer.parseInt(st.nextToken());
		}
		
		dp = new int[N+1][K+1];
		
		for(int i=1;i<=N;i++) {
			for(int w=1;w<=K;w++) {
				
				if(weight[i] <= w) {
					dp[i][w] = Math.max(dp[i-1][w], dp[i-1][w-weight[i]] + profits[i]);
				}else {
					dp[i][w] = dp[i-1][w];
				}
				
			}
		}
		
		System.out.println(dp[N][K]);
	}
}
