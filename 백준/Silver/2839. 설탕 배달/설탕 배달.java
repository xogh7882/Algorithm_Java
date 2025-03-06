import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		int count5 = 0;
		int count3 = 0;
		int sum = 0;
		
		count5 = N / 5;
		sum = count5 * 5;
		
		aa:while(true) {
			if(count5 < 0) {
				count5 = 0;
				count3 = -1;
				break;
			}
			
			sum = count5 * 5;
			count3 = 0;
			while(true) {
				if(sum == N) break aa;
				if(sum > N) break;
				sum += 3;
				count3++;
			}
			
			count5--;
		}
		
		System.out.println(count5 + count3);
	}

}
