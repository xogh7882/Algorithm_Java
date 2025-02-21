import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int map[][];
	static int copymap[][];
//	static boolean mapvisited[][];
	static int count = 0;
	static boolean visited[][];
	static List<int[]> list;
	static List<int[]> queue;
	static int k;
	static int result;
	
	static int dr[] = {0,1,0,-1};
	static int dc[] = {1,0,-1,0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		copymap = new int[N][M];
		list = new ArrayList<>();
		queue = new ArrayList<>();
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 6) count++;
				if(1<=map[i][j]&&map[i][j]<=5 ) list.add(new int[] {i,j});
			}
		}
		k = list.size();
		visited = new boolean[k][4];
		result = N*M - count;
		count = result;
		
//		for(int i=0;i<N;i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
		
		find(0, 0);
		
		System.out.println(result);
	}


	private static void find(int cnt, int start) {
		if(cnt == k) {
			//mapvisited = new boolean[N][M];
			printqueue();
			return;
		}
		for(int i=start;i<k;i++) {
			for(int j=0;j<4;j++) {
				if(visited[i][j]) continue;
				visited[i][j] = true;
				queue.add(new int[] {list.get(cnt)[0], list.get(cnt)[1], j});
				find(cnt+1, i+1);
				queue.remove(queue.size()-1);
				visited[i][j] = false;
				
			}
			
		}
	}
		


	private static void printqueue() {
		for(int i=0;i<N;i++) {
			copymap[i] = map[i].clone();
		}
		int copycount = count;
		
		for(int i=0;i<k;i++) {
			int temp[] = queue.get(i);
			int r = temp[0];
			int c = temp[1];
			int d = temp[2];
			int t = map[r][c];
			if(t>=3) t--;
			if(map[r][c] == 2) {
				for(int x=d ; x<=d+2 ; x=x+2) {
					int nr = r;
					int nc = c;
					while(true) {
						if(check(nr,nc) == false || copymap[nr][nc] == 6) break;
						if(/*mapvisited[nr][nc] == false*/ copymap[nr][nc] != 9) {
							//mapvisited[nr][nc] = true;
							copymap[nr][nc] = 9;
							copycount--;
						}
						nr+=dr[x%4];
						nc+=dc[x%4];
					
					}
				}
			}
						
			
			else {
				for(int x=d;x<d+t;x++) {
					int nr = r;
					int nc = c;
					while(true) {
						if(check(nr,nc) == false || copymap[nr][nc] == 6) break;
						if(/*mapvisited[nr][nc] == false*/copymap[nr][nc] != 9) {
							//mapvisited[nr][nc] = true;
							copymap[nr][nc] = 9;
							copycount--;
						}
						
						nr+=dr[x%4];
						nc+=dc[x%4];
				}
			}
			
		}
	
		}
		//printMap();
		if(copycount < result) result = copycount;
		
	}


	private static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<M;
	}


	private static void printMap() {
		System.out.println("---------------------------");
		for(int i=0;i<N;i++) {
			System.out.println(Arrays.toString(copymap[i]));
		}
		System.out.println();
	}

}
