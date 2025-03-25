import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int J;
	static int result;
	static int s,e;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		s=1;
		e=s+(M-1);
		
		
		J = Integer.parseInt(br.readLine());
		
		for(int i=0;i<J;i++) {
			int k = Integer.parseInt(br.readLine());
			
			while(true) {
				if(s<=k && k<=e) {
					break;
				}
				else if(k<s) {
					s--;
					e--;
					result++;
				}
				else {
					s++;
					e++;
					result++;
				}
			}
			
		}
		
		System.out.println(result);
		

	}

}
