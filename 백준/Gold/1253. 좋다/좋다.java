import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	static int N;
	static int arr[];
	static int result = 0;
	static int s,e,mid;
	
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
		
		
		for(int i=0;i<N;i++) {
			s=0;
			e=arr.length-1;
			
			while(true) {
				if(s==i) {
					s++;
					continue;
				}
				if(e==i) {
					e--;
					continue;
				}
				
				
				if(s>=e) break;
				if(arr[s]+arr[e] == arr[i]) {
					result++;
					break;
				}
				
				else if(arr[s]+arr[e] > arr[i]) {
					e--;
				}
				else {
					s++;
				}
			}
			
		}
		
		System.out.println(result);
		

	}

}
