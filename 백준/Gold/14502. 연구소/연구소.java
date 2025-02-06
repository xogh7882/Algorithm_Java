import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int map[][];
	static int copyMap[][];
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static int max = -1;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		copyMap = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 0은 빈칸 , 1은 벽 , 2는 바이러스
		// 전체 순환하면서 빈칸 나오면 벽세우기
		// 벽 3개면 바이러스 퍼지게 하고
		// 벽 만들기는 permutaion 처럼 만들기 ( 선택하고 -> 늘리고 -> 선택취소 )
		
		makeWall(0);
		System.out.println(max);
		
	}
	
	
	private static void makeWall(int wall) {
		if(wall == 3) {
//			System.out.println("-----------------------");
//			print_map();
			findSafety();
//			System.out.println("------------------------");
//			print_copyMap();
			return;
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j] == 0) {  // perm 처럼 해서 모든 경우의 수 구하기
					map[i][j] = 1;
					makeWall(wall + 1);
					map[i][j] = 0;
				}
			}
		}
		
	}


	private static void findSafety() {
		for(int i=0;i<N;i++) {
			copyMap[i] = map[i].clone();
		}
		
		Queue<int[]> queue = new ArrayDeque<>();
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(copyMap[i][j] == 2) {
					queue.offer(new int[] {i,j});
				}
			}
		}
		
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			int r = temp[0];
			int c = temp[1];
			
			for(int i=0;i<4;i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if(check(nr,nc) && copyMap[nr][nc] == 0) {
					copyMap[nr][nc] = 2;
					queue.offer(new int[] {nr,nc});
				}
			}
		}
		
		
		// 다 퍼뜨리고
		int cnt = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(copyMap[i][j] == 0) cnt++;
			}
		}
		if(cnt > max) max = cnt;
	}
	
	private static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<M;
	}


	private static void print_map() {
		for(int i=0;i<N;i++) {
			for(int j=0 ;j<M;j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	
	private static void print_copyMap() {
		for(int i=0;i<N;i++) {
			for(int j=0 ;j<M;j++) {
				System.out.print(copyMap[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	

}
