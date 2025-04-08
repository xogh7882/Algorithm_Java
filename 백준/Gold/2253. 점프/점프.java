import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int arr[];
	static int result = -1;
	static int dp[][];

	static int maxInt = Integer.MAX_VALUE/10;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1];
		
		dp = new int[N+1][150];

		
		for(int i=0;i<M;i++) {
			int k = Integer.parseInt(br.readLine());
			arr[k] = -1;
		}
		

		dp[2][1] = find(2,1);
	
		if(dp[2][1] >= maxInt) System.out.println(-1);
		else System.out.println(dp[2][1] + 1);	
		
	}

	private static int find(int a, int b) {
		if(a > N || arr[a] == -1) {
			return maxInt;
		}
		
		if(a==N) {
			dp[a][b] = 0;
			return dp[a][b];
		}
		
		if(dp[a][b] != 0 ) return dp[a][b];
		
		if(b==1) {
			dp[a][b] =  Math.min(find(a+b,b)+1 ,find(a+(b+1) , b+1) + 1 );
			return dp[a][b];
		}
		else {
			dp[a][b] = Math.min( find(a+b,b)+1 ,Math.min( find(a+(b+1),b+1)+1 , find(a+(b-1), b-1 )+1 ));
			return dp[a][b];
		}
		
	}
	
}
