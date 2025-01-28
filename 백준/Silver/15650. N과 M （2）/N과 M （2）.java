import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static int M;
	private static int[] nums;
	private static int[] result;
	private static boolean[] visited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		nums = new int[N];
		result = new int[M];
		visited = new boolean[N];
		
		for(int i=0;i<N;i++) {
			nums[i] = i+1;
		}
		
		perm(0, 0);

	}
	
	private static void perm(int cnt, int start) {
		if(cnt == M) {
			for(int i=0;i<M;i++) {
				System.out.print(result[i] + " ");
			}
			System.out.println();
			return;
		}
		else {
			for(int i=start;i<N;i++) {
				if(visited[i] == true) continue;
				visited[i] = true;
				result[cnt] = nums[i];
				perm(cnt+1, i+1);
				result[cnt] = 0;
				visited[i] = false;
			}
		}
		
	}

}
