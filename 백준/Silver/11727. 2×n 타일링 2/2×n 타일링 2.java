import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static int arr[];
	static int mod = 10_007;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1];
		
		for(int i=1;i<=N;i++) {
			if(i==1) arr[i] = 1;
			else if(i==2) arr[i] = 3;
			else {
				arr[i] = ( arr[i-2]*2 ) + arr[i-1];
				arr[i] %= mod;
			}
		}
		System.out.println(arr[N]);
	}

}
