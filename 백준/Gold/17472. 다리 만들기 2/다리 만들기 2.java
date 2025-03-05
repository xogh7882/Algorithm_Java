import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int map[][];
	static boolean visited[][];
	static int dr[] = {1,-1,0,0};
	static int dc[] = {0,0,1,-1};
	static int g;
	static int arr[][];
	
	static class Edge implements Comparable<Edge>{
		int s;
		int e;
		int w;
		
		public Edge(int s, int e, int w) {
			super();
			this.s = s;
			this.e = e;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.w, o.w);
		}
		
	}
	
	static PriorityQueue<Edge> points;
	static int[] p;
	static int[] r;
	static int min;
	static int cnt;
	
	public static void main(String[] args) throws Exception {
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
		
		
		// 섬 나누기
		visited = new boolean[N][M];
		g = 2;  // 같은 그룹
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(visited[i][j] == false && map[i][j] == 1) {
					BFS(i,j,g);
					g++;
				}
			}
		}
		
//		printMap();

		// 섬 개수만큼 배열 할당
		arr = new int[g][g];
		for(int i=0;i<g;i++) {
			Arrays.fill(arr[i], Integer.MAX_VALUE);
		}
		

		// 다리 놓기
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				checkWater(i,j,map[i][j]);
			}
		}
		
		
		// 보기 편하게 0으로 바꿔주기
		for(int i=2;i<g;i++) {
			for(int j=2;j<g;j++) {
				if(arr[i][j] == Integer.MAX_VALUE) arr[i][j] = 0;
			}
		}
		
//		printArr();
		
		points = new PriorityQueue<>();
		// MST로 만들기
		for(int i=2;i<g;i++) {
			for(int j=2;j<g;j++) {
				if(arr[i][j] != 0) {
					points.offer(new Edge(i,j,arr[i][j]));
				}
			}
		}
		
		if(points.isEmpty()) min = -1;
		
		else {
			makeset();
			cnt = 0;
			min = 0;
			
			while(!points.isEmpty()) {  // 2번부터 g-1 까지
				Edge edge = points.poll();
				if(union(edge.s, edge.e)) {
					cnt++;
					min += edge.w;
				}
			}
		}
//		System.out.println("g : " + g + ", cnt : " + cnt);
		if(cnt != g-1-2) min = -1;
		System.out.println(min);
	}
	
	
	private static boolean union(int x, int y) {
		x = find(x);
		y = find(y);
		if(x==y) return false;
		if(r[x] < r[y]) {
			r[y] += r[x];
			p[x] = y;
		}
		else {
			r[x] += r[y];
			p[y] = x;
		}
		return true;
	}


	private static int find(int x) {
		if(x == p[x]) return p[x];
		else return find(p[x]);
	}


	private static void makeset() {
		p = new int[g];
		r = new int[g];
		for(int i=0;i<g;i++) {
			p[i] = i;
			r[i] = 1;
		}
		
	}


	private static void checkWater(int r, int c, int g) {
		for(int i=0;i<4;i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if(check(nr,nc) == true && map[nr][nc] == 0) {
				int cost = 1;
				while(true) {
					if(check(nr,nc) == false || map[nr][nc] == g) break;
					if(map[nr][nc] != g && map[nr][nc] != 0) {
						if(cost > 2) {
							arr[g][map[nr][nc]] = Math.min(arr[g][map[nr][nc]], cost-1);
							break;
						}
						else break;
					}
					nr += dr[i];
					nc += dc[i];
					cost++;
				}
			}
		}
	}


	private static void printArr() {
		System.out.println("===========Print Arr=============");
		for(int i=2;i<g;i++) {
			for(int j=2;j<g;j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}


	private static void printMap() {
		System.out.println("===========Print Map===========");
		for(int i=0;i<N;i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		System.out.println();
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
		return r>=0 && r<N && c>=0 && c<M;
	}

}
