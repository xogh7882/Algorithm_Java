import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int s,m,e,maxIdx;
	static int map[];
	static int result = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[1001];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			map[idx] = value;
			
			if(i==0) {
				s = idx;
				e = idx;
				m = map[idx];
				maxIdx = idx;
			}
			
			else {
				s = Math.min(s, idx);
				e = Math.max(e, idx);
				if(map[idx] > m) {
					m = map[idx];
					maxIdx = idx;
				}
				
			}
		}
		

		
		
		
		int now = 0;
		
		for(int i=s;i<=maxIdx;i++) {
			if(i==s) {
				now = map[i];
				result += now;
				continue;
			}
			
			if(map[i] < now) {
				result += now;
			}
			else {
				now = map[i];
				result += now;
			}
		}
		
		now = 0;
		
		for(int i=e;i>maxIdx;i--) {
			if(i==e) {
				now = map[i];
				result += now;
				continue;
			}
			
			if(map[i] < now) {
				result += now;
			}
			else {
				now = map[i];
				result += now;
			}
		}
		
		System.out.println(result);
	}

}
