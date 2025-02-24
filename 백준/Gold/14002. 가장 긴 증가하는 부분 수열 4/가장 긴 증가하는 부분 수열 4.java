import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int nums[];
	static int x[];
	static int result = 1;
	
	static int select[];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		nums = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		x = new int[N];
		
		for(int i=0;i<N;i++) {
			x[i] = 1; 
			for(int j=0;j<i;j++) {
				if(nums[i] > nums[j] && x[i] < x[j]+1) {
					x[i] = x[j]+1;
				}
			}
			result = Math.max(result, x[i]);
		}
		System.out.println(result);
		
		select = new int[result];
		int cnt = 0;
		int max = Integer.MAX_VALUE;
		StringBuilder sb = new StringBuilder();
		for(int i=N-1;i>=0;i--) {
			if(x[i] == result && nums[i] < max) {
				select[cnt++] = nums[i];
				result--;
				max = nums[i];
			}
		}
		
		int k = select.length;
		for(int i=k-1;i>=0;i--) System.out.print(select[i] + " ");	
	}


}
