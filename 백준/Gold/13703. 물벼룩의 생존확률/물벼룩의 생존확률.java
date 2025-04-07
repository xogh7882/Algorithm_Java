import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int k,n;
	static long result = 0;
	static long dp[][];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		k = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		dp = new long[k+n+1][n+1];
		
		for(int i=0;i<k+n+1;i++) {
			Arrays.fill(dp[i], -1);
		}
		
		
		System.out.println(find(k,n));
		
	}
	
	private static long find(int a, int b) {
		if(a==0) {
			dp[a][b] = 0;
			return dp[a][b];
		}
		if(b==0) {
			dp[a][b] = 1;
			return dp[a][b];
		}
		
		if(dp[a][b] != -1) return dp[a][b];
		
		else {
			dp[a][b] = find(a+1,b-1) + find(a-1,b-1);
			return dp[a][b];
		}
		
		
	}
	
}
