import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int map[][];
	static boolean visited[][];
	static int result1;
	static int result2;
	static int dr[] = {1,-1,0,0};
	static int dc[] = {0,0,1,-1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		visited = new boolean[N][N];
		
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<N;j++) {
				char ch = str.charAt(j);
				if(ch=='R') map[i][j] = 1;
				else if(ch=='G') map[i][j] = 2;
				else if(ch=='B') map[i][j] = 3;
			}
		}
		result1 = 0;
		result2 = 0;
		visited = new boolean[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(visited[i][j] == false) {
					find(i,j,1, map[i][j]);
					result1++;
				}
			}
		}
		
		visited = new boolean[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(visited[i][j] == false) {
					find(i,j,2, map[i][j]);
					result2++;
				}
			}
		}
		
		System.out.println(result1 + " " + result2);
	}

	private static void find(int startR, int startC, int flag, int now) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {startR,startC});
		visited[startR][startC] = true;
		while(!queue.isEmpty()) {
			int temp[] = queue.poll();
			int r = temp[0];
			int c = temp[1];
			for(int i=0;i<4;i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if(flag==1) {  // 정상
					if(check(nr,nc) && map[nr][nc] == now && visited[nr][nc] == false) {
						visited[nr][nc] = true;
						queue.offer(new int[] {nr,nc});
					}
				}
				else { // 적록색약
					if(now == 3) { // 적록색약에 블루
						if(check(nr,nc) && map[nr][nc] == now && visited[nr][nc] == false) {
							visited[nr][nc] = true;
							queue.offer(new int[] {nr,nc});
						}
					}
					else {  // 적록색약에 레드+그린
						if(check(nr,nc) && (map[nr][nc] ==1 || map[nr][nc] == 2) && visited[nr][nc] == false) {
							visited[nr][nc] = true;
							queue.offer(new int[] {nr,nc});
						}
					}
				}
			}
		}
		
	}

	private static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<N;
	}
	


}
