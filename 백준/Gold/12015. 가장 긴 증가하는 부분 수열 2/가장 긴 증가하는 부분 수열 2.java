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
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		C = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int size = 0;
		
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			
			int pos = Arrays.binarySearch(C, 0, size, arr[i]);
			
			if(pos >= 0) continue;
			
			int temp = Math.abs(pos)-1;
			
			
			C[temp] = arr[i];
			if(temp==size) {
				size++;
			}
			
		}
		
		
		System.out.println(size);
		
		
	}

}
