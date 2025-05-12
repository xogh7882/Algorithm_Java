import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static int arr[];
	static int result = Integer.MAX_VALUE/10;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		
		String str = br.readLine();
		
		for(int i=0;i<N;i++) {
			if(str.charAt(i)=='R') arr[i] = 1;
			else arr[i] = 2;
		}
		
		
		// 1번
		int flag = 0;
		int cnt = 0;
		int red = 1;
		int blue = 2;
		
		for(int i=0;i<N;i++) {
			if(flag==0 && arr[i] == red) continue;
			else if(flag!=0 && arr[i] == red) cnt++;
			else if(arr[i] == blue)flag++;
			else continue;
		}
		result = Math.min(result, cnt);
		
		
		// 2번
		flag = 0;
		cnt = 0;
		red = 2;
		blue = 1;
		for(int i=0;i<N;i++) {
			if(flag==0 && arr[i] == red) continue;
			else if(flag!=0 && arr[i] == red) cnt++;
			else if(arr[i] == blue)flag++;
			else continue;
		}
		result = Math.min(result, cnt);
		
		
		
		// 3번
		flag = 0;
		cnt = 0;
		red = 1;
		blue = 2;
		for(int i=N-1;i>=0;i--) {
			if(flag==0 && arr[i] == red) continue;
			else if(flag!=0 && arr[i] == red) cnt++;
			else if(arr[i] == blue)flag++;
			else continue;
		}
		result = Math.min(result, cnt);
		
		// 4번
		flag = 0;
		cnt = 0;
		red = 2;
		blue = 1;
		for(int i=N-1;i>=0;i--) {
			if(flag==0 && arr[i] == red) continue;
			else if(flag!=0 && arr[i] == red) cnt++;
			else if(arr[i] == blue)flag++;
			else continue;
		}
		result = Math.min(result, cnt);
		
		
		System.out.println(result);
		
	}

}
