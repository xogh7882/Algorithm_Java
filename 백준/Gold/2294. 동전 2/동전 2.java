import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N,K;
	static int arr[];
	static int dp[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		
		dp = new int[K+1];
		
		Arrays.fill(dp, 100_001);  // Max = 100_000
		
		dp[0] = 0;    // 0원을 만들기 위해서 동전 0개 필요
		
		
		for(int i=0;i<N;i++) {
			if(arr[i] > K) continue;  // 목표보다 큰 단위는 필요 없음
			for(int j=1;j<=K;j++) {
				if(arr[i] > j) continue;   // 목표보다 큰 단위는 필요없음
				dp[j] = Math.min(dp[j], dp[j-arr[i]] + 1);   // 지금까지 계산한 개수 , 이전에 필요했던 개수 + 1 중 작은 것
			}
//			System.out.println(Arrays.toString(dp));
		}
		
		
		if(dp[K] == 100_001) System.out.println("-1");
		else System.out.println(dp[K]);
		
		
		
	}

}
