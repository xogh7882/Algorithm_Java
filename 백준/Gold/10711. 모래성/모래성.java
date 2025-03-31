import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int map[][];
	static int copymap[][];
	static boolean visited[][];
	
	static int dr[] = {-1,-1,0,1,1,1,0,-1};
	static int dc[] = { 0, 1,1,1,0,-1,-1,-1};
	
	static Queue<int[]> queue = new ArrayDeque<>();
	static int time = 0;
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		copymap = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<M;j++) {
				if(str.charAt(j) == '.') map[i][j] = 0;
				else {
					map[i][j] = str.charAt(j)- '0';
				}
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j] != 0 && map[i][j] != 9) {
					copymap[i][j] = check(i,j);
					if(map[i][j] <= copymap[i][j]) queue.offer(new int[] {i,j});
				}
			}
		}
		
		
		int time = 1;
		int size = queue.size();
		while(!queue.isEmpty()) {
			if(size==0) {
				time++;
				size = queue.size();
			}
			
			int temp[] = queue.poll();
			size--;
			int r = temp[0];
			int c = temp[1];
			map[r][c] = 0;
			visited[r][c] = true;
			
			for(int i=0;i<8;i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if(map[nr][nc] != 0 && visited[nr][nc] ==false) {
					copymap[nr][nc]++;
					if(map[nr][nc] <= copymap[nr][nc]) {
						queue.offer(new int[] {nr,nc});
						visited[nr][nc] = true;
					}
				}
				
			}
			
		}
		
		
		System.out.println(time);
	}



	private static int check(int r, int c) {
		int sum = 0;
		for(int i=0;i<8;i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if(map[nr][nc] == 0) sum++;
		}
		return sum;
	}



	private static void printMap() {
		System.out.println("===========PrintMap============");
		for(int i=0;i<N;i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		System.out.println();
	}

}
