import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int arr[];
	static int sum[];
	static int result = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		sum = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if(i==0) {
				sum[i] = arr[i];
			}
			else {
				sum[i] = Math.max(sum[i-1] + arr[i] , arr[i]);
			}
			result = Math.max(result, sum[i]);
		}
		
		
//		System.out.println(Arrays.toString(sum));
		
		System.out.println(result);
	}

}
