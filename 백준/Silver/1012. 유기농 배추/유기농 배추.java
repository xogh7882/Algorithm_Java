import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int T;
	static int M,N,K;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		
		for(int test_case = 0 ; test_case < T ; test_case++ ) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[M][N];
			for(int i=0;i<K;i++) {
				st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				map[r][c] = 1;
			}
			int count = 0;
			visited = new boolean[M][N];
			//mapPrint();
			for(int i=0;i<M;i++) {
				for(int j=0;j<N;j++) {
					if(map[i][j] == 1 && visited[i][j] == false) {
						count++;
						BFS(i,j);
					}
				}
			}
			System.out.println(count);
			
		}
	}
	
	
	
	private static void BFS(int r, int c) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {r,c});
		while(!queue.isEmpty()) {
			int temp[] = queue.poll();
			for(int i=0;i<4;i++) {
				int nr = temp[0] + dr[i];
				int nc = temp[1] + dc[i];
				if(check(nr,nc) && map[nr][nc] == 1 && visited[nr][nc] == false) {
					visited[nr][nc] = true;
					queue.offer(new int[] {nr,nc});
				}
			}
		}
	}
	
	
	private static boolean check(int r, int c) {
		return r>=0 && r<M && c>=0 && c<N;
	}



	private static void mapPrint() {
		for(int i=0;i<M;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		
		
	}

}
