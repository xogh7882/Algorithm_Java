import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,K;
	static int arr[];
	static int max;
	static long result;
	
	static long s;
	static long e;
	static long mid;
	static int cnt = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		max = Integer.MIN_VALUE;
		
		arr = new int[K];
		
		for(int i=0;i<K;i++) {
			arr[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, arr[i]);
		}

		
		result = -1;

		s = 1;
		e = max;
		
		while(true) {
//			System.out.println(mid);
			cnt = 0;
			if(s > e) break;
			mid = (s+e)/2;
			cnt = calc();
			
			if(cnt >= N) {   // 너무 잘게 잘랐어
				result = Math.max(result, mid);
				s = mid + 1;
			}
			else {
				e = mid - 1;
			}
		}
		
		System.out.println(result);
	}

	private static int calc() {
		int sum = 0;
		
		for(int i=0;i<K;i++) {
			sum += arr[i] / mid;
		}
		
		return sum;
	}

}
