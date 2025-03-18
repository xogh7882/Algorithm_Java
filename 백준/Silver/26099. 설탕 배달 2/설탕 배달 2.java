import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Long.parseLong(br.readLine());
		
		long result = 0;
		
		// 5로 나눠지면 끝
		// 그 전까지 3에 하나씩 담기
		
		while(N>=0) {
			if(N%5==0) {
				result += N/5;
                N = 0;
				break;
			}
			result++;
			N = N - 3;
			
		}
		
		if(N==0) System.out.println(result);
		else System.out.println(-1);

	}

}
