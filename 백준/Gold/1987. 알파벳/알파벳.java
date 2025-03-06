import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int R,C;
	static int map[][];
	static int result = 1;
	static boolean visited[];
	static int dr[] = {1,-1,0,0};
	static int dc[] = {0,0,1,-1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		
		for(int i=0;i<R;i++) {
			String str = br.readLine();
			for(int j=0;j<C;j++) {
				map[i][j] = str.charAt(j) - 'A';
			}
		}
		
		visited = new boolean[26];
		
		DFS(0,0,1);
		
		System.out.println(result);
		
	}

	private static void DFS(int r, int c, int cnt) {
		visited[map[r][c]] = true;
		for(int i=0;i<4;i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if(check(nr,nc)==true && visited[map[nr][nc]] == false) {
				DFS(nr,nc, cnt+1);
				visited[map[nr][nc]] = false;
			}
		}
		
		result = Math.max(result, cnt);
		return;
	}

	private static boolean check(int r, int c) {
		return r>=0 && r<R && c>=0 && c<C;
	}

	

}
