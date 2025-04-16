import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static long sum;
	static int arr[];
	static int result = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int s = 0;
		int e = 0;
		sum = arr[s];
		
		while(true) {
//			System.out.println(s + " , " + e + " , " + sum);
			if(e==N) break;
			
			if(sum == M) {
				result++;
				sum -= arr[s];
				s++;
				e++;
				if(e==N) break;
				sum += arr[e];
				
			}
			else if(sum > M) {
				sum -= arr[s];
				s++;
			}
			else {
				e++;
				if(e==N) break;
				sum += arr[e];
			}
		}
		System.out.println(result);
	}

}
