import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int T;
	static int N;
	
	static int score[];
	
	static int result;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1 ; test_case <= T ; test_case ++ ) 
		{
			result = 0;
			N = Integer.parseInt(br.readLine());
			score = new int[N+1];
			
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				score[a] = b;
			}
			int min = N+1;
			for(int i=1;i<=N;i++) {
				if(score[i] < min) {
					min = score[i];
					result++;
				}
				if(min==1) break;
			}
			
			sb.append(result).append("\n");
		}
		System.out.println(sb.toString());
	}

}
