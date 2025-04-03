import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static long fibo[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		fibo = new long[N+1];
		
		
		for(int i=1;i<=N;i++) {
			if(i==1) fibo[i] = 1;
			else if(i==2) fibo[i] = 1;
			else {
				fibo[i] = fibo[i-1] + fibo[i-2];
			}
		}
		System.out.println(fibo[N]);
		
	}

}
