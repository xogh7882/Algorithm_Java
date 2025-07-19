import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static double map[];
	static double result = -1;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new double[N];
		
		for(int i=0;i<N;i++) {
			double k = Double.parseDouble(br.readLine());
			
			if(i==0) {
				map[i] = k;
			}
			else {
				map[i] = Math.max(map[i-1]*k, k);
			}
			result = Math.max(result, map[i]);
		}
		
		System.out.printf("%.3f", result);

	}

}
