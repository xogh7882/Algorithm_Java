import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int t=0;t<3;t++) {
			int N = Integer.parseInt(br.readLine());
			BigInteger sum = new BigInteger("0");
			for(int i=0;i<N;i++) {
				BigInteger s = new BigInteger(br.readLine());
				sum = sum.add(s);
			}
			if(sum.equals(BigInteger.ZERO)) sb.append(0);
			else if(sum.compareTo(BigInteger.ZERO) < 0) sb.append("-");
			else sb.append("+");
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

}
