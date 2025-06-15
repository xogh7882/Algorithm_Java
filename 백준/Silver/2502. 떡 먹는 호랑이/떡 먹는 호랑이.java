import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	static int D,K;
	static int A,B;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		D = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		

		A = 1;
		B = A;
		
		while(true) {
			if(check(A,B,1) == 0) break;
			else if(check(A,B,1) == 1) {
				B++;
			}
			else {
				A++;
				B = A;
			}
		}
		
		System.out.println(A + "\n" + B);

	}
	
	// 만약 day가 모자라면 B를 늘리고
	// 만약 day 전에 이미 숫자가 넘어가면 A를 늘리고 B는 A로
	
	private static int check(int a, int b, int day) {
//		System.out.println(a + " : " + b);
		
		while(true) {
			if(a == K && day == D) return 0;
			
			else if(a > K) {
				if(day < D) return 2;
				else return 1;
			}
			
			else {
				int c = a + b;
				a = b;
				b = c;
				day++;
			}
		}
	}

}
