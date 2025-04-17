import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,K;
	static int arr[];
	static int result = Integer.MAX_VALUE/10;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		int s = -1;
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if(s==-1 && arr[i] == 1) s = i;
		}
		
		int e = s;
		int cnt = 1;
		
		while(true) {
			e++;
			if(e==N) break;
			if(arr[e] == 1) {
				cnt++;
				if(cnt==K) {
					result = Math.min(result, e-s+1);
					while(true) {
						s++;
						if(arr[s] == 1) break;
					}
					cnt--;
				}
			}
		}
		if(result == Integer.MAX_VALUE/10) System.out.println(-1);
		else System.out.println(result);
	}

}
