import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		int count = 0;
		int time = 0;
		int cur = m;
		if(m+T > M) {
			System.out.println(-1);
			System.exit(0);
		}
		while(true) {
			if(count==N) break;
			if(cur+T <= M) {
				cur += T;
				count++;
			}
			else {
				cur -= R;
				if(cur < m) cur = m;
			}

			time++;
		}
		
		System.out.println(time);
	}

}
