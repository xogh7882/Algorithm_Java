import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int result = 0;
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if(a==b) {
				if(a==c) result = Math.max(result, 10000 +(a*1000));
				else result = Math.max(result, 1000+(a*100));
			}
			else if(a==c) {
				if(a==b) result = Math.max(result, 10000 +(a*1000));
				else result = Math.max(result, 1000+(a*100));
			}
			else if(b==c) {
				if(a==c) result = Math.max(result, 10000 +(b*1000));
				else result = Math.max(result, 1000+(b*100));
			}
			else {
				result = Math.max(result, Math.max(c,Math.max(a, b))*100); 
			}
		}
		
		System.out.println(result);
		
	}

}
