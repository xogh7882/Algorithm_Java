import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int map[][];
	static boolean visited[][];
	static int dr[] = {1,-1,0,0};
	static int dc[] = {0,0,1,-1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 섬 나누기
		visited = new boolean[N][N];
		int g = 2;  // 같은 그룹
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(visited[i][j] == false && map[i][j] == 1) {
					BFS(i,j,g);
					g++;
				}
			}
		}
		
//		printMap();
		
		int result = Integer.MAX_VALUE;
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(checkbridge(i,j) == true && map[i][j] != 0) {
					visited = new boolean[N][N];
					result = Math.min(result,bridge(i,j,map[i][j]));
				}
			}
		}
		
		System.out.println(result-1);

	}

	private static int bridge(int r, int c, int g) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {r,c});
		visited[r][c] = true;
		int size = queue.size();
		int time = 0;
		
		while(!queue.isEmpty()) {
			if(size==0) {
				size = queue.size();
				time++;
			}
			int temp[] = queue.poll();
			int cr = temp[0];
			int cc = temp[1];
			size--;
			if(map[cr][cc] != 0 && map[cr][cc] != g) return time;
			for(int i=0;i<4;i++) {
				int nr = cr + dr[i];
				int nc = cc + dc[i];
				if(check(nr,nc) == true && map[nr][nc] != g && visited[nr][nc] == false) {
					visited[nr][nc] = true;
					queue.offer(new int[] {nr,nc});
				}
			}
		}
		return Integer.MAX_VALUE;
	}

	private static boolean checkbridge(int r, int c) {
		for(int i=0;i<4;i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if(check(nr,nc) == true && map[nr][nc]==0) return true;
		}
		return false;
	}

	private static void printMap() {
		System.out.println("===============================");
		for(int i=0;i<N;i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		
	}

	private static void BFS(int r, int c, int g) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {r,c});
		visited[r][c] = true;
		map[r][c] = g;
		
		while(!queue.isEmpty()) {
			int temp[] = queue.poll();
			int cr = temp[0];
			int cc = temp[1];
			for(int i=0;i<4;i++) {
				int nr = cr + dr[i];
				int nc = cc + dc[i];
				if(check(nr,nc)==true && map[nr][nc] == 1 && visited[nr][nc] == false) {
					visited[nr][nc] = true;
					map[nr][nc] = g;
					queue.offer(new int[] {nr,nc});
				}
			}
		}
		
		
	}

	private static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<N;
	}

}
