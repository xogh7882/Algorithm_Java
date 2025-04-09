import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	static int N,M,R;
	static int item[];
	static int map[][];
	static int result = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		
		st = new StringTokenizer(br.readLine());
		item = new int[N+1];
		for(int i=1;i<=N;i++) {
			item[i] = Integer.parseInt(st.nextToken());
		}
		
		map = new int[N+1][N+1];
		for(int i=0;i<=N;i++) {
			Arrays.fill(map[i], Integer.MAX_VALUE/10);
		}

		
		for(int i=0;i<R;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			map[a][b] = c;
			map[b][a] = c;
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
			int sum = 0;
			for(int j=1;j<=N;j++) {
				if(i==j) map[i][j] = 0;
				if(map[i][j] <= M) sum += item[j];
			}
			result = Math.max(result, sum);
		}
		
		
			
//		for(int i=1;i<=N;i++) {
//			for(int j=1;j<=N;j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		
		
		System.out.println(result);
	}

}
