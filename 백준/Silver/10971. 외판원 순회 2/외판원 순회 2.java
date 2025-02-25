import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int map[][];
	static int num[];
	static boolean visited[];
	static int select[];
	static int result = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		visited = new boolean[N];
		num = new int[N];
		for(int i=0;i<N;i++) {
			num[i] = i;
		}
		select = new int[N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		perm(0);
		
		System.out.println(result);
	}

	private static void perm(int cnt) {
		if(cnt == N) {
			calc();
			return;
		}
		for(int i=0;i<N;i++) {
			if(visited[i]) continue;
			visited[i] = true;
			select[cnt] = num[i];
			perm(cnt+1);
			select[cnt] = 0;
			visited[i] = false;
		}
		
	}

	private static void calc() {

		int start = select[0];
		int prev = -1;
		int sum = 0;
		for(int i=0;i<N;i++) {
			if(i==0) {
				prev = select[i];
			}
			else {
				if(map[prev][select[i]] == 0) return;
				else {
					sum += map[prev][select[i]];
					prev = select[i];
				}
			}
			
		}
		if(map[prev][start] == 0) return;
		sum += map[prev][start];
		
		if(sum < result) result = sum;
		
		
	}

}
