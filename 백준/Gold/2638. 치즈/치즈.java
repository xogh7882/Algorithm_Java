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
	static boolean visited[][];
	static int count = 0;
	
	static int dr[] = {1,-1,0,0};
	static int dc[] = {0,0,1,-1};
	
	static List<int[]> listcheeze;
	static List<int[]> listair;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		listcheeze = new ArrayList<>();
		listair = new ArrayList<>();
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) listcheeze.add(new int[] {i, j});
			}
		}
		
		findout();  // 외부 공기는 2로 체크 ( 내부 공기는 0 )
		
		visited = new boolean[N][M];
		while(true) {
			count++;
			removeCheeze();
			spreadAir();
			if(listcheeze.isEmpty()) break;
//			printMap();
			String str = br.readLine();
		}
		
		
		System.out.println(count);
		
	}

	private static void spreadAir() {
		Queue<int[]> queue = new ArrayDeque<>();
		int size = listair.size();
		for(int i=0;i<size;i++) {
			queue.offer(new int[] {listair.get(i)[0], listair.get(i)[1]});
		}
		listair.clear();
		
		while(!queue.isEmpty()) {
			int temp[] = queue.poll();
			int r = temp[0];
			int c = temp[1];
			map[r][c] = 2;
			visited[r][c] = true;
			for(int i=0;i<4;i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if(check(nr,nc) && visited[nr][nc] == false && map[nr][nc] == 0) {
					visited[nr][nc] = true;
					queue.offer(new int[] {nr,nc});
				}
			}
		}
	}

	private static void removeCheeze() {
		Queue<int[]> queue = new ArrayDeque<>();
		int size = listcheeze.size();
		for(int i=0;i<size;i++) {
			queue.offer(new int[] {listcheeze.get(i)[0], listcheeze.get(i)[1]});
		}
		listcheeze.clear();
		
		while(!queue.isEmpty()) {
			int temp[] = queue.poll();
			int r = temp[0];
			int c = temp[1];
			int cnt = 0;
			for(int i=0;i<4;i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if(check(nr,nc) == false) continue;
				if(map[nr][nc] == 2) cnt++;
			}
			if(cnt < 2) listcheeze.add(new int[] {r,c});
			else {
				map[r][c] = 0;
				listair.add(new int[] {r,c});
			}
		}
	}
	
	private static void findout() {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {0,0});
		while(!queue.isEmpty()) {
			int temp[] = queue.poll();
			int r = temp[0];
			int c = temp[1];
			visited[r][c] = true;
			for(int i=0;i<4;i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if(check(nr,nc) && visited[nr][nc] == false && map[nr][nc] == 0) {
					visited[nr][nc] = true;
					map[nr][nc] = 2;
					queue.offer(new int[] {nr,nc});
				}
			}
		}
	}

	
	private static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<M;
	}
	
	
	private static void printMap() {
		System.out.println("------------------------------");
		for(int i=0;i<N;i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		
	}

}
