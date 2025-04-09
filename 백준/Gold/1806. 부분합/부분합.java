import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int result;
	static int maxInt = Integer.MAX_VALUE/10;
	static int arr[];
	static long value;
	
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
		int e = -1;
		value = 0L;
		result = maxInt;
		
		for(int i=0;i<N;i++) {
			e++;
			value += arr[e];
			if(value >= M) result = Math.min(result, e-s+1);
			
			while(true) {
				if(s>e || value < M) break;
				if(value >= M) result = Math.min(result, e-s+1);
				value -= arr[s];
				s++;
			}
		}
		
		if(result == maxInt) result = 0;
		System.out.println(result);
		
	}

}
