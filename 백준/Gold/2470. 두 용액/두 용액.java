import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int arr[];
	static int a,b,k,s,e;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		arr = new int[N];
		
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
//		System.out.println(Arrays.toString(arr));
		
		s = 0;
		e = arr.length-1;
		
		a = arr[s];
		b = arr[e];
		k = Math.abs(a+b);
		
		while(true) {
			if(s>=e) break;
			
			int x = arr[s];
			int y = arr[e];
			
			if(Math.abs(x+y) < k) {
				a = arr[s];
				b = arr[e];
				k = Math.abs(a+b);

			}
			
			
			if(Math.abs(arr[s]) > Math.abs(arr[e])) {
				s++;
			}
			else {
				e--;
			}
			
		}
		
		System.out.println(a + " " + b);
		
	}

}
