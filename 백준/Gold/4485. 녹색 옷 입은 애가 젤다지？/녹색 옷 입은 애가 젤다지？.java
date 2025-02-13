import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int cnt = 1;
	static StringTokenizer st;
	static int N;
	static int[][] map;
	static int[][] cost;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};

	
	static class Cell implements Comparable<Cell>{
		int r;
		int c;
		int cost;
		public Cell(int r, int c, int cost) {
			super();
			this.r = r;
			this.c = c;
			this.cost = cost;
		}
		public Cell() {

		}
		@Override
		public int compareTo(Cell o) {
			return Integer.compare(this.cost, o.cost);
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			if(N == 0) break;
			
			map = new int[N][N];
			cost = new int[N][N];
			for(int i=0;i<N;i++) {
				Arrays.fill(cost[i], Integer.MAX_VALUE/100);
			}
			
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int result = bfs();
			
			System.out.println("Problem " + (cnt++) + ": " + result);

		}
	}

	
	static int bfs() {
		PriorityQueue<Cell> que = new PriorityQueue<>();
		que.offer(new Cell(0,0,map[0][0]));
		cost[0][0] = map[0][0];
		while(!que.isEmpty()) {
			Cell cur = que.poll();
			int cr = cur.r;
			int cc = cur.c;
			if(cost[cr][cc] < cur.cost) continue;
			for (int d = 0; d < 4; d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				if(!check(nr,nc)) continue;
				if(cost[nr][nc] > cost[cr][cc]+map[nr][nc]) {
					cost[nr][nc] = cost[cr][cc] + map[nr][nc];
					que.offer(new Cell(nr,nc, map[nr][nc]));
				}
			}
		}
		return cost[N-1][N-1];
	}


	private static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<N;
	}

}
