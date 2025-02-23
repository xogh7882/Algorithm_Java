import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N,K,P;
	static long temp;
	static int num[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		P = 10007;
		
		// N! * ( (N-K)! * K! ) 을 구한다
		
		num = new int[N+1];
		
		num[0] = 1;
		
		for(int i=1;i<=N;i++) {
			num[i] = (num[i-1] * (i%P))%P;
		}
		//System.out.println(Arrays.toString(num));
		
		// num[N] * (num[N-K] * num[K]) ^ (p-2) )
		
		temp = calc((num[N-K] * num[K]) % P , P-2);
		
		System.out.println((num[N] * temp)%P);
	}

	private static long calc(int down, int up) {
		if(up==0) return 1;
		if(up==1) return down;
		if(up%2==0) {
			return ((calc(down, up/2)%P) * (calc(down, up/2)%P))%P;
		}
		else {
			return (down%P * (calc(down, (up-1)/2)%P) * (calc(down, (up-1)/2)%P)%P);
		}
	}

}
