import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int map[][];
	static int start = Integer.MAX_VALUE;
	static int end = Integer.MIN_VALUE;
	static int result = 1;
	static int dr[] = {1,-1,0,0};
	static int dc[] = {0,0,1,-1};
	static boolean visited[][];
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				start = Math.min(map[i][j], start);
				end = Math.max(map[i][j], end);
			}
		}
		
		
		for(int i=0;i<=100;i++) {
			visited = new boolean[N][N];
			result = Math.max(result, find(i));
		}
		
		System.out.println(result);
	}


	private static int find(int limit) {
		int sum = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j] > limit && visited[i][j] == false) {
					BFS(i,j,limit);
					sum++;
				}
			}
		}
		return sum;
	}


	private static void BFS(int r, int c, int limit) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {r,c});
		visited[r][c] = true;
		
		while(!queue.isEmpty()) {
			int temp[] = queue.poll();
			int cr = temp[0];
			int cc = temp[1];
			for(int i=0;i<4;i++) {
				int nr = cr + dr[i];
				int nc = cc + dc[i];
				if(check(nr,nc)==true && map[nr][nc] > limit && visited[nr][nc]==false) {
					visited[nr][nc] = true;
					queue.offer(new int[] {nr,nc});
				}
			}
		}
		
	}


	private static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<N;
	}


	
}
