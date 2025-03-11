import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static char map[][];
	static boolean visited[][];
	static boolean count[][];
	static int flag = 0;
	static int result = 0;
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	static int num;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<M;j++) {
				map[i][j] = str.charAt(j);
			}
		}
		

		count = new boolean[N][M];             
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(count[i][j] == false) {
//					String str = br.readLine();
//					printMap();
					BFS(i,j);
					result++;
				}
			}
		}
		System.out.println(result);

	}
	
	private static void BFS(int r, int c) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {r,c});
		
		while(!queue.isEmpty()) {
			int temp[] = queue.poll();
			int cr = temp[0];
			int cc = temp[1];
			
			count[cr][cc] = true;
			
			for(int i=0;i<4;i++) {
				int nr = cr + dr[i];
				int nc = cc + dc[i];
				if(check(nr,nc) && count[nr][nc] == false) {
					if(i==0 && (map[cr][cc] == 'U' || map[nr][nc] == 'D')) {
						count[nr][nc] = true;
						queue.offer(new int[] {nr,nc});
					}
					
					if(i==1 && (map[cr][cc] == 'D' || map[nr][nc] == 'U')) {
						count[nr][nc] = true;
						queue.offer(new int[] {nr,nc});
					}
					
					if(i==2 && (map[cr][cc] == 'L' || map[nr][nc] == 'R')) {
						count[nr][nc] = true;
						queue.offer(new int[] {nr,nc});
					}
					
					if(i==3 && (map[cr][cc] == 'R' || map[nr][nc] == 'L')) {
						count[nr][nc] = true;
						queue.offer(new int[] {nr,nc});
					}
				}
								
			}
			
			
		}

	}
	
	
	private static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<M;
	}
	
	
	
	private static void printMap() {
		System.out.println("==============PrintMap==============");
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(count[i][j] == false) System.out.print("0 ");
				else System.out.print("1 ");
			}
			System.out.println();
		}
		System.out.println();
		
	}

}
