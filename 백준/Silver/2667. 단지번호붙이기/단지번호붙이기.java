import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] map;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for(int i=0;i<N;i++) {
			char[] chr = br.readLine().toCharArray();
			for(int j=0;j<N;j++) {
				map[i][j] = chr[j] - '0';
			}
		}
		
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 1) {
					cnt++;
					bfs(i,j,cnt+1);
					//dfs(i,j,cnt+1);
				}
			}
		}
		
		System.out.println(cnt);
		int[] count = new int[cnt];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j] != 0) {
					count[map[i][j]-2]++;
				}
			}
		}
		Arrays.sort(count);
		for(int i=0;i<count.length;i++) {
			System.out.println(count[i]);
		}
		
	}
	
	private static void bfs(int cr, int cc, int group) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {cr,cc});
		map[cr][cc] = group;
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			int r = temp[0];
			int c = temp[1];
			for(int i=0;i<4;i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if(!check(nr,nc)) continue;
				if(map[nr][nc] == 1) {
					map[nr][nc] = group;
					queue.offer(new int[] {nr,nc});
				}
			}
		}
		
	}
	private static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<N;
	}
	
	
	private static void dfs(int cr, int cc, int g) {
		map[cr][cc] = g;
		for(int i=0;i<4;i++) {
			int nr = cr + dr[i];
			int nc = cc + dc[i];
			if(!check(nr,nc)) continue;
			if(map[nr][nc] == 1) {
				map[nr][nc] = g;
				dfs(nr,nc,g);
			}
		}
	}
	
}
