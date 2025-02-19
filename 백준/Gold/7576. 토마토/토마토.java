import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int M,N;
	static int map[][];
	static int result;
	static int tomato = 0;
	static int target;
	static int dr[] = {1,-1,0,0};
	static int dc[] = {0,0,1,-1};
	static List<int[]> list;
	static List<int[]> nowTomato;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		target = N * M;
		nowTomato = new ArrayList<>();
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					tomato++;
					nowTomato.add(new int[] {i,j});
				}
				else if(map[i][j] == -1) target--;
			}
		}
		
		// (1:익은) / (0:안익은) / (-1:빈칸)
		result = 0;
		
		while(true) {
			//printMap();
			if(findTomato() == 0) break;
			result++;
		}
		if(tomato != target) result = 0;
		result--;
		System.out.println(result);
	}

	private static int findTomato() {
		list = nowTomato;
		BFS();
		return list.size();
	}

	private static void BFS() {
		nowTomato = new ArrayList<>();
		for(int i=0;i<list.size();i++) {
			int temp[] = list.get(i);
			int r = temp[0];
			int c = temp[1];
			map[r][c] = 2;
			for(int d =0;d<4;d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if(check(nr,nc) && map[nr][nc] == 0) {
					map[nr][nc] = 1;
					tomato++;
					nowTomato.add(new int[] {nr,nc});
				}
			}
		}
	}

	private static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<M;
		
	}

	private static void printMap() {
		System.out.println("------------------------------");
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				System.out.printf("%3d ", map[i][j]);
			}
			System.out.println();
		}
	}

}
