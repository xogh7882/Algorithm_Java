import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] sour;
	static int[] bitter;
	static boolean[] visited;
	static int result = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		visited = new boolean[N];
		sour = new int[N];
		bitter = new int[N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			sour[i] = Integer.parseInt(st.nextToken());
			bitter[i] = Integer.parseInt(st.nextToken());
		}
	
		subset(0);
		
		System.out.println(result);
		
	}

	private static void subset(int cnt) {
		if(cnt == N ) {
			int sourSum = 1;
			int bitterSum = 0;
			for(int i=0;i<N;i++) {
				if(visited[i]) {
					sourSum *= sour[i];
					bitterSum += bitter[i];
				}
			}
			if(sourSum == 1 || bitterSum == 0) return;
			if(Math.abs(sourSum - bitterSum) < result ) result = (Math.abs(sourSum - bitterSum));
			return;
		}
		
		visited[cnt] = true;
		subset(cnt+1);
		visited[cnt] = false;
		subset(cnt+1);
	}

		
}
