import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int map[][];
	static int copyMap[][];
	static boolean visited[][];
	static int result;
	static int dr[] = {1,-1,0,0};
	static int dc[] = {0,0,1,-1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		copyMap = new int[N][M];
		
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<M;j++) {
				char ch = str.charAt(j);
				if(ch == 'W') map[i][j] = -1;
				else if(ch=='L') map[i][j] = Integer.MAX_VALUE;
			}
		}
		
		result = -1;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j] != -1) {
					visited = new boolean[N][M];
					find(i,j);
				}
			}
		}
		System.out.println(result);
	}

	private static void printMap() {
		System.out.println("----------------------");
		for(int i=0;i<N;i++) {
			System.out.println(Arrays.toString(copyMap[i]));
		}
		
	}

	private static void find(int r, int c) {
		for(int i=0;i<N;i++) {
			copyMap[i] = map[i].clone();
		}
		
		copyMap[r][c] = 0;  //start
		
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {r,c});
		while(!queue.isEmpty()) {
			int temp[] = queue.poll();
			int cr = temp[0];
			int cc = temp[1];
			for(int i=0;i<4;i++) {
				int nr = cr + dr[i];
				int nc = cc + dc[i];
				if(check(nr,nc)==true && visited[nr][nc] == false && copyMap[nr][nc] != -1) {
					if(copyMap[nr][nc] > copyMap[cr][cc] + 1) {
						copyMap[nr][nc] = copyMap[cr][cc] + 1;
						queue.offer(new int[] {nr,nc});
					}
				}
			}
		}
		//printMap();
		findMin();
	}

	private static void findMin() {
		int min = -1;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(copyMap[i][j] != 0 && copyMap[i][j] != Integer.MAX_VALUE && copyMap[i][j] > min) min = copyMap[i][j];
			}
		}
		if(min > result) result = min;
	}

	private static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<M;
	}

}
