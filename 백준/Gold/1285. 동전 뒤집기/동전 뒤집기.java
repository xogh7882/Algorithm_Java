import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static boolean map[][];
	static boolean visited[];
	static int result = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new boolean[N][N];
		
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<N;j++) {
				if(str.charAt(j) == 'H') map[i][j] = true;
				else map[i][j] = false;
			}
		}
		
		// 가로부터 뒤집을 수 있는 경우의 수 ( 8개 = 2^3 ) -> x 각 열을 하는게 나을지 안하는게 나을지
		// 해서 최솟값?
		
		visited = new boolean[N];
		
		subset(0);
		
		System.out.println(result);
		
	}
	
	private static void subset(int cnt) {
		if(cnt == N) {
			result = Math.min(result, calc());
			return;
		}
		
		visited[cnt] = true;
		subset(cnt+1);
		visited[cnt] = false;
		subset(cnt+1);
		
	}

	private static int calc() {
		
		for(int i=0;i<N;i++) {
			if(visited[i] == true) changeRow(i);
		}
		
		int cnt = 0;
		
		for(int i=0;i<N;i++) {
			int now = 0;
			for(int j=0;j<N;j++) {
				if(map[j][i] == true) now++;
			}
			cnt += Math.min(now, N-now);
		}
		
		for(int i=0;i<N;i++) {
			if(visited[i] == true) changeRow(i);
		}
		
		return cnt;
	}

	
	
	private static void changeRow(int r) {
		for(int i=0;i<N;i++) {
			if(map[r][i] == true) map[r][i] = false;
			else map[r][i] = true;
		}
	}
	
}
