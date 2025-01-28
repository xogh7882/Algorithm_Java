
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int[] nums;
	static int[] p;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		nums = new int[M];
		visited = new boolean[N];
		p = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			p[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(p);
		
		StringBuilder sb = new StringBuilder();
		perm(0,sb);
		System.out.println(sb.toString());
		
		
	}

	private static void perm(int depth, StringBuilder sb) {
		if(depth == M) {
			for(int i=0;i<M;i++) {
				sb.append(nums[i] + " ");
			}
			sb.append("\n");
			return;
		}
		for(int i=0;i<N;i++) {
			if(visited[i]) continue;
			visited[i] = true;
			nums[depth] = p[i];
			perm(depth+1,sb);
			nums[depth] = 0;
			visited[i] = false;
		}
		
	}

}
