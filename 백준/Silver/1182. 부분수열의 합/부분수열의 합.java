import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,S;
	static int num[];
	static boolean visited[];
	static int count = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		num = new int[N];
		visited = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		subset(0);
		
		System.out.println(count);
	}
	private static void subset(int cnt) {
		if(cnt == N) {
			calc();
			return;
		}
		
		visited[cnt] = true;
		subset(cnt+1);
		visited[cnt] = false;
		subset(cnt+1);
	}
	private static void calc() {
		int cnt = 0;
		int sum = 0;
		for(int i=0;i<N;i++) {
			if(visited[i]) {
				sum += num[i];
				cnt++;
			}
		}
		if(sum == S && cnt > 0) count++;
	}
	
}
