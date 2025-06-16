import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static long arr[][];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		arr = new long[N][N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<=i;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=1;i<N;i++) {
			for(int j=0;j<=i;j++) {
				if(j==0) {
					arr[i][j] = arr[i-1][j] + arr[i][j];
				}
				else {
					arr[i][j] = Math.max(arr[i-1][j-1] + arr[i][j], arr[i-1][j] + arr[i][j]);
				}
			}
		}
		long result = 0;
		for(int i=0;i<N;i++) {
			result = Math.max(result, arr[N-1][i]);
		}
		System.out.println(result);
	}

}
