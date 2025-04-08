import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int arr[];
	static int dp[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N];
		dp = new int[N];
		
		int max = 1;
		
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dp[i] = 1;
			for(int j=0;j<i;j++) {
				if(arr[j] > arr[i] && dp[i] < dp[j] + 1) {
					dp[i] = dp[j] + 1;
				}
				max = Math.max(max, dp[i]);
			}
			
		}
		
		
		System.out.println(max);
	}

}
