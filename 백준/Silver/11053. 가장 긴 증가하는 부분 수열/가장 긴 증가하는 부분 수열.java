import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int nums[];
	static int x[];
	static int result = 1;
	
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
		
		// 앞에서 부터 체크해서
		// 너 앞에보다 크니?
		// 크면 거기까지 몇개인지 계속 갱신
		
		
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
		
		
	}

	

}
