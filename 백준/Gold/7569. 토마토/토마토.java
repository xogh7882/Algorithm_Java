import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M,H;
	static int[][][] map;
	static boolean[][][] visited;
	static int dx[] = {1,-1,0,0,0,0}; 
	static int dy[] = {0,0,1,-1,0,0};
	static int dz[] = {0,0,0,0,1,-1};
	
	static List<int[]> list;
	static int result = 0;
	static int notTomato = 0;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		list = new ArrayList<>();
		visited = new boolean[H][N][M];
		map = new int[H][N][M];
		
		for(int i=0;i<H;i++) {
			for(int j=0;j<N;j++) {
				st = new StringTokenizer(br.readLine());
				for(int k=0;k<M;k++) {
					map[i][j][k] = Integer.parseInt(st.nextToken());
					if(map[i][j][k] == 1) list.add(new int[] {i,j,k});
					else if(map[i][j][k] ==0) notTomato++;
				}
			}
		}
			
		while(true) {
			if(list.isEmpty() || notTomato==0) break;
			spreadTomato();
			result++;
		}
		
		if(notTomato != 0) result = -1;
		
		System.out.println(result);
		
	}
	
	private static void spreadTomato() {
		int k = list.size();
		Queue<int[]> queue = new ArrayDeque<>();
		for(int i=0;i<k;i++) {
			queue.offer(new int[] {list.get(i)[0], list.get(i)[1], list.get(i)[2]});
		}
		list.clear();
		while(!queue.isEmpty()) {
			int temp[] = queue.poll();
			int x = temp[0];
			int y = temp[1];
			int z = temp[2];
			visited[x][y][z] = true;
			for(int i=0;i<6;i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				int nz = z + dz[i];
				if(check(nx,ny,nz) && visited[nx][ny][nz] == false && map[nx][ny][nz] == 0) {
					map[nx][ny][nz] = 1;
					visited[nx][ny][nz] = true;
					list.add(new int[] {nx,ny,nz});
					notTomato--;
				}
			}
		}
		
	}

	private static boolean check(int x, int y, int z) {
		return x>=0 && x<H && y>=0 && y<N && z>=0 && z<M;
	}

	private static void printMap() {
		for(int i=0;i<H;i++) {
			for(int j=0;j<N;j++) {
				for(int k=0;k<M;k++) {
					System.out.print(map[i][j][k]+ " ");
				}
				System.out.println();
			}
			System.out.println("---------------");
		}
		
	}

}
