import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int arr[];
	static int result = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		int s = 0;
		int e = 1;
		
		while(true) {
			if(s==N) break;
			if(arr[e] - arr[s] >= M) {
				result = Math.min(result, arr[e] - arr[s]);
				s++;
			}
			else {
				if(e+1 == N) s++;
				else e++;
			}
		}

		System.out.println(result);
	}

}
