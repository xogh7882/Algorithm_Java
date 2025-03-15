import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int N;
	static int dp[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		dp = new int[N+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		
		dp[N] = 0;
		
		for(int i=N;i>0;i--) {
			if(i%3==0) dp[i/3] = Math.min(dp[i/3], dp[i] + 1);
			if(i%2==0) dp[i/2] = Math.min(dp[i/2], dp[i] + 1);
			dp[i-1] = Math.min(dp[i-1], dp[i]+1);
			
//			System.out.println(i + "============================================");
//			System.out.println(Arrays.toString(dp));
			
		}
		
		System.out.println(dp[1]);
		
	}

}
