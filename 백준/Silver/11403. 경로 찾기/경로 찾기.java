import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int map[][];
	static boolean visited[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
				
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				visited = new boolean[N];
				if(DFS(i,j) == true) sb.append("1 ");
				else sb.append("0 ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
		
	}
	
	// r이 바뀌면서 DFS
	private static boolean DFS(int r, int c ) {
		if(map[r][c] == 1) return true;
		
		visited[r] = true;
		
		for(int i=0;i<N;i++) {
			if(map[r][i] == 1 && visited[i] == false) {
				if(DFS(i ,c)==true) return true;
			}
		}
		return false;
	}

	

}
