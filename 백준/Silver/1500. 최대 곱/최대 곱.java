import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int K = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		if(S==1) {
			System.out.println(K);
			System.exit(0);
		}
		
		int t = K%S;
		
		long result = (long) Math.pow(K/S, S-t);
		for(int i=0;i<t;i++) {
			result *= (K/S)+1;
		}
		System.out.println(result);
	}

}
