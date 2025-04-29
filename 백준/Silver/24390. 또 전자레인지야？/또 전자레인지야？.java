import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int M,S;
	static int result;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), ":");
		
		M = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
//		System.out.println(M + " : " + S);
		
		int total = M * 60 + S;
		int flag = 0;
		
		if(total / 600 > 0) {
			result += total / 600;
			total %= 600;
		}
		
		if(total / 60 > 0) {
			result += total / 60;
			total %= 60;
		}
		
		if(total /30 > 0) {
			result += total / 30;
			total %= 30;
			flag ++;
		}
		
		if(total != 0) {
			result += total / 10;
		}
		
		if(flag==0) result++;
		
		System.out.println(result);
	}

}


// 10, 60, 600, (조리시작 - 0일때 +30)