import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static char map[][];
	static boolean visited[][][];
	
	static int dr[] = {1,-1,0,0};
	static int dc[] = {0,0,1,-1};
	static int startR=-1, startC=-1;
	static int endR = -1, endC = -1;
	static int startflag = -1;
	static int endflag = -1;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new char[N][N];
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<N;j++) {
				map[i][j] = str.charAt(j);
				if(startR == - 1 && map[i][j] == 'B') {
					startR = i;
					startC = j;
				}
				if(endR == - 1 && map[i][j] == 'E') {
					endR = i;
					endC = j;
				}
			}
		}
		
		if(check(startR, startC+1) && map[startR][startC+1] == 'B') {
			startC++;
			startflag = 0;    // 0 = 가로
		}
		else {
			startR++;
			startflag = 1;    // 1 = 세로
		}
		
		if(check(endR, endC+1) && map[endR][endC+1] == 'E') {
			endC++;
			endflag = 0;       // 가로
		}
		else {
			endR++;
			endflag = 1;        // 세로
		}
		
		visited = new boolean[2][N][N];
		
		int result = BFS();
		System.out.println(result);
	}

	private static int BFS() {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {startflag, startR,startC});
		int size = queue.size();
		int time = 0;
		
		while(!queue.isEmpty()) {
			if(size == 0) {
				time++;
				size = queue.size();
			}
			
			int temp[] = queue.poll();
			int k = temp[0];
			int r = temp[1];
			int c = temp[2];
			size--;
			
			if(k==endflag && r == endR && c == endC) return time;
			
			for(int i=0;i<4;i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if(check(nr,nc)) {
					if(k==1 && check(nr-1,nc) && check(nr+1,nc)) { // 세로
						if(map[nr][nc] != '1' && map[nr-1][nc] != '1' && map[nr+1][nc]!='1' && visited[k][nr][nc] == false) {
							visited[k][nr][nc] = true;
							queue.offer(new int[] {k,nr,nc});
						}
					}
					else if (k==0 && check(nr,nc-1) && check(nr,nc+1)) {  // 가로
						if(map[nr][nc] != '1' && map[nr][nc-1] != '1' && map[nr][nc+1] !='1' && visited[k][nr][nc] == false) {
							visited[k][nr][nc] = true;
							queue.offer(new int[] {k,nr,nc});
						}
					}
					
				}
			}
			
			if(k==1) {
				if(checkLotation(r,c) && visited[0][r][c] == false) {
					visited[0][r][c] = true;
					queue.offer(new int[] {0,r,c});
				}
			}
			else if (k==0){
				if(checkLotation(r,c) && visited[1][r][c] == false) {
					visited[1][r][c] = true;
					queue.offer(new int[] {1,r,c});
				}	
			
			}
		}
		
		return 0;
	}
	
	private static boolean checkLotation(int r, int c) {
		int dx[] = {-1,-1,0,1,1, 1, 0,-1};
		int dy[] = { 0, 1,1,1,0,-1,-1,-1};
		for(int i=0;i<8;i++) {
			int nr = r + dx[i];
			int nc = c + dy[i];
			if(check(nr,nc)==false) return false;
			if(map[nr][nc] == '1') return false;
		}
		return true;
	}

	private static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<N;
	}


}
