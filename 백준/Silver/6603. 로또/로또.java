import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int k;
	static int arr[];
	static boolean visited[];
	static int select[];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			if(k==0) break;
			
			arr = new int[k];
			for(int i=0;i<k;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(arr);
			select = new int[6];
			visited = new boolean[k];
			combi(0,0);
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	
	private static void combi(int cnt, int start) {
		if(cnt==6) {
			for(int i=0;i<6;i++) {
				sb.append(select[i]);
				if(i!=5) sb.append(" ");
			}
			sb.append("\n");
			return;
		}
		for(int i=start;i<k;i++) {
			if(visited[i]) continue;
			select[cnt] = arr[i];
			visited[i] = true;
			combi(cnt+1, i);
			select[cnt] = 0;
			visited[i] = false;
		}
		
		
	}

}
