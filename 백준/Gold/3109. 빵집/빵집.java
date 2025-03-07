import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int map[][];
	static boolean visited[][];
	static int result = 0;
	static int flag = 0;
	
	static int dr[] = {-1,0,1};
	static int dc[] = {1,1,1}; 
	
	static int checkmap[][];
	static int g = 1;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		checkmap = new int[N][M];
		
		
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<M;j++) {
				if(str.charAt(j) == '.') map[i][j] = 0;
				else {
					map[i][j] = -1;
					checkmap[i][j] = -1;
				}
			}
		}
		
		
		
		for(int i=0;i<N;i++) {
			visited[i][0] = true;
			checkmap[i][0] = g;
			flag = 0;
			DFS(i,0);
			
//			String str = br.readLine();
//			printMap();
//			g++;
			
		}
		
		System.out.println(result);
	}


	


	private static boolean DFS(int r, int c) {
		if(c == M-1) {
			result++;
			flag++;
			return true;
		}
		
		aa:for(int i=0;i<3;i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(check(nr,nc) && map[nr][nc] == 0 && visited[nr][nc] == false) {
				visited[nr][nc] = true;
				checkmap[nr][nc] = g;
				if(DFS(nr,nc) == true) break aa;
				else continue;
			}
		}
		if(flag != 0) return true;
		
		return false;
	}


	private static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<M;
	}
	
	private static void printMap() {
		System.out.println("======================PrintMap========================");
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				System.out.printf("%3d ", checkmap[i][j]);
			}
			System.out.println();
		}
		
	}
}
