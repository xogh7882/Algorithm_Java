import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int map[][];
	static boolean visited[][];
	static int dr[] = {1,-1,0,0};
	static int dc[] = {0,0,1,-1};
	static int result = 0;
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited = new boolean[N][M];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				DFS(i,j,0,0);
				DFS2(i,j);     // ㅗ 모양은 DFS 불가
			}
		}
		System.out.println(result);
	}

	private static void DFS2(int r, int c) {
		if(check(r,c-1) && check(r,c+1)) {
			int sum = 0;
			for(int i=0;i<3;i++) {
				sum += map[r][c-1+i];
			}
			if(check(r+1,c)) {
				sum += map[r+1][c];
				result = Math.max(result, sum);
				sum -= map[r+1][c];
			}
			if(check(r-1,c)) {
				sum += map[r-1][c];
				result = Math.max(result, sum);
			}
		}
		
		
		if(check(r-1,c) && check(r+1,c)) {
			int sum = 0;
			for(int i=0;i<3;i++) {
				sum += map[r-1+i][c];
			}
			if(check(r,c+1)) {
				sum += map[r][c+1];
				result = Math.max(result, sum);
				sum -= map[r][c+1];
			}
			if(check(r,c-1)) {
				sum += map[r][c-1];
				result = Math.max(result, sum);
			}
		}
		
	}

	private static void DFS(int r, int c, int k, int sum) {
		if(k==4) {
			result = Math.max(result, sum);
			return;
		}
		visited[r][c] = true;

		for(int i=0;i<4;i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if(check(nr,nc)==true && visited[nr][nc] == false) {
				DFS(nr,nc,k+1,sum+map[nr][nc]);
			}
		}
		
		visited[r][c] = false;
	}

	private static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<M;
	}

	
}
