import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int map[][];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		map = new int[N+1][N+1];
		
		for(int i=0;i<=N;i++) {
			Arrays.fill(map[i], Integer.MAX_VALUE/10);
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if(map[a][b] == 0) map[a][b] = c;
			else map[a][b] = Math.min(map[a][b], c);
		}
		
		
		
		for(int k=1;k<=N;k++) {
			for(int i=1;i<=N;i++) {
				if(k==i) continue;
				for(int j=1;j<=N;j++) {
					if(i==k || k==j) continue;
					map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
				}
			}
		}
		
		
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				if(i==j || map[i][j] == Integer.MAX_VALUE/10) map[i][j] = 0;
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	
	}

}
