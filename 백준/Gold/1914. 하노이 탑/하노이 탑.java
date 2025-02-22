import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int count = 0;
	static BigInteger result;
	
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		result = new BigInteger("0");	
		BigInteger num1 = new BigInteger("2");
		BigInteger num2 = new BigInteger("1");
		
		if(N<=20) {
			hanoiUnder(N,1,2,3);
			System.out.println(count);
			System.out.print(sb.toString());
		}
		
		else {
			for(int i=1;i<=N;i++) {
				result = result.multiply(num1);
				result = result.add(num2);
			}
			System.out.println(result.toString());
		}
	}

	private static void hanoiUnder(int n, int from, int temp, int to) {
		if(n==0) return;
		hanoiUnder(n-1, from, to, temp);
		sb.append(from).append(" ").append(to).append(" ").append("\n");
		count++;
		hanoiUnder(n-1, temp, from, to);
	}

}
