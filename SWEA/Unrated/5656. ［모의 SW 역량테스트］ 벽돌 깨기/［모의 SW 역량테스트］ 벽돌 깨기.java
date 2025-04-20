import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int T;
	static int N,W,H;
	static int map[][];
	static int copymap[][];
	
	static int p[];
	static int result;
	static BufferedReader br;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		for(int test=1;test<=T;test++)
		{
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			
			map = new int[H][W];
			for(int i=0;i<H;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<W;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			result = Integer.MAX_VALUE/10;
			
			p = new int[N];
			
			subset(0);
	
			sb.append("#").append(test).append(" ").append(result).append("\n");
		}
		System.out.println(sb.toString());

	}
	private static void subset(int cnt) {
		if(cnt==N) {
			calc();
			return;
		}
		for(int i=0;i<W;i++) {
			p[cnt] = i;
			subset(cnt+1);
			p[cnt] = 0;
		}
		return;
	}
	
	private static void calc() {
		copymap = new int[H][W];
		for(int i=0;i<H;i++) {
			copymap[i] = map[i].clone();
		}
		
		for(int i=0;i<N;i++) {
			int c = p[i];
			int r = 0;
			while(true) {
				if(r==H) {
					checkblock();
					return;
				}
				if(copymap[r][c] != 0) break;
				r++;
			}
			
			breakWall(r,c);
			
			for(int t=H-1;t>=0;t--) {
				for(int j=0;j<W;j++) {
					if(copymap[t][j] != 0) down(t,j);
				}
			}
		}
		
		checkblock();
		
		
//		System.out.println("==================================");
//		System.out.println(Arrays.toString(p));
//		printMap();
//		System.out.println(result);
//		System.out.println("==================================");
//		
//		try {
//			String str = br.readLine();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
	}
	
	
	
	private static void checkblock() {
		int sum = 0;
		for(int i=0;i<H;i++){
			for(int j=0;j<W;j++) {
				if(copymap[i][j] != 0) sum++;
			}
		}	
		
		result = Math.min(result, sum);
	}
	
	
	
	private static void down(int r, int c) {
		while(true) {
			r++;
			if(check(r,c) == false || copymap[r][c] != 0) break;
			else{
				copymap[r][c] = copymap[r-1][c];
				copymap[r-1][c] = 0;
			}
		}
		
		return;
		
	}
	
	private static void breakWall(int r, int c) {
		if(copymap[r][c] == 1) {
			copymap[r][c] = 0;
			return;
		}
		
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {r,c,copymap[r][c]});
		int dr[] = {0,0,1,-1};
		int dc[] = {1,-1,0,0};
		
		while(!queue.isEmpty()) {
			int temp[] = queue.poll();
			int cr = temp[0];
			int cc = temp[1];
			int ck = temp[2];
			copymap[cr][cc] = 0;
			for(int i=0;i<4;i++) {
				int nr = cr;
				int nc = cc;
				for(int j=0;j<ck-1;j++) {
					nr += dr[i];
					nc += dc[i];
					if(check(nr,nc) == false) continue;
					if(copymap[nr][nc] > 1) queue.offer(new int[] {nr,nc,copymap[nr][nc]});
					copymap[nr][nc] = 0;
				}
			}
		}
		
	}
	private static boolean check(int r, int c) {
		return r>=0 && r<H && c>=0 && c<W;
	}
	private static void printMap() {
		System.out.println("-------Print Map-------");
		for(int i=0;i<H;i++) {
			for(int j=0;j<W;j++) {
				System.out.print(copymap[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

}
