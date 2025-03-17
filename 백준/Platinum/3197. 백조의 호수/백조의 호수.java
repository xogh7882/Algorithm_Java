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
	static char map[][];
	static int startR = -1, startC= -1, endR = -1, endC = -1;
	static int dr[] = {1,-1,0,0};
	static int dc[] = {0,0,1,-1};
	
	static List<int[]> ice;
	static boolean icevisited[][];
	
	static List<int[]> sway;
	static boolean swayvisited[][];
	
	static List<int[]> eway;
	static boolean ewayvisited[][];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
	
		map = new char[N][M];
		
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<M;j++) {
				if(str.charAt(j) == 'L') {
					if(startR == -1) {
						startR = i;
						startC = j;
					}
					else {
						endR = i;
						endC = j;
					}
				}
				map[i][j] = str.charAt(j);
			}
		}
		
		
		ice = new ArrayList<>();
		sway = new ArrayList<>();
		eway = new ArrayList<>();
		icevisited = new boolean[N][M];
		swayvisited = new boolean[N][M];
		ewayvisited = new boolean[N][M];
		
		findice();  // 물과 맞닿아 있는 얼음을 ice 리스트에 저장
		
		int time = 0;
		while(true) {			
			if(findways()==true) break;
			if(findwaye()==true) break;
			melting();
			time++;
		}
		
		System.out.println(time);
		
	}


	private static boolean findways() {
		Queue<int[]> queue = new ArrayDeque<>();
		
		if(sway.isEmpty()) {
			queue.offer(new int[] {startR,startC});
		}
		else {
			for(int i=0;i<sway.size();i++) {
				queue.offer(sway.get(i));
			}
		}
		
		sway.clear();
		while(!queue.isEmpty()) {
			int temp[] = queue.poll();
			int r = temp[0];
			int c = temp[1];
			swayvisited[r][c] = true;
			
			if(swayvisited[r][c] == true && ewayvisited[r][c] == true) return true;
			
			if(map[r][c] == 'X') {
				sway.add(new int[] {r,c});
				continue;
			}
			
			for(int i=0;i<4;i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if(check(nr,nc)==false) continue;
				
				if(map[nr][nc] != 'X' && swayvisited[nr][nc] == false) {
					swayvisited[nr][nc] = true;
					queue.offer(new int[] {nr,nc});
				}
				else if(map[nr][nc] == 'X' && swayvisited[nr][nc] == false) {
					if(map[r][c] == '.') {
						swayvisited[nr][nc] = true;
						sway.add(new int[] {nr,nc});
					}
				}
				
			}
		}
		return false;
	}

	
	private static boolean findwaye() {
		Queue<int[]> queue = new ArrayDeque<>();
		
		if(eway.isEmpty()) {
			queue.offer(new int[] {endR,endC});
		}
		else {
			for(int i=0;i<eway.size();i++) {
				queue.offer(eway.get(i));
			}
		}
		
		eway.clear();
		while(!queue.isEmpty()) {
			int temp[] = queue.poll();
			int r = temp[0];
			int c = temp[1];
			ewayvisited[r][c] = true;
			
			if(swayvisited[r][c] == true && ewayvisited[r][c] == true) return true;
			
			if(map[r][c] == 'X') {
				eway.add(new int[] {r,c});
				continue;
			}
			
			for(int i=0;i<4;i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if(check(nr,nc)==false) continue;
				
				if(map[nr][nc] != 'X' && ewayvisited[nr][nc] == false) {
					ewayvisited[nr][nc] = true;
					queue.offer(new int[] {nr,nc});
				}
				else if(map[nr][nc] == 'X' && ewayvisited[nr][nc] == false) {
					if(map[r][c] == '.') {
						ewayvisited[nr][nc] = true;
						eway.add(new int[] {nr,nc});
					}
				}
				
			}
		}
		return false;
	}
	
	private static void melting() {
		Queue<int[]> queue = new ArrayDeque<>();
		for(int i=0;i<ice.size();i++) {
			queue.offer(ice.get(i));
		}
		
		ice.clear();

		while(!queue.isEmpty()) {
			int temp[] = queue.poll();
			int r = temp[0];
			int c = temp[1];
			map[r][c] = '.';
			for(int i=0;i<4;i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if(check(nr,nc) && map[nr][nc] =='X' && icevisited[nr][nc] == false) {
					icevisited[nr][nc] = true;
					ice.add(new int[] {nr,nc});
				}
				else if(check(nr,nc) && map[nr][nc] == '.' && icevisited[nr][nc] == false) {
					icevisited[nr][nc] = true;
					queue.offer(new int [] {nr,nc});
				}
			}
		}
		
	}

	
	
	private static void findice() {
		icevisited = new boolean[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(icevisited[i][j] == false && map[i][j] != 'X') {
					BFSice(i,j);
				}
			}
		}
		
	}

	private static void BFSice(int r, int c) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {r,c});
		
		while(!queue.isEmpty()) {
			int temp[] = queue.poll();
			int cr = temp[0];
			int cc = temp[1];
			icevisited[cr][cc] = true;
			
			for(int i=0;i<4;i++) {
				int nr = cr + dr[i];
				int nc = cc + dc[i];
				if(check(nr,nc) && map[nr][nc] != 'X' && icevisited[nr][nc] == false) {
					icevisited[nr][nc] = true;
					queue.offer(new int[] {nr,nc});
				}
				else if(check(nr,nc) && map[nr][nc] == 'X' && icevisited[nr][nc] == false) {
					icevisited[nr][nc] = true;
					ice.add(new int[] {nr,nc});
				}
			}
		}
	}


	private static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<M;
	}

	private static void printMap() {
		System.out.println("=============PrintMap============");
		for(int i=0;i<N;i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		System.out.println();
	}

}
