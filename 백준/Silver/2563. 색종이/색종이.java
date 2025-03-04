import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static boolean map[][];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new boolean[101][101];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			for(int x=s;x<s+10;x++) {
				for(int y=e;y<e+10;y++) {
					map[x][y] = true;
				}
			}
		}
		int result = 0;
		
		for(int i=0;i<map.length;i++) {
			for(int j=0;j<map.length;j++) {
				if(map[i][j] == true) result++;
			}
		}
		
		System.out.println(result);

	}

}
