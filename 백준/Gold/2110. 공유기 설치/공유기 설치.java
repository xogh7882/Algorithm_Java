import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, C;
	static int arr[];
	static int s,e,m;
	static int result = -1;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		s = 1;
		e = arr[arr.length-1];
		
		while(true) {
			if(s>e) break;
			m = (s+e)/2;
			
			int n = calc(m);
			
			if(n >= C-1) {
				result = Math.max(result, m);
				s = m + 1;
			}
			else {
				e = m - 1;
			}
			
		}
		
		System.out.println(result);
		
	}

	private static int calc(int x) {
		int p = 0;
		int q = 0;
		int cnt = 0;
		
		while(true) {
			if(q==arr.length) break;
			if(arr[q] - arr[p] >= x) {
				cnt++;
				p = q;
			}
			else {
				q++;
			}
			
		}
		return cnt;

	}

}
