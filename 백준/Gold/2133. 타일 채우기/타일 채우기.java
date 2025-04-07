import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static long dp[];
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		dp = new long[N+1];
		dp[0] = 1;
		
		find(N);
		
		if(N%2!=0) System.out.println(0);
		else System.out.println(dp[N]);
		
	}


	private static long find(int n) {
		if(n<2) return 0;
		if(n==2) {
			dp[n] = 3;
			return dp[n];
		}
		
		if(dp[n] != 0) return dp[n];
		else {
			dp[n] = find(n-2) * 3;
			for(int i=n-4;i>=0;i--) {
				dp[n] += dp[i] * 2;
			}
			return dp[n];
		}
		
	}

}
