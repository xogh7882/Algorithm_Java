import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] fiboResult = new int[10000];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		fibo(0, N);
		System.out.println(fiboResult[N]);
	}

	private static void fibo(int start, int N) {
		while(true) {
			if(start > N) return;
			if(start==0) fiboResult[start] = 1;
			else if(start==1) fiboResult[start] = 1;
			else {
				fiboResult[start] = (fiboResult[start-1] + fiboResult[start-2])%10007;
			}
			start++;
		}
	}
	
	

}
