import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int map[];
	static boolean visited[];
	static int result = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N];
		
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<N;j++) {
				if(str.charAt(j) == 'H') map[i] += (1<<j);
			}
		}
		
//		for(int i=0;i<N;i++) {
//			System.out.println(Integer.toBinaryString(map[i]));
//		}
		
		visited = new boolean[N];
		
		subset(0);
		
		System.out.println(result);
		
	}
	
	// 어느 가로 뒤집을래?
	private static void subset(int cnt) {
		
		if(cnt == N) {
			result = Math.min(result, calc());
			return;
		}
		
		visited[cnt] = true;
		subset(cnt+1);
		visited[cnt] = false;
		subset(cnt+1);
		
	}

	private static int calc() {
		
		for(int i=0;i<N;i++) {
			if(visited[i] == true) changeRow(i);
		}
		
		int cnt = 0;
		
		for(int i=0;i<N;i++) {
			int now = 0;
			for(int j=0;j<N;j++) {
				if((map[j] & (1<<i)) == 0) now++;
			}
			cnt += Math.min(now, N-now);
		}
		
		for(int i=0;i<N;i++) {
			if(visited[i] == true) changeRow(i);
		}
		
		return cnt;
	}


	private static void changeRow(int r) {
		map[r] = ~map[r];
	}
	
}
