import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int[] num;
	static int[] select;
	static boolean[] visited;
	static StringBuilder sb;
	static int flag = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		num = new int[N];
		select = new int[M];
		visited = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(num);
		sb = new StringBuilder();
		
		perm(0,0);
		
		System.out.println(sb.toString());

	}

	private static void perm(int cnt, int start) {
		if(cnt == M) {
			for(int i=0;i<M;i++) {
				sb.append(select[i] + " ");
			}
			sb.append("\n");
			return;
			
		}
		
		int prev = -1;
		for(int i=start;i<N;i++) {	
			if(num[i] != prev) {
				//visited[i] = true;
				select[cnt] = num[i];
				prev = num[i];
				perm(cnt+1,i);
				//visited[i] = false;
			}
		}
	}

}
