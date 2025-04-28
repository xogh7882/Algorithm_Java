import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, P;
	static long num;
	
	static long total[];
	static int result = -1;
	
	static List<Long> list = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		num = Long.parseLong(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		
		int temp = Math.max(P, N);
		
		total = new long[temp];
		
		if(N==0) {
			System.out.println(1);
			System.exit(0);
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			total[i] = Long.parseLong(st.nextToken());
		}


		for(int i=0;i<temp;i++) {
			if(num==0 && total[i] <= num) {
				result = i+1;
				System.out.println(result);
				System.exit(0);
				break;
			}
			
			
			if(total[i] <num) {
				result = i+1;
				break;
			}
		}
		
		for(int i=result-1;i>=0;i--) {
			if(num == total[i]) {
				result--;
			}
		}
		
		if(result > P) result = -1;
		System.out.println(result);
		
	}

}
