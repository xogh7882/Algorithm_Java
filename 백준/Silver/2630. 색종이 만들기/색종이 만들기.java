import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int map[][];
	static int white = 0;
	static int blue = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		find(0,0,N);
		
		System.out.println(white + "\n" + blue);
	}

	private static void find(int r, int c, int size) {
		if(color(r,c,size) == true) {
			if(map[r][c] == 0) white++;
			else blue++;
			return;
		}
		
		int std = size / 2;
		find(r,c,std);
		find(r,c+std,std);
		find(r+std,c,std);
		find(r+std,c+std,std);
		
	}

	private static boolean color(int r, int c, int size) {
		int now = map[r][c];
		
		for(int i=r;i<r+size;i++) {
			for(int j=c;j<c+size;j++) {
				if(map[i][j] != now) return false;
			}
		}
		return true;
	}

	

}
