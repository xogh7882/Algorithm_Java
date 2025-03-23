import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,K;
	static int x,y;
	static boolean map[][];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new boolean[1001][1001];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int nx = Integer.parseInt(st.nextToken());
			int ny = Integer.parseInt(st.nextToken());
			
			map[Math.abs(ny-500)][Math.abs(nx+500)] = true;
		}
		
		String str = br.readLine();
		
		
		
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i) == 'U') {
				if(map[Math.abs(y+1-500)][Math.abs(x+500)] == false) {
					y++;
				}
			}
			else if(str.charAt(i) == 'D') {
				if(map[Math.abs(y-1-500)][Math.abs(x+500)] == false) {
					y--;
				}
			}
			
			else if(str.charAt(i) == 'R') {
				if(map[Math.abs(y-500)][Math.abs(x+1+500)] == false) {
					x++;
				}
			}
					
			else if(str.charAt(i) == 'L') {
				if(map[Math.abs(y-500)][Math.abs(x-1+500)] == false) {
					x--;
				}
			}
			
		}
		System.out.println(x + " " + y);
		
	}

}
