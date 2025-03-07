import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,M,K;
	static boolean map[][];
	static boolean visited[][];
	static int dr[] = {1,-1,0,0};
	static int dc[] = {0,0,1,-1};
	static int result = 0;
	
	static int startR, startC, endR, endC;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new boolean[N][M];
		
		// 스타트는 (N-1, 0)
		// 도착은 (0,M-1)
		
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<M;j++) {
				if(str.charAt(j) == '.') map[i][j] = true;
				else map[i][j] = false;
			}
		}
		
		visited = new boolean[N][M];
		
		startR = N-1; startC = 0;
		endR = 0; endC = M-1;
		
		visited[startR][startC] = true;
		DFS(startR, startC, 0);
		
		System.out.println(result);
	}

	private static void DFS(int r, int c, int cnt) {
		if(r==endR && c==endC) {
			if(cnt+1==K) result++;
			return;
		}
		
		for(int i=0;i<4;i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if(check(nr,nc) == true && visited[nr][nc] == false && map[nr][nc] == true) {
				visited[nr][nc] = true;
				DFS(nr,nc,cnt+1);
				visited[nr][nc] = false;
			}
		}
	}

	private static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<M;
	}

}
