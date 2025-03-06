import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int map[][];
	static boolean selectvisited[];
	static boolean visited[][];
	static int dr[] = {1,-1,0,0};
	static int dc[] = {0,0,1,-1};
	static int result = Integer.MAX_VALUE;
	
	static int select[];
	
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
		selectvisited = new boolean[N*N];
		select = new int[3];
		
		combi(0,0);
		
		System.out.println(result);
	}

	private static void combi(int cnt, int start) {
		if(cnt==3) {
			visited = new boolean[N][N];
			BFS();
			return;
		}
		for(int i=start;i<N*N;i++) {
			if(i/N==0 || i/N==N-1 || i%N==0 || i%N == N-1) continue;   // 가장자리는 못놓는다
			if(selectvisited[i]) continue;
			selectvisited[i] = true;
			select[cnt] = i;
			combi(cnt+1, i);
			select[cnt] = 0;
			selectvisited[i] = false;
		}
	}

	
	private static void BFS() {
		int flag = 0;
		Queue<int[]> queue = new ArrayDeque<>();
		for(int i=0;i<select.length;i++) {
			queue.offer(new int[] {select[i]/N, select[i]%N});
		}
		
		aa:while(!queue.isEmpty()) {
			int temp[] = queue.poll();
			int r = temp[0];
			int c = temp[1];
			visited[r][c] = true;
			
			for(int i=0;i<4;i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if(check(nr,nc) == false || visited[nr][nc]) {
					flag = 1;
					break aa;
				}
				visited[nr][nc] = true;
			}
		}
		
		if(flag==0) calc();
		
		return;
		
	}

	private static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<N;
	}

	private static void calc() {
		int sum = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(visited[i][j] == true) sum+=map[i][j];
			}
		}
		result = Math.min(result, sum);
		return;
		
	}
}

