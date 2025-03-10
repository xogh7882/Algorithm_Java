import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int map[][];
	static int dr[] = {-1,-1,0,1,1,1,0,-1};
	static int dc[] = {0,1,1,1,0,-1,-1,-1};
	static int result;
	
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
		
		
		result = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j] == 0) {
					BFS(i,j);
				}
			}
		}
		
		System.out.println(result);
	}
	private static void BFS(int r, int c) {
		int copymap[][] = new int[N][M];
		for(int i=0;i<N;i++) {
			copymap[i] = map[i].clone();
		}
		
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {r,c});
		int size = queue.size();
		int time = 1;
		aa:while(!queue.isEmpty()) {
			if(size==0) {
				time++;
				size = queue.size();
			}
			int temp[] = queue.poll();
			int cr = temp[0];
			int cc = temp[1];
			copymap[cr][cc] = 2;
			size--;
			for(int i=0;i<8;i++) {
				int nr = cr + dr[i];
				int nc = cc + dc[i];
				if(!check(nr,nc)) continue;
				if(copymap[nr][nc] == 1) {
					result = Math.max(result, time);
					break aa;
				}
				else if(copymap[nr][nc]==0) {
					copymap[nr][nc] = 2;
					queue.offer(new int[] {nr,nc});
				}
			}
			
		}
	}
	private static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<M;
	}

}
