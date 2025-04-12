import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	static int N;
	static int arr[];
	static int p[];
	static boolean visited[];
	
	static int result = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		p = new int[2];
		visited = new boolean[N];
		combi(0,0,0);
		System.out.println(result);
	}
	
	private static void combi(int cnt, int start, int sum) {
		if(cnt == 2) {
			if(p[1] - p[0] < 2) return;
			calc(sum);
			return;
		}
		
		for(int i=start;i<N;i++) {
			if(visited[i]) continue;
			visited[i] = true;
			p[cnt] = i;
			combi(cnt+1, i, sum + arr[p[cnt]]);
			p[cnt] = 0;
			visited[i] = false;
		}
		
	}

	private static void calc(int sum) {
		int s = p[0] + 1;
		int e = p[1] - 1;
		
		while(true) {
			if(s >= e) break;
			int temp = arr[s] + arr[e];
			if(Math.abs(temp - sum) < result) {
				result = Math.abs(temp - sum);
			}
			if(temp > sum) e--;
			else s++;
		}
		
		return;
	}
	
}
