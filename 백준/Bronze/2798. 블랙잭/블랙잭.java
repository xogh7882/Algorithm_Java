import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	static int N,M;
	static int num[];
	static boolean visited[];
	static int result = -1;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		num = new int[N];
		visited = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		combi(0,0,0);
		
		System.out.println(result);
		
	}

	private static void combi(int cnt, int tot, int start) {
		if(tot > M) return;
		if(cnt == 3) {
			result = Math.max(result, tot);
			return;
		}
		for(int i=start;i<N;i++) {
			if(visited[i]) continue;
			visited[i] = true;
			combi(cnt+1, tot+num[i], i);
			visited[i] = false;
		}
		
	}

}
