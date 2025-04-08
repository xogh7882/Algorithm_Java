import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int arr[];
	static int C[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		arr = new int[501];
		C = new int[501];
		
		
		int idxmin = 501;
		int idxmax = -1;
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a] = b;
			idxmin = Math.min(idxmin, a);
			idxmax = Math.max(idxmax, a);
		}
		
		int size = 0;
		
		for(int i=idxmin;i<=idxmax;i++) {
			if(arr[i] == 0) continue;
			int pos = Arrays.binarySearch(C, 0, size, arr[i]);
			if(pos>=0) continue;
			
			int temp = Math.abs(pos)-1;
			
			C[temp] = arr[i];
			if(temp == size) size++;
		}
		
		System.out.println(N - size);
		
	}

}
