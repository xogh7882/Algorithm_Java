import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int map[][];
	static int dr[] = {1,1,1};
	static int dc[] = {-1,0,1};
	
	static int result = Integer.MAX_VALUE/10;
	
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
	
		
		for(int i=0;i<M;i++) {
			start(0,i);
		}
		
		System.out.println(result);
	}


	private static void start(int r, int c) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {r,c,-1, map[r][c]});
		
		while(!queue.isEmpty()) {
			int temp[] = queue.poll();
			int cr = temp[0];
			int cc = temp[1];
			int dir = temp[2];
			int sum = temp[3];
			
			if(cr == N-1) {
				result = Math.min(result, sum);
				continue;
			}
			
			for(int i=0;i<3;i++) {
				if(i==dir) continue;
				
				int nr = cr + dr[i];
				int nc = cc + dc[i];
				if(check(nr,nc) == false) continue;
				
				queue.offer(new int[] {nr,nc,i,sum+map[nr][nc]});
			
			}
		}
		
	}


	private static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<M;
	}

}
