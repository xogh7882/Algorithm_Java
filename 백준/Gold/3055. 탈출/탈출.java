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
	static List<int[]> water;
	static List<int[]> me;
	static int dr[] = {1,-1,0,0};
	static int dc[] = {0,0,1,-1};
	static int result = 0;
	static int targetR, targetC;
	static int startR, startC;
	static boolean visitedwater[][];
	static boolean visitedme[][];
	
	static int count[][];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		
		// . 비어있어
		// * 물이야
		// x 돌
		// D 목적지
		// S 나

		// 물 먼저 이동  빈칸 ) 단 돌은 통과 X , 비버굴도 X
		// 고슴도치는 물 X, 돌X
		
		water = new ArrayList<>();
		me = new ArrayList<>();
		count = new int[N][M];
		visitedwater = new boolean[N][M];
		visitedme = new boolean[N][M];
		
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<M;j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == 'S') {
					startR = i;
					startC = j;
					me.add(new int[] {startR,startC});
				}
				else if(map[i][j] == '*') {
					water.add(new int[] {i,j});
				}
				else if(map[i][j] == 'D') {
					targetR = i;
					targetC = j;
				}
			}
		}
		
		count[startR][startC] = 0;
		
		while(true) {
			spreadWater();
//			System.out.println("----------after spread water--------");
//			printMap();
			
			spreadMe();
//			System.out.println("----------after spread me--------");
//			printMap();
			if(me.isEmpty()) break;
		}
		
		int result = count[targetR][targetC];
		
		if(result == 0) System.out.println("KAKTUS");
		else System.out.println(result);
	}

	

	private static void spreadMe() {
		int size = me.size();
		Queue<int[]> queue = new ArrayDeque<>();
		for(int i=0;i<size;i++) {
			queue.offer(new int[] {me.get(i)[0], me.get(i)[1]});
		}
		me.clear();
		while(!queue.isEmpty()) {
			int temp[] = queue.poll();
			int r = temp[0];
			int c = temp[1];
			map[r][c] = '.';
			visitedme[r][c] = true;
			if(r==targetR && c ==targetC) {
				me.clear();
				return;
			}
			
			for(int i=0;i<4;i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if(check(nr,nc) == true && (map[nr][nc] == '.' || map[nr][nc] == 'D') && visitedme[nr][nc] == false) {
					me.add(new int[] {nr,nc});
					map[nr][nc] = 'S';
					visitedme[nr][nc] = true;
					if(count[nr][nc] == 0) {
						count[nr][nc] = count[r][c] + 1;
					}
				}
			}
		}
		
	}

	private static void spreadWater() {
		int size = water.size();
		Queue<int[]> queue = new ArrayDeque<>();
		for(int i=0;i<size;i++) {
			queue.offer(new int[] {water.get(i)[0], water.get(i)[1]});
		}
		water.clear();
		while(!queue.isEmpty()) {
			int temp[] = queue.poll();
			int r = temp[0];
			int c = temp[1];
			visitedwater[r][c] = true;
			for(int i=0;i<4;i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if(check(nr,nc)==true && (map[nr][nc] == '.' || map[nr][nc] == 'S') && visitedwater[nr][nc] == false) {
					water.add(new int[] {nr,nc});
					map[nr][nc] = '*';
					visitedwater[nr][nc] = true;
				}
			}
		}
			
	}

	private static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<M;
	}

	private static void printMap() {
		System.out.println("==========PrintMap===========");
		for(int i=0;i<N;i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		System.out.println();
		
	}
}
