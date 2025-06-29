import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static long T[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		T = new long[N];
		
		for(int i=0;i<N;i++) {
			T[i] = Long.parseLong(br.readLine());
		}
		
		Arrays.sort(T);
		
		long left = 0;
		long right = T[N-1]*(long)M;
		
		while(true) {
			if(left > right) break;
			
			long time = (left + right) / 2;
			
//			System.out.println("time : " + time);
			
			if(check(time) >= M) {
				right = time-1;
			}
			else {
				left = time+1;
			}
			
//			System.out.println("left : " + left + " | right : " + right + " | num : " + check(time) );
		}
		
		
		System.out.println(left);
	
	}

	private static long check(long time) {
		long result = 0;
		
		for(int i=0;i<N;i++) {
			long now = time / T[i];
			if(result > M - now) {
				result = M;
				break;
			}
			result += now;
		}
		
		return result;
	}


}
