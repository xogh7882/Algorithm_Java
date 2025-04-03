import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
	static int N;
	static long result[];
	static long count[][];
	static int cnt = 0;
	static long div = 1_000_000_000;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		result = new long[N+1];
		count = new long[N+1][10];
		
		for(int i=1;i<=N;i++) {
			if(i==1) {
				result[i] = 9;
				for(int j=1;j<10;j++) {
					count[i][j] = 1;
				}
			}
			
			else {
				cnt = 0;
				for(int j=0;j<10;j++) {
					if(j==0) {
						count[i][j] = count[i-1][j+1];
					}
					else if(j==9) {
						count[i][j] = count[i-1][j-1];
					}
					else {
						count[i][j] = (count[i-1][j-1] + count[i-1][j+1]);
					}
					
					count[i][j] %= div;
				}
				
				
				
				result[i] = ((( result[i-1] - count[i-1][9] - count[i-1][0]) * 2) + div ) % div;
				result[i] += (count[i-1][9] + count[i-1][0]);
				
			}
		}
				
		System.out.println(result[N]%div);
		
	}

}

// % 연산을 할 때, 음수가 나올 수 있으므로 div를 더하고 % 를 계산한다
// -> 무조건 양수
