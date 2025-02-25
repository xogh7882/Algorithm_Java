import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int map[][];
	static int copymap[][];
	static boolean visited[][];
	static int sharkR, sharkC;
	static int sharksize = 2;
	static int hungry = 2;
	static int time = 0;
	static int dr[] = {1,-1,0,0};
	static int dc[] = {0,0,1,-1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) {
					sharkR = i;
					sharkC = j;
				}
			}
		}
		
		
//		printMap();
		
		while(true) {
//			printMap();                   //  check
//			String str = br.readLine();   //  check
			
			copymap = new int[N][N];
			visited = new boolean[N][N];
			makecopymap();
			
//			printMap();
//			printcopymap();
			
			int min = Integer.MAX_VALUE;
			int targetR=-1, targetC=-1;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(map[i][j] < sharksize && copymap[i][j] != 0 && copymap[i][j] < min && map[i][j] != 0) {
						min = copymap[i][j];
						targetR = i;
						targetC = j;
					}
				}
			}
			if(min ==Integer.MAX_VALUE) break;
			time+=min;
			map[targetR][targetC] = 9;
			map[sharkR][sharkC] = 0;
			sharkR = targetR;
			sharkC = targetC;
			
			hungry--;
			if(hungry==0) {
				sharksize++;
				hungry = sharksize;
			}
		}
		System.out.println(time);
	}
	private static void printcopymap() {
		System.out.println("----------------------------");
		for(int i=0;i<N;i++) {
			System.out.println(Arrays.toString(copymap[i]));
		}
		System.out.println();
		
	}
	private static void makecopymap() {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {sharkR, sharkC});
		while(!queue.isEmpty()) {
			int temp[] = queue.poll();
			int r = temp[0];
			int c = temp[1];
			visited[r][c] = true;
			for(int i=0;i<4;i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if(check(nr,nc) == true && visited[nr][nc] == false && map[nr][nc] <= sharksize) {
					visited[nr][nc] = true;
					queue.offer(new int[] {nr,nc});
					if(copymap[nr][nc] < copymap[r][c]+1) {
						copymap[nr][nc] = copymap[r][c]+1;
					}
				}
			}
		}
		
	}
	
	private static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<N;
	}
	
	private static void printMap() {
		System.out.println("------------------");
		for(int i=0;i<N;i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		System.out.println();
	}
}
