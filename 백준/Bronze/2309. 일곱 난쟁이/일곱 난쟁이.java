import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static int[] nums = new int[9];
	static StringTokenizer st;
	static int sum = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		for(int i=0;i<9;i++) {
			st = new StringTokenizer(br.readLine());
			nums[i] = Integer.parseInt(st.nextToken());
			sum+=nums[i];
		}
		
		Arrays.sort(nums);
		
		int k = sum - 100;  // 2개의 합이 k가 되도록
		int i = 0;
		int j = nums.length-1;
		
		while(true) {
			if(nums[i] + nums[j] == k) break;
			else if(nums[i] + nums[j] > k) j--;
			else i++;
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int x=0;x<nums.length;x++) {
			if(x!=i && x!=j) {
				sb.append(nums[x]).append("\n");
			}
		}
		
		System.out.println(sb.toString());

	}

}
