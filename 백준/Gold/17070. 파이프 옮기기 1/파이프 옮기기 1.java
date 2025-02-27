import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int map[][];
	static int result = 0;
	
	static int dr[] = {0,1,1};
	static int dc[] = {1,1,0};

	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		BFS();
		
		System.out.println(result);
		
	}
	
	// 가로는 01
	// 세로는 12
	// 대각은 012
	// 가로->0  , 대각->1,  세로->2
	
	// k = 0 ( 현재가로 ) / k=1(현재대각) / k=2(현재세로)
	private static void BFS() {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {0,0,0,0,1});
		
		while(!queue.isEmpty()) {
			int temp[] = queue.poll();
			int k = temp[0];
			int prevR = temp[1];
			int prevC = temp[2];
			int nowR = temp[3];
			int nowC = temp[4];
			if(nowR == N-1 && nowC == N-1) {
				result++;
				continue;
			}
			if(k==0) {  // 현재 가로
				for(int i=0;i<2;i++) {
					int nprevR = nowR;
					int nprevC = nowC;
					int nnowR = nowR + dr[i];
					int nnowC = nowC + dc[i];
					if(check(nnowR, nnowC) == true && map[nnowR][nnowC]==0) {
						if(i==0) queue.add(new int[] {0,nprevR, nprevC, nnowR, nnowC});
						else if(i==1) {
							if(map[nnowR-1][nnowC] == 0 && map[nnowR][nnowC-1] == 0)
								queue.add(new int[] {1,nprevR, nprevC, nnowR, nnowC});
						}
					}
				}
			}
			else if(k==1) {  // 현재 대각
				for(int i=0;i<3;i++) {
					int nprevR = nowR;
					int nprevC = nowC;
					int nnowR = nowR + dr[i];
					int nnowC = nowC + dc[i];
					if(check(nnowR, nnowC) == true && map[nnowR][nnowC]==0) {
						if(i==0) queue.add(new int[] {0,nprevR, nprevC, nnowR, nnowC});
						else if(i==1) {
							if(map[nnowR-1][nnowC] == 0 && map[nnowR][nnowC-1] == 0)
								queue.add(new int[] {1,nprevR, nprevC, nnowR, nnowC});
						}
						else if(i==2) queue.add(new int[] {2,nprevR, nprevC, nnowR, nnowC});
					}
				}
			}
			else if(k==2) {
				for(int i=1;i<3;i++) {
					int nprevR = nowR;
					int nprevC = nowC;
					int nnowR = nowR + dr[i];
					int nnowC = nowC + dc[i];
					if(check(nnowR, nnowC) == true && map[nnowR][nnowC]==0) {
						if(i==1) {
							if(map[nnowR-1][nnowC] == 0 && map[nnowR][nnowC-1] == 0)
								queue.add(new int[] {1,nprevR, nprevC, nnowR, nnowC});
						}
						else if(i==2) queue.add(new int[] {2,nprevR, nprevC, nnowR, nnowC});
					}
				}
			}
		}
		
	}

	private static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<N;
	}

	private static void printMap() {
		System.out.println("===========PrintMap================");
		for(int i=0;i<N;i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		System.out.println();
	}

}
