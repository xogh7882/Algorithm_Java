import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int T;
	static int R, C;
	static boolean map[][];
	static boolean visitedF[][];
	static boolean visitedJ[][];
	static List<int[]> listF;
	static List<int[]> listJ;
	static int time;
	
	static int dr[] = {1,-1,0,0};
	static int dc[] = {0,0,1,-1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		for(int test_case=0 ; test_case<T ; test_case++)
		{
			st = new StringTokenizer(br.readLine());
			C = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			map = new boolean[R][C];
			visitedJ = new boolean[R][C];
			visitedF = new boolean[R][C];
			listF = new ArrayList<>();
			listJ = new ArrayList<>();
			
			for(int i=0;i<R;i++) {
				String str = br.readLine();
				for(int j=0;j<C;j++) {
					char ch = str.charAt(j);
					if(ch == '#') {
						map[i][j] = false;
						visitedF[i][j] = true;
					}
					else if(ch=='.') map[i][j] = true;
					else if(ch=='@') {
						map[i][j] = true;
						visitedJ[i][j] = true;
						listJ.add(new int[] {i,j});
					}
					else if(ch=='*') {
						map[i][j] = false;
						visitedF[i][j] = true;
						listF.add(new int[] {i,j});
					}
				}
			}
			time = 1;
			while(true) {
//				printMap();
				spreadFire();
				if(escape() == true) {
					break;
				}
				if(listJ.isEmpty()) {
					time = -1;
					break;
				}
				time++;
			}
				
			if(time == -1) System.out.println("IMPOSSIBLE");
			else System.out.println(time);
		}

	}
	
	
	private static void printMap() {
		System.out.println("------------------------------");
		for(int i=0;i<R;i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		
	}

	private static boolean escape() {
		Queue<int[]> queue = new ArrayDeque<>();
		for(int i=0;i<listJ.size();i++) {
			queue.offer(listJ.get(i));
		}
		listJ.clear();
		while(!queue.isEmpty()) {
			int temp[] = queue.poll();
			int r = temp[0];
			int c = temp[1];
			for(int i=0;i<4;i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if(check(nr,nc) == false) return true;
				if(check(nr,nc) && visitedJ[nr][nc] == false && map[nr][nc] == true) {
					visitedJ[nr][nc] = true;
					listJ.add(new int[] {nr,nc});
				}
			}
		}
		return false;
	}

	private static void spreadFire() {
		Queue<int[]> queue = new ArrayDeque<>();
		for(int i=0;i<listF.size();i++) {
			queue.offer(listF.get(i));
		}
		listF.clear();
		while(!queue.isEmpty()) {
			int temp[] = queue.poll();
			int r = temp[0];
			int c = temp[1];
			for(int i=0;i<4;i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if(check(nr,nc)==true && visitedF[nr][nc] == false && map[nr][nc] == true) {
					map[nr][nc] = false;
					visitedF[nr][nc] = true;
					listF.add(new int[] {nr,nc});
				}
			}
		}
		
	}

	private static boolean check(int r, int c) {
		return r>=0 && r<R && c>=0 && c<C;
	}


}
