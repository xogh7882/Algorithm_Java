import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			int age = Integer.parseInt(st.nextToken());
			int kilo = Integer.parseInt(st.nextToken());
			
			if(name.equals("#")) break;
			
			sb.append(name).append(" ");
			if(age > 17 || kilo >= 80) sb.append("Senior");
			else sb.append("Junior");
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

}
