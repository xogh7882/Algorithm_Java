import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int[] nums;
	static int count = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		
		nums = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		int x = 0;
		int y = N-1;
		
		Arrays.sort(nums);
		
		while(true) {
			if(x >= y) break;
			if(nums[x] + nums[y] == M) {
				count++;
				x++;
				y--;
			}
			else if(nums[x] + nums[y] > M) {
				y--;
			}
			else {
				x++;
			}
		}
		System.out.println(count);
	}

}
