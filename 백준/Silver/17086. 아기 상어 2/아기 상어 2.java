import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int map[][];
	static int count[][];
	static int dr[] = {-1,-1,0,1,1,1,0,-1};
	static int dc[] = {0,1,1,1,0,-1,-1,-1};
	static int result;
	static Queue<int[]> queue;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		count = new int[N][M];
		queue = new ArrayDeque<>();
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] ==1) {
					queue.offer(new int[] {i,j});
					count[i][j] = 1;
				}
			}
		}
		
		BFS();
		System.out.println(result-1);
		
	}

	private static void BFS() {
		while(!queue.isEmpty()) {
			int temp[] = queue.poll();
			int r = temp[0];
			int c = temp[1];
			for(int i=0;i<8;i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if(check(nr,nc) && count[nr][nc] == 0) {
					count[nr][nc] = count[r][c] + 1;
					queue.offer(new int[] {nr,nc});
					result = Math.max(result, count[nr][nc]);
				}
			}
		}
		
	}
	
	private static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<M;
	}

}
