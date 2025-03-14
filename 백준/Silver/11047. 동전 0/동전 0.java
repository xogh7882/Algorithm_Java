import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,K;
	static int arr[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int idx = N-1;
		int result = 0;
		while(true) {
			if(idx < 0) break;
			if(arr[idx] > K) {
				idx--;
				continue;
			}
			result += K/arr[idx];
			K %=arr[idx];
			idx--;
		}
		System.out.println(result);

	}

}
