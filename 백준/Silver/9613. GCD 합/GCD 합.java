import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int T;
	static int N;
	static int arr[];
	static int p[];
	static boolean visited[];
	static long result;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		for(int test = 1 ; test<= T ; test++)
		{
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			arr = new int[N];
			visited = new boolean[N];
			p = new int[2];
			
			for(int i=0;i<N;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			result = 0;
			
			for(int i=0;i<N-1;i++) {
				for(int j=i+1;j<N;j++) {
					result += gcd(arr[i], arr[j]);
				}
			}
			
			System.out.println(result);
			
		}

	}


	private static int gcd(int a, int b) {
		if(b==0) return a;
		else return gcd(b, a%b);
	}


}
