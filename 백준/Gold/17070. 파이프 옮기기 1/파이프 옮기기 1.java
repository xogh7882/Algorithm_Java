import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int map[][];
	static boolean visited[][];
	static int result = 0;
	
	static int dr[] = {0,1,1};
	static int dc[] = {1,1,0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited = new boolean[N][N];
		
		DFS(0, 0, 1);
		
		System.out.println(result);
		

	}

	// 가로는 01
	// 세로는 12
	// 대각은 012
	// 가로->0  , 대각->1,  세로->2
	
	// k = 0 ( 현재가로 ) / k=1(현재대각) / k=2(현재세로)
	
	private static void DFS(int k, int r, int c) {
		if(r == N-1 && c == N-1) {
			result++;
			return;
		}
		
		int start;
		int end;
		if(k==0) {
			start = 0;
			end = 2;
		}
		else if(k==1) {
			start=0;
			end=3;
		}
		else {
			start=1;
			end=3;
		}
		
		for(int i=start;i<end;i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if(check(nr,nc) && map[nr][nc] == 0) {
				if(i==0 || i==2) {
					DFS(i,nr,nc);
				}
				else{
					if(map[nr-1][nc] == 0 && map[nr][nc-1] == 0) {
						DFS(i,nr,nc);
					}
				}
			}
		}
		
	}

	private static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<N;
	}

	
}
