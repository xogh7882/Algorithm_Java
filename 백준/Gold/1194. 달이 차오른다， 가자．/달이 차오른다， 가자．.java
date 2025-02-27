import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static char map[][];
	static int result=-1;
	static int startR,startC;
	static int flag = 0;
	static int count[][][];
	static int dr[] = {1,-1,0,0};
	static int dc[] = {0,0,1,-1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<M;j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == '0') {
					startR = i;
					startC = j;
				}
			}
		}
		count = new int[1<<7][N][M];
		
		result = BFS();
		
		System.out.println(result);
	}

	// 열쇠를 먹으면 차원이 바뀌도록 한다?
	// 열쇠는 flag로?
	
	private static int BFS() {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {flag, startR, startC});
		count[flag][startR][startC] = 0;
		
		while(!queue.isEmpty()) {
			int temp[] = queue.poll();
			int k = temp[0];
			int r = temp[1];
			int c = temp[2];

			//디버깅 코드
//			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
//			System.out.println("k : " + k + " , r : " + r + " , c : "+ c);
//			printcount();
//			
			if(map[r][c] == '1') return count[k][r][c];      // 종료 조건
			
			for(int i=0;i<4;i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if(check(nr,nc)==true && map[nr][nc] != '#') {  // 갈 수 있고, 벽이 아니야
					
					if('a' <= map[nr][nc] && map[nr][nc] <= 'f') {  // 거기에 열쇠가 있어
						// 열쇠먹고 flag 바꾸고
						if(count[k | (1<<(map[nr][nc] - 'a'))][nr][nc] == 0) {
							count[k | (1<<(map[nr][nc] - 'a'))][nr][nc] = count[k][r][c] + 1;
							queue.offer(new int[] {k | (1<<(map[nr][nc] - 'a')), nr, nc});
						}
						
					}
					
					else if('A' <= map[nr][nc] && map[nr][nc] <= 'F') {  // 문이 있어
						if((k & (1<<(map[nr][nc]-'A'))) != 0) {          // 너 열쇠 있니?
							if(count[k][nr][nc] == 0) {
								count[k][nr][nc] = count[k][r][c] + 1;
								queue.offer(new int[] {k,nr,nc});
							}
						}
					}
					
					else {
						if(count[k][nr][nc] == 0) {
							count[k][nr][nc] = count[k][r][c] + 1;
							queue.offer(new int[] {k,nr,nc});
						}
					}
					
				}
			}
			
		}
		
		return -1;
	}

	private static void printcount() {
		System.out.println("===============k-0 : 열쇠없어 ===============");
		for(int i=0;i<N;i++) {
			System.out.println(Arrays.toString(count[0][i]));
		}
		System.out.println();
		System.out.println("===============k-1 : a열쇠있어 ===============");
		for(int i=0;i<N;i++) {
			System.out.println(Arrays.toString(count[1][i]));
		}
		System.out.println();
		
		
	}

	private static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<M;
	}

	private static void printMap() {
		System.out.println("============Print Map===============");
		for(int i=0;i<N;i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		System.out.println();
		
	}

}
