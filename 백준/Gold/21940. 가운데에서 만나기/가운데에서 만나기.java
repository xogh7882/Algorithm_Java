import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static int N,M,K;
	static int map[][];
	static int returnmap[][];
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][N+1];
		for(int i=0;i<=N;i++) {
			Arrays.fill(map[i], Integer.MAX_VALUE/10);
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			map[a][b] = c;
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
		
		
		returnmap = new int[N+1][N+1];
		
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				if(i==j) continue;
				returnmap[i][j] = map[i][j] + map[j][i];
			}
		}
	

		
		K = Integer.parseInt(br.readLine());
		int friend[] = new int[K];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<K;i++) {
			friend[i] = Integer.parseInt(st.nextToken());
		}
		
		
		
		
		// Print Map
//		for(int i=1;i<=N;i++) {
//			for(int j=1;j<=N;j++) {
//				System.out.print(returnmap[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		
		
		
		int result = Integer.MAX_VALUE;
		Queue<Integer> queue = new ArrayDeque<>();
		
		for(int j=1;j<=N;j++) {
			int max = -1;
			
			for(int i=0;i<friend.length;i++) {
				max = Math.max(max, returnmap[friend[i]][j]);
			}
			
			if(max < result) {
				result = max;
				queue.clear();
				queue.offer(j);
			}
			else if(max==result) {
				queue.offer(j);
			}
		}
		
		while(!queue.isEmpty()) {
			System.out.print(queue.poll() + " ");
		}
		
	}

}
