import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int target;
	static int result = 0;
	static int nums[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		nums = new int[] {64,32,16,8,4,2,1};
		
		target = Integer.parseInt(st.nextToken());
		int cnt = 0;
		
		while(true) {
			if(target == 0) break;
			if(target >= nums[cnt]) {
				target -= nums[cnt];
				result++;
			}
			cnt++;
		}
		
		
		System.out.println(result);
	}

}