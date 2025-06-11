import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int T,N,M;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(br.readLine());
		for(int test_case = 1 ; test_case <= T; test_case++)
		{
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			
			int arr[] = new int[N];
			int order[] = new int[N];
			boolean visited[] = new boolean[N];
			
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				order[i] = arr[i];
			}
			
			Arrays.sort(order);
			int orderIdx = N-1;
			int max = order[orderIdx];
			int now = 0;
			int cnt = 1;
			
			while(true) {
				if(visited[now] == true) {
					now++;
					if(now==N) now = 0;
					continue;
				}
				
				
				if(arr[now] == max && now == M) {
					sb.append(cnt).append("\n");
					break;
				}
				
				else if(arr[now] == max) {
					cnt++;
					orderIdx--;
					max = order[orderIdx];
					visited[now] = true;
				}
				
				now++;
				if(now==N) now = 0;
				
			}
		}
		
		System.out.println(sb.toString());
	}

}
