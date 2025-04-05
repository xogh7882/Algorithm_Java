import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static long map[][];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		map = new long[31][31];
		
		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N==0) break;
			
			sb.append(medicine(N,0)).append("\n");
			
			
		}
		System.out.println(sb.toString());
	}

	private static long medicine(int a, int b) {
		if(a==0) return 1;
		if(map[a][b] != 0) return map[a][b];
		
		if(b==0) {
			map[a][b] = medicine(a-1,b+1);
			return map[a][b];
		}
		else {
			map[a-1][b+1] = medicine(a-1,b+1);
			map[a][b-1] = medicine(a,b-1);
			return map[a-1][b+1] + map[a][b-1];
		}
		
	}

}
