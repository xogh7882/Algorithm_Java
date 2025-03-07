import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int map[][];
	static int count = 0;
	static int dr[] = {1,-1,0,0};
	static int dc[] = {0,0,1,-1};
	static List<int[]> list;
	
	static int select[];
	static boolean permvisited[];
	static int virusNum;
	
	static int result = Integer.MAX_VALUE;
	static boolean visited[][];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		count = N*N;      // 전체 칸의 개수
		list = new ArrayList<>();
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) count--;  // 벽 개수 빼주기
				else if(map[i][j] == 2) list.add(new int[] {i,j});
			}
		}
		virusNum = list.size();  // 바이러스 놓을 수 있는 칸
		permvisited = new boolean[virusNum];
		select = new int[M];     // list index를 combi로 구하기
		combi(0,0);
		
		if(result == Integer.MAX_VALUE) result = -1;
		System.out.println(result);

	}

	private static void combi(int cnt, int start) {
		if(cnt==M) {
			visited = new boolean[N][N];
			BFS();
			return;
		}
		for(int i=start;i<virusNum;i++) {
			if(permvisited[i]) continue;
			permvisited[i] = true;
			select[cnt] = i;
			combi(cnt+1, i);
			select[cnt] = -1;
			permvisited[i] = false;
		}
	}

	private static void BFS() {
		int copymap[][] = new int[N][N];
		
		int copycount = count;
		Queue<int[]> queue = new ArrayDeque<>();
		for(int i=0;i<M;i++) {
			queue.offer(list.get(select[i]));
			visited[list.get(select[i])[0]][list.get(select[i])[1]] = true;
		}
		
		int size = queue.size();
		int time = 0;
		
		while(!queue.isEmpty()) {
			if(size==0) {
				time++;
				size = queue.size();
			}
			int temp[] = queue.poll();
			int r = temp[0];
			int c = temp[1];
			visited[r][c] = true;
			copycount--;
			size--;
			
			copymap[r][c] = time;
			
			for(int i=0;i<4;i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if(check(nr,nc) && visited[nr][nc] == false && map[nr][nc] != 1) {
					visited[nr][nc] = true;
					queue.offer(new int[] {nr,nc});
				}
			}
			
		}
		
		if(copycount==0) result = Math.min(result, time);
		
//		System.out.println("=========Debuging=========");
//		System.out.println("count : " + copycount);
//		for(int i=0;i<N;i++) {
//			System.out.println(Arrays.toString(copymap[i]));
//		}
//		System.out.println();
		
	}

	private static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<N;
	}

}
