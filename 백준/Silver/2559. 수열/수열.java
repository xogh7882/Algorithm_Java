import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, K;
	static int[] nums;
	static int result = Integer.MIN_VALUE;
	static int sum = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		nums = new int[N];
		int x = 0;
		int y = 0;
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			if(y<K) {
				sum += nums[i];
				y++;
			}
		}
		if(sum > result) result = sum;
//		System.out.println("x : " + x + " | y : " + y + " | sum : " + sum);
		while(true) {
			if(y == N) break;
			sum -= nums[x];
			x++;
			sum += nums[y];
			y++;
//			System.out.println("x : " + x + " | y : " + y + " | sum : " + sum);
			
			if(sum > result) result = sum;
		}
		
		System.out.println(result);
		
	}

}
