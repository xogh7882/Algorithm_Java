import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int map[][];
	static int dr[] = {1,-1,0,0};
	static int dc[] = {0,0,1,-1};
	
	static int count[][][];    // 값 계산
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<M;j++) {
				if(str.charAt(j) =='0') map[i][j] = 0;
				else map[i][j] = 1;
			}
		}
		
//		printMap();
		
		count = new int[2][N][M];
		
		int result = BFS();
		
		System.out.println(result);
	}

	private static void printMap() {
		System.out.println("----------Print Map------------");
		for(int i=0;i<N;i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		
	}

	private static int BFS() throws Exception{
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {1,0,0});
		count[1][0][0] = 1;
		
		while(!queue.isEmpty()) {
//			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int temp[] = queue.poll();
			int k = temp[0];
			int r = temp[1];
			int c = temp[2];
			
			if(r==N-1 && c==M-1) return count[k][r][c];
			
			for(int i=0;i<4;i++){
				int nr = r + dr[i];
				int nc = c + dc[i];
				
//				System.out.println("nr : " + nr + " , nc : " + nc);
//				printcount();
				
				if(check(nr,nc)==false) continue;
				
				if(map[nr][nc]==1) {
					if(k==1) {
						if(count[k-1][nr][nc] == 0) {
							count[k-1][nr][nc] = count[k][r][c] + 1;
							queue.offer(new int[] {k-1,nr,nc});
						
						}
					}
					else continue;
				}
				else {
					if(count[k][nr][nc] == 0) {
						count[k][nr][nc] = count[k][r][c] + 1;
						queue.offer(new int[] {k,nr,nc});
						
					}
				}
			}
		}
		
		return -1;
	}

	private static void printcount() {
		System.out.println("===========벽부수기전==============");
		for(int i=0;i<N;i++) {
			System.out.println(Arrays.toString(count[1][i]));
		}
		System.out.println();
		
		System.out.println("===========벽부수고난 후==============");
		for(int i=0;i<N;i++) {
			System.out.println(Arrays.toString(count[0][i]));
		}
		
	}

	private static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<M;
	}

}
