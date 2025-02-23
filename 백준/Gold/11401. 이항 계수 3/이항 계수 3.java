import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N,K,P;
	static long temp;
	static long num[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		P = 1_000_000_007;
		
		// N! * ( (N-K)! * K! ) 을 구한다
		
		num = new long[N+1];
		
		num[0] = 1;
		
		for(int i=1;i<=N;i++) {
			num[i] = (num[i-1] * i)%P;
		}
		
		// num[N] * (num[N-K] * num[K]) ^ (p-2) )
		
		temp = calc((num[N-K] * num[K]) % P , P-2);
		
		System.out.println((num[N] * temp%P)%P);
	}

	private static long calc(long down, long up) {
		if(up==1) return down;
		
		if(up%2==0) {
			long x = calc(down, up/2)%P;
			return (x*x)%P;
		}
		
		else {
			long x = calc(down,(up-1)/2)%P;
			return (((down%P * x%P)%P) * x%P)%P;
		}
	}

}
