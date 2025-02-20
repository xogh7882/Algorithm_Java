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
	static int x1,y1,x2,y2;
	static int count = 1;
	static int dr[] = {1,-1,0,0};
	static int dc[] = {0,0,1,-1};
	static boolean visited[][];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		x1 = Integer.parseInt(st.nextToken());
		y1 = Integer.parseInt(st.nextToken());
		x2 = Integer.parseInt(st.nextToken());
		y2 = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<M;j++) {
				char ch = str.charAt(j);
				if(ch=='1') map[i][j] = 3;  // 친구
				else if(ch=='#') map[i][j] = 9; // 초코바
				else if(ch=='0') map[i][j] = 0; // 빈공간
				else if(ch=='*') map[i][j] = 1; // 주난
			}
		}
		
		
		
		while(true) {
			//printMap();
			visited = new boolean[N][M];
			if(find()==true) break;
			count++;
		}
		//printMap();
		
		System.out.println(count);
		
	}

	private static void printMap() {
		System.out.println("-----------------------");
		for(int i=0;i<N;i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		System.out.println();
	}

	private static boolean find() {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {x1-1, y1-1});

		
		while(!queue.isEmpty()) {
			int temp[] = queue.poll();
			int r = temp[0];
			int c = temp[1];
			visited[r][c] = true;
			for(int i=0;i<4;i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if(check(nr,nc) == false) continue;
				if(nr == x2-1 && nc == y2-1) return true;
				
				else if(map[nr][nc] == 3 && visited[nr][nc] == false) {
					map[nr][nc] = 0;
					visited[nr][nc] = true;

				}
				else if (map[nr][nc] == 0 && visited[nr][nc] == false) {
					queue.offer(new int[] {nr,nc});
					visited[nr][nc] = true;
				}
			}
		}
			
		
		
		return false;
	}

	private static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<M;
	}

}
