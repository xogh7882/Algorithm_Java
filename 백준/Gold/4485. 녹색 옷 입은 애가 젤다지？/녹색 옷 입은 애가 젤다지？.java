import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int num = 1;
	static int map[][];
	static int cost[][];
	static int dr[] = {0,1,0,-1};
	static int dc[] = {1,0,-1,0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		while(true) {

			N = Integer.parseInt(br.readLine());
			if(N==0) break;
			map = new int[N][N];
			cost= new int[N][N];
			
			for(int i=0;i<N;i++) {
				Arrays.fill(cost[i], Integer.MAX_VALUE/10);
			}
			
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int result = BFS();
			sb.append("Problem ").append(num).append(": ").append(result).append("\n");
			num++;
			
//			System.out.println("=====================================");
//			for(int i=0;i<N;i++) {
//				System.out.println(Arrays.toString(cost[i]));
//			}
			
		}
		
		System.out.println(sb.toString());

	}


	private static int BFS() {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {0,0});
		cost[0][0] = map[0][0];
		
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			int r = temp[0];
			int c = temp[1];

			for(int i=0;i<4;i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if(check(nr,nc) == false) continue;
				if(cost[r][c] + map[nr][nc] < cost[nr][nc]) {
					cost[nr][nc] = cost[r][c] + map[nr][nc];
					queue.offer(new int[] {nr,nc});
				}
			}
			
		}
		
		return cost[N-1][N-1];
	}


	private static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<N;
	}

}
