import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N = 26;  // 알파벳 개수
	static int num[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		// 앞뒤가 똑같은 문자열
		// 1. 모든 문자 개수가 짝수
		// 2. 문자 한개만 홀수, 나머지는 싹다 짝수
		// 여러개이면 사전순
		
		num = new int[N];
		
		for(int i=0;i<str.length();i++) {
			num[str.charAt(i)-'A']++;
		}
		
		int odd = 0;
		int oddIdx=-1;
		char oddChar = ' ';
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<N;i++) {
			if(num[i] % 2 ==1) {
				odd++;
				oddIdx = i;
			}
		}
		
		if(odd>1) System.out.println("I'm Sorry Hansoo");
		else {
			if(oddIdx!=-1) {
				oddChar = (char)('A'+oddIdx);
				num[oddIdx]--;
			}
			for(int i=0;i<N;i++) {
				if(num[i] > 0) {
					for(int j=0;j<num[i]/2;j++) {
						sb.append((char)('A'+i));
					}
				}
			}
			if(oddIdx!=-1) sb.append(oddChar);
			
			for(int i=N-1;i>=0;i--) {
				if(num[i] > 0) {
					for(int j=0;j<num[i]/2;j++) {
						sb.append((char)('A'+i));
					}
				}
			}
			System.out.println(sb.toString());
		}
		
	}

}
