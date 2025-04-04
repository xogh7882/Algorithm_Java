import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int T;
	static int N;
	static int result[];
	static int arr[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		arr = new int[T];
		
		int max = -1;
		
		for(int i=0;i<T;i++) {
			N = Integer.parseInt(br.readLine());
			arr[i] = N;
			max = Math.max(max, N);
		}
		
		result = new int[max+1];
		for(int i=1;i<=max;i++) {
			if(i==1) result[i] = 1;
			else if(i==2) result[i] = 2;
			else if(i==3) result[i] = 4;
			else result[i] = result[i-1] + result[i-2] + result[i-3];
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<arr.length;i++) {
			sb.append(result[arr[i]]).append("\n");
		}
		System.out.println(sb.toString());
	}

}
