import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());

		long k = gcd(A,B);
		StringBuilder sb = new StringBuilder();
		for(long i = 0 ; i<k;i++) {
			sb.append(1);
		}
		System.out.println(sb.toString());
		
	}
	
	private static long gcd(long a, long b) {
		if(b==0) return a;
		else return gcd(b, a%b);
	}

}
