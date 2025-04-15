import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int T;
	static int N;
	static int arr[];
	static int p[];
	static boolean visited[];
	static long result;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		for(int test = 1 ; test<= T ; test++)
		{
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			arr = new int[N];
			visited = new boolean[N];
			p = new int[2];
			
			for(int i=0;i<N;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			result = 0;
			Arrays.sort(arr);
			combi(0,0);
			
			System.out.println(result);
			
		}

	}

	private static void combi(int cnt, int start) {
		if(cnt==2) {
			result += gcd(p[0], p[1]);
			return;
		}
		for(int i=start;i<N;i++) {
			if(visited[i]) continue;
			visited[i] = true;
			p[cnt] = arr[i];
			combi(cnt+1, i+1);
			p[cnt] = 0;
			visited[i] = false;
		}
		
		
	}

	private static int gcd(int a, int b) {
		if(a==0) return b;
		else return gcd(Math.max(a, b)%Math.min(a, b), Math.min(a, b));
	}


}
