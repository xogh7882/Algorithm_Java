import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N = 19;
	static int[][] map;
	static int[] dr = {1,-1,0,1};
	static int[] dc = {0, 1,1,1};
	static int resultR , resultC;
	static int winColor = -1;
	
	public static void main(String[] args) throws Exception{
		map = new int[N][N];
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[j][i] != 0) findWin(j,i,map[j][i]);
			}
		}
		
		resultR++;
		resultC++;
		if(winColor == -1) System.out.print(0);
		else {
			System.out.println(winColor);
			System.out.println(resultR + " " + resultC);
		}
		
	}
	
	private static void findWin(int r, int c, int now) {
		int count = 0;
		int cr = r;
		int cc = c;
		for(int i=0;i<4;i++) {
			count = 0;
			r = cr;
			c = cc;
			int prer = r - dr[i];
			int prec = c - dc[i];
			if(check(prer, prec) && map[prer][prec] == now) continue;
			if(check(prer, prec) == false ||(check(prer, prec) && map[prer][prec] != now)) {
				while(true) {
					int nr = r + dr[i];
					int nc = c + dc[i];
					if(check(nr,nc) && map[nr][nc] == now) {
						r = nr;
						c = nc;
						count++;
					}
					else break;
				}
			}
			if(count==4) {
				resultR = cr;
				resultC = cc;
				winColor = now;
				break;
			}
		}
	}
	
	private static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<N;
	}
}
