import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int[] arr;
	static int[] nums;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		sb = new StringBuilder();
		nums = new int[M];
		
		Arrays.sort(arr);
		
		perm(0,0);
		
		System.out.println(sb.toString());
		
	}

	private static void perm(int cnt, int start) {
		if(cnt==M) {
			for(int i=0;i<M;i++) {
				sb.append(nums[i] + " ");
			}
			sb.append("\n");
			return;
		}
		for(int i=start;i<N;i++) {
			nums[cnt] = arr[i];
			perm(cnt+1, i);
			nums[cnt] = 0;
		}
		
	}

}
