import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

// 빈 공간을 기준으로 BFS 돌린다
// 그걸로 빈 공간의 사이즈 체크
// 그 공간이랑 만나는 벽을 다른 큐에 넣는다
// 그 벽에 사이즈를 더해주면 그 벽이 부서졌을때 갈 수 있는 크기!!!!!!

public class Main {
	static int N,M;
	static int map[][];
	static boolean visited[][];
	static int dr[] = {1,-1,0,0};
	static int dc[] = {0,0,1,-1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<M;j++) {
				if(str.charAt(j) == '0') map[i][j] = 0;
				else map[i][j] = 1;
			}
		}
		
		visited = new boolean[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j] == 0 && visited[i][j] == false) {
					BFS(i,j);
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				sb.append(map[i][j]%10);
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
		
	}


	private static void BFS(int startR, int startC) {
		Queue<int[]> queue = new ArrayDeque<>();
		Queue<int[]> wall = new ArrayDeque<>();
		
		queue.offer(new int[] {startR, startC});
		
		int size = 0;
		
		while(!queue.isEmpty()) {
			int temp[] = queue.poll();
			int r = temp[0];
			int c = temp[1];
			size++;
			visited[r][c] = true;
			for(int i=0;i<4;i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if(check(nr,nc) && map[nr][nc] == 0 & visited[nr][nc] == false) {
					visited[nr][nc] = true;
					queue.offer(new int[] {nr,nc});
				}
				else if(check(nr,nc) && map[nr][nc] != 0 && visited[nr][nc] == false) {
					visited[nr][nc] = true;
					wall.offer(new int[] {nr,nc});
				}
			}
		}
		
		while(!wall.isEmpty()) {
			int temp[] = wall.poll();
			int r = temp[0];
			int c = temp[1];
			map[r][c] += size;
			visited[r][c] = false;
		}
	}


	private static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<M;
	}
}
