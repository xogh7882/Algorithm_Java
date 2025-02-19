import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,L,R;
	static int map[][];
	static int result;
	static int visited[][];
	static int num[];
	static int dr[] = {1,-1,0,0};
	static int dc[] = {0,0,1,-1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		num = new int[(N*N)+1];
		result = 0;
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		while(true) {
			//printMap();
			visited = new int[N][N];
			if(move() == (N*N)+1) break;
			result++;
		}
		
		//System.out.println("last");
		//printMap();
		System.out.println(result);
	}

	private static void printMap() {
		System.out.println("----------------------------");
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static int move() {
		int g = 1;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(visited[i][j] == 0) {
					BFS(i,j,g);
					g++;
				}
			}
		}
		cover();
		return g;
	}

	private static void cover() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				map[i][j] = num[visited[i][j]];
			}
		}
		
	}

	private static void BFS(int r, int c, int g) {
		int cnt = 0;
		int sum = 0;
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {r,c});
		visited[r][c] = g;
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			int cr = temp[0];
			int cc = temp[1];

			sum += map[cr][cc];
			cnt++;
			//System.out.println("cnt : " + cnt + " / " + cr + " " + cc);
			for(int i=0;i<4;i++) {
				int nr = cr + dr[i];
				int nc = cc + dc[i];
				if(check(nr,nc)==true && visited[nr][nc] == 0 && L <= (Math.abs(map[cr][cc] - map[nr][nc])) && (Math.abs(map[cr][cc] - map[nr][nc])) <= R ) {
					queue.offer(new int[] {nr,nc});
					visited[nr][nc] = g;
				}
			}
		}
		//System.out.println("g : " + g + " sum : " + sum + " cnt : " + cnt);
		num[g] = sum / cnt;
	}

	
	private static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<N;
	}

}
