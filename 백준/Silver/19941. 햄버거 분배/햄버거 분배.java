import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, K;
	static boolean visited[];
	static char arr[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		visited = new boolean[N];
		arr = new char[N];
		
		String str = br.readLine();
		for(int i=0;i<N;i++) {
			char ch = str.charAt(i);
			arr[i] = ch;
		}
		
		int result = 0;
		
		for(int i=0;i<N;i++) {
			if(arr[i] == 'H') continue;
			else {
				if(find(i) == true) result++;
			}
		}
		
//		System.out.println(Arrays.toString(visited));
		System.out.println(result);
		
	}
	private static boolean find(int idx) {
		for(int i=idx-K; i<=idx+K; i++) {
			if(i<0) continue;
			if(i>=N) break;
			if(arr[i] == 'H' && visited[i] == false){
				visited[i] = true;
				return true;
			}
		}
		
		return false;
	}

}
