import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int map[][];
	static boolean visited[][];
	static int dp[][];
	static int dr[] = {1,-1,0,0};
	static int dc[] = {0,0,1,-1};
	static BufferedReader br;
	public static void main(String[] args) throws Exception{
		br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<M;j++) {
				if(str.charAt(j) == '0') map[i][j] = 0;
				else map[i][j] = 1;
			}
		}
		
		
		visited = new boolean[N][M];
		dp = new int[N][M];
		
		for(int i=0;i<N;i++) {
			Arrays.fill(dp[i], Integer.MAX_VALUE/10);
		}

		BFS();
		
		System.out.println(dp[N-1][M-1]);
		
		
	}
	
	private static void BFS() {
		Deque<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {0,0});
		dp[0][0] = 0;
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			int r = cur[0];
			int c = cur[1];
			
//			System.out.println(r + " : " + c);
//			System.out.println(dp[r][c]);
//			System.out.println();
			
			if(r==N-1 && c==M-1) return;
			
			visited[r][c] = true;
			
			for(int i=0;i<4;i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if(check(nr,nc)==false) continue;
				
				if(dp[nr][nc] > dp[r][c] + map[nr][nc]) {
					dp[nr][nc] = dp[r][c] + map[nr][nc];
					if(map[nr][nc] == 1) {
						queue.add(new int[] {nr,nc});
					}
					else queue.addFirst(new int[] {nr,nc});
				}
				else if(dp[nr][nc] == dp[r][c] + map[nr][nc]  && visited[nr][nc] == false) {
					if(map[nr][nc] == 1) {
						queue.add(new int[] {nr,nc});
					}
					else queue.addFirst(new int[] {nr,nc});
					visited[nr][nc] = true;
				}
				
			}

		}
		
	}

	
	
	private static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<M;
	}



}
