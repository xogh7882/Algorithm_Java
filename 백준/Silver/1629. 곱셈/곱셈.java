import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static long A,B,C;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		System.out.println(calc(A,B));
	}
	
	
	private static long calc(long A, long B) {
		if(B==1) return A%C;
		if(B%2==0) {
			long x = calc(A,B/2)%C;
			return (x*x)%C;
		}
		else {
			long x = calc(A,(B-1)/2)%C;
			return (((A*x)%C)*x)%C;
		}
	}

}
