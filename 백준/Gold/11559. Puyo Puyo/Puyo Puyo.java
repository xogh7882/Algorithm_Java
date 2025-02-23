import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class Main {
	static int N = 12;
	static int M = 6;
	static int map[][];
	static boolean visited[][];
	static int count = 0;
	static int flag = 0;
	
	static int dr[] = {1,-1,0,0};
	static int dc[] = {0,0,1,-1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[N][M];
		
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<M;j++) {
				if(str.charAt(j) == '.') map[i][j] = 0;
				else if(str.charAt(j) == 'R') map[i][j] = 1;
				else if(str.charAt(j) == 'G') map[i][j] = 2;
				else if(str.charAt(j) == 'B') map[i][j] = 3;
				else if(str.charAt(j) == 'P') map[i][j] = 4;
				else if(str.charAt(j) == 'Y') map[i][j] = 5;
			}
		}
		
		
		int prevCount = count;
		while(true) {
			flag = 0;
			visited = new boolean[N][M];
			
			// 1. 같이 있는거 터트리기
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(map[i][j] != 0 && visited[i][j] == false) Puyo(i,j,map[i][j]);
				}
			}
		

			// 2. 전부 아래로 내리기
			for(int i=N-1;i>=0;i--) {
				for(int j=0;j<M;j++) {
					if(map[i][j] != 0) down(i,j);
				}
			}
			
			if(flag > 0) count++;
			if(prevCount == count) break;  // 더이상 안터지면 끝남
			prevCount = count;
		}
		
		System.out.println(count);

	}
	
	
	private static void down(int r, int c) {
		while(true) {
			r++;
			if(check(r,c) == false || map[r][c] != 0) break;
			else{
				map[r][c] = map[r-1][c];
				map[r-1][c] = 0;
			}
		}
		
		return;
		
	}


	private static void Puyo(int startR, int startC, int group) {
		List<int[]> list = new ArrayList<>();
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {startR, startC});
		while(!queue.isEmpty()) {
			int temp[] = queue.poll();
			int r = temp[0];
			int c = temp[1];
			list.add(new int[] {r,c});
			visited[r][c] = true;
			for(int i=0;i<4;i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if(check(nr,nc) && visited[nr][nc] == false && map[nr][nc] == group) {
					visited[nr][nc] = true;
					queue.offer(new int[] {nr,nc});
				}
			}
		}

		if(list.size() >=4 ) {
			int k = list.size();
			for(int i=0;i<k;i++) {
				int temp[] = list.get(i);
				map[temp[0]][temp[1]] = 0;
			}
			flag++;
		}
		return;
		
	}
	
	
	private static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<M;
	}


	private static void printMap() {
		System.out.println("------------------------");
		for(int i=0;i<N;i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		System.out.println();
		
	}

}
