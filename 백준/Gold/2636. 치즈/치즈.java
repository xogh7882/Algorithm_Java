import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int map[][];
	static boolean visited[][];
	static int prevCount = -1;
	static int count = -1;
	static int time = 0;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 남은 치즈 계산 - 다녹으면 쓸거임
		// 공기를 2로 파아아아악 ( 그래야 빈공간 찾지 )
		// 치즈 근처에 공기 있는지
		// 닿아있으면 0으로 바꾸기
		// 남은 치즈 개수 세고 0 이면 이전꺼 출력 / 0 아니면 반복
		
		checkCount();
		while(true) {
			if(count != -1) break;
			spreadAir();
			removeCheeze();
			checkCount();
//			System.out.println("-----------------");
//			print_map();
//			System.out.println("-----------------");
			time++;
			visitedInit();
		}
		
		System.out.println(time);
		System.out.println(count);
	
	}
	
	

	private static void visitedInit() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				visited[i][j] = false;
			}
		}
		
	}



	private static void spreadAir() {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {0,0});
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			for(int i=0;i<4;i++) {
				int r = now[0];
				int c = now[1];
				if(map[r][c] != 1) {
					map[r][c] = 2;
					visited[r][c] = true;
					while(true) {
						int nr = r + dr[i];
						int nc = c + dc[i];
						if(check(nr,nc) && map[nr][nc] != 1 && visited[nr][nc] == false) {
							map[nr][nc] = 2;
							queue.offer(new int[] {nr,nc});
							r = nr;
							c = nc;
						}
						else break;
					}
				}
				
			}
		}
		
	}



	private static void removeCheeze() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j] == 1) {
					int r = i;
					int c = j;
					for(int k=0;k<4;k++) {
						int nr = r + dr[k];
						int nc = c + dc[k];
						if(check(nr,nc) && map[nr][nc] == 2) {
							map[i][j] = 3;
							break;
						}
					}
				}
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j] == 3) map[i][j] = 2;
			}
		}
		
	}

	private static void checkCount() {
		int sum = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j] == 1) sum++; 
			}
		}
		if(sum == 0) count = prevCount;
		else prevCount = sum;
	}


	private static boolean check(int i, int j) {
		return i>=0 && i<N && j>=0 && j<M;
	}


	private static void print_map() {
		for(int i=0;i<N;i++) {
			for(int j=0 ;j<M;j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		
	}

}