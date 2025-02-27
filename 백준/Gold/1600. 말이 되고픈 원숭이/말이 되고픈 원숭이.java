import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int K,N,M;
	static boolean map[][];
	static int count[][][];
	static int result = -1;
	static int monR[] = {1,-1,0,0};
	static int monC[] = {0,0,1,-1};
	
	static int horR[] = {-1,-2,-2,-1,1,2,2,1};
	static int horC[] = {-2,-1,1,2,2,1,-1,-2};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new boolean[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				int x = Integer.parseInt(st.nextToken());
				if(x==0) map[i][j] = true;
				else map[i][j] = false;
			}
		}
		
		count = new int[K+1][N][M];
		
		int result = BFS();
		
		System.out.println(result);
	
	}

	
	private static int BFS() {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {K,0,0});
		count[K][0][0] = 0;
		while(!queue.isEmpty()) {
			int temp[] = queue.poll();
			int k = temp[0];
			int r = temp[1];
			int c = temp[2];
			if(r==N-1 && c==M-1) return count[k][r][c];   // 종료 조건
			
			if(k==0) {  // 기회 없어
				for(int i=0;i<4;i++) {
					int nr = r + monR[i];
					int nc = c + monC[i];
					if(check(nr,nc)==true && map[nr][nc] == true && count[k][nr][nc] == 0) {
						queue.offer(new int[] {k,nr,nc});
						count[k][nr][nc] = count[k][r][c] + 1;
					}
					
				}
			}
			
			else {       // 남아 있어
				for(int i=0;i<8;i++) {
					int nr = r + horR[i];
					int nc = c + horC[i];
					if(check(nr,nc) == true && map[nr][nc] == true && count[k-1][nr][nc] == 0) {
						queue.offer(new int[] {k-1,nr,nc});
						count[k-1][nr][nc] = count[k][r][c] + 1;
					}
				}
				
				for(int i=0;i<4;i++) {
					int nr = r + monR[i];
					int nc = c + monC[i];
					if(check(nr,nc)==true && map[nr][nc] == true && count[k][nr][nc] == 0) {
						queue.offer(new int[] {k,nr,nc});
						count[k][nr][nc] = count[k][r][c] + 1;
					}
					
				}
			}
		}
		
		return -1;
	}


	private static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<M;
	}


	private static void printMap() {
		System.out.println("===========Print Map=============");
		for(int i=0;i<N;i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		
	}

}
