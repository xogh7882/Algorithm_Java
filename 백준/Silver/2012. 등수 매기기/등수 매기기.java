import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main{

	static int N;
	static boolean rank[];
	static int arr[];
	static long result = 0;
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		rank = new boolean[N+1];
		
		arr = new int[500_001];
		Arrays.fill(arr, 500_001);
		
		int cnt = 0;
		for(int i=1;i<=N;i++) {
			int t = Integer.parseInt(br.readLine());
			if(t > N) arr[cnt++] = t;
			else if(rank[t] == false) rank[t] = true;
			else {
				arr[cnt++] = t;
			}
		}
		
		Arrays.sort(arr);
		
		cnt = 0;
		for(int i=1;i<=N;i++) {
			if(rank[i] == false) {
				result+=Math.abs(i-arr[cnt++]);
			}
		}
		
		System.out.println(result);
	}

}
