import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int map[][];
	static int r,c,d;
	
	static int dr[] = {-1,0,1,0};
	static int dc[] = {0,1,0,-1};
	
	static int count = 0;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		move(r,c,d);
		
		System.out.println(count);
		
	}

	private static void move(int r, int c, int d) {
		while(true) {
            //printMap();
			if(map[r][c] == 0) {
				map[r][c] = 2;
				count++;
			}
			
			if(findClean(r,c) == false) {
				int nr=-1, nc=-1;
				if(d==0) {
					nr = r + dr[2];
					nc = c + dc[2];
				}
				else if(d==1) {
					nr = r + dr[3];
					nc = c + dc[3];
				}
				else if(d==2) {
					nr = r + dr[0];
					nc = c + dc[0];
				}
				else if(d==3) {
					nr = r + dr[1];
					nc = c + dc[1];
				}
				
				if(check(nr,nc) && map[nr][nc] != 1) {
					r = nr;
					c = nc;
				}
				else return;
			}
			
			else {
				while(true) {
			
					d--;
					if(d==-1) d = 3;
					int nr=-1,nc=-1;
					
					nr = r + dr[d];
					nc = c + dc[d];
					
					if(check(nr,nc) && map[nr][nc]==0) {
						r = nr;
						c = nc;
						break;
					}
					else continue;
				}
			
			}
		}
	}

	private static void printMap() {
		System.out.println("------------------------------------------");
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("------------------------------------------");
		
	}

	private static boolean findClean(int r, int c) {
		for(int i=0;i<4;i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if(check(nr,nc) == true && map[nr][nc] == 0) return true;
		}
		return false;
	}

	private static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<M;
	}

}




