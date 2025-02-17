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
	static int result = 0;
	static int count;
	static boolean num[];
	static boolean visited[][];
	
	static int[] dr = {1,-1,0,0};
	static int[] dc = {0,0,1,-1};
	
	static List<Integer> list;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		num = new boolean[101];
		map = new int[N][N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(num[map[i][j]] == false) num[map[i][j]] = true;
			}
		}
	
		
		list = new ArrayList<>();
		
		list.add(0);  // 비가 안오는 경우
		
		for(int i=1;i<=100;i++) {
			if(num[i] == true) list.add(i);
		}
		
		for(int k=0;k<list.size();k++) {
			visited = new boolean[N][N];
			count = 0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(visited[i][j] == false && map[i][j]>list.get(k)) {
						//BFS(i,j,list.get(k));
						DFS(i,j,list.get(k));
						count++;
					}
				}
			}
			if(count > result) result = count;
		}
		
		
		
		System.out.println(result);
	}
	
	private static void DFS(int startR, int startC, int n) {
		visited[startR][startC] = true;
		for(int i=0;i<4;i++) {
			int nr = startR + dr[i];
			int nc = startC + dc[i];
			if(check(nr,nc) && map[nr][nc] > n && visited[nr][nc] == false) {
				DFS(nr,nc,n);
			}
		}
		
	}

	private static void BFS(int startR, int startC, int n) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {startR, startC});
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			int r = temp[0];
			int c = temp[1];
			visited[r][c] = true;
			
			for(int i=0;i<4;i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if(check(nr,nc) && map[nr][nc] > n && visited[nr][nc] == false) {
					queue.offer(new int[] {nr,nc});
				}
			}
		}
	}

	private static boolean check(int r, int c) {
		return r >=0 && r<N && c>=0 && c<N;
	}
	
	
	

}
