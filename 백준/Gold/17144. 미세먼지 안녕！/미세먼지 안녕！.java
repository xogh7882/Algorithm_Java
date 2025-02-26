import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M,T;
	static int map[][];
	static List<int[]> dust;
	static List<int[]> air;
	static int result;
	static int dr1[] = {0,-1,0,1};
	static int dc1[] = {1,0,-1,0};
	
	static int dr2[] = {0,1,0,-1};
	static int dc2[] = {1,0,-1,0};
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
			
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		air = new ArrayList<>();
		dust = new ArrayList<>();
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == -1) air.add(new int[] {i,j});
				else if(map[i][j] != 0) dust.add(new int[] {i,j});
			}
		}
		
	
		for(int i=0;i<T;i++) {
//			String str = br.readLine();
			
			spreadDust();
//			printMap();
			

			spreadAir();
//			printMap();
			
			dustlist();
		
		}
		
		result = checkDust();
		System.out.println(result);
	}
	
	
	private static void dustlist() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j] > 0) dust.add(new int[] {i,j});
			}
		}
		
	}


	private static void spreadAir() throws Exception {
		int[][] copymap = new int[N][M];
		for(int i=0;i<N;i++) {
			copymap[i] = map[i].clone();
		}
		for(int k=0;k<2;k++) {
			int r = air.get(k)[0];
			int c = air.get(k)[1];
			int prevr = r;
			int prevc = c;
			
			if(k==0) {
				for(int i=0;i<4;i++) {
					while(true) {
						r = r + dr1[i];
						c = c + dc1[i];
						if(check(r,c) == false || map[r][c] == -1) {
							r = r - dr1[i];
							c = c - dc1[i];
							break;
						}
						if(map[prevr][prevc] == -1) {
							copymap[r][c] = 0;
						}
						else {
							copymap[r][c] = map[prevr][prevc];
						}
						prevr = r;
						prevc = c;
					}
				}
			}
			
			else {
				for(int i=0;i<4;i++) {
					while(true) {
						r = r + dr2[i];
						c = c + dc2[i];
						if(check(r,c) == false || map[r][c] == -1) {
							r = r - dr2[i];
							c = c - dc2[i];
							break;
						}
						if(map[prevr][prevc] == -1) {
							copymap[r][c] = 0;
						}
						else {
							copymap[r][c] = map[prevr][prevc];
						}
						prevr = r;
						prevc = c;
					}
				}
			}
		}
		
		for(int i=0;i<N;i++) {
			map[i] = copymap[i].clone();
		}
		
	}


	private static void spreadDust() {
		int[][] copymap = new int[N][M];
		for(int i=0;i<2;i++) {
			copymap[air.get(i)[0]][air.get(i)[1]] = -1;
		}
		Queue<int[]> queue = new ArrayDeque<>();
		for(int i=0;i<dust.size();i++) {
			int temp[] = dust.get(i);
			queue.offer(temp);
		}
		dust.clear();
		while(!queue.isEmpty()) {
			int temp[] = queue.poll();
			int r = temp[0];
			int c = temp[1];
			int cnt = 0;
			for(int i=0;i<4;i++) {
				int nr = r + dr1[i];
				int nc = c + dc1[i];
				if(check(nr,nc) && map[nr][nc] != -1) cnt++;
			}
			for(int i=0;i<4;i++) {
				int nr = r + dr1[i];
				int nc = c + dc1[i];
				if(check(nr,nc) && map[nr][nc] != -1) {
					copymap[nr][nc] += (map[r][c]/5);
					air.add(new int[] {});
				}
			}
			copymap[r][c] += map[r][c] - (map[r][c]/5 * cnt);
			air.add(new int[] {});
		}
		
		for(int i=0;i<N;i++) {
			map[i] = copymap[i].clone();
		}
	}


	private static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<M;
	}


	private static int checkDust() {
		int sum = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j] > 0) sum+= map[i][j];
			}
		}
		return sum;
	}
	
	
	private static void printMap() {
		System.out.println("-----------------------------");
		for(int i=0;i<N;i++) {
			System.out.println(Arrays.toString(map[i]));
		}
	}

}
