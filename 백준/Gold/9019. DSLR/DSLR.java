import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static int T;
	static int a,b;
	
	static class DSLR{
		int num;
		String str;
		
		public DSLR(int num, String str) {
			super();
			this.num = num;
			this.str = str;
		}

	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		for(int test = 1 ; test<=T ; test++)
		{
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			System.out.println(BFS());

		}
	
	}

	private static String BFS() {
		boolean visited[] = new boolean[10000];
		Queue<DSLR> queue = new ArrayDeque<>();
		queue.offer(new DSLR(a,""));
		
		while(!queue.isEmpty()) {
			DSLR cur = queue.poll();
			visited[cur.num] = true;
			
			if(cur.num==b) return cur.str;
			
			if(visited[D(cur.num)] == false) {
				queue.offer(new DSLR(D(cur.num), cur.str+"D"));
				visited[D(cur.num)] = true;
			}
			
			if(visited[S(cur.num)] == false) {
				queue.offer(new DSLR(S(cur.num), cur.str+"S"));
				visited[S(cur.num)] = true;
			}
			
			if(visited[L(cur.num)] == false) {
				queue.offer(new DSLR(L(cur.num), cur.str+"L"));
				visited[L(cur.num)] = true;
			}
			
			if(visited[R(cur.num)] == false) {
				queue.offer(new DSLR(R(cur.num), cur.str+"R"));
				visited[R(cur.num)] = true;
			}
		}
		return "";
	}
	
	private static int R(int cur) {
		int arr[] = NumToD(cur);
		int temp = arr[3];
		
		arr[3] = arr[2];
		arr[2] = arr[1];
		arr[1] = arr[0];
		arr[0] = temp;
		
		int result = DToNum(arr);
		return result;
		
	}
	
	private static int L(int cur) {
		int arr[] = NumToD(cur);
		int temp = arr[0];
		arr[0] = arr[1];
		arr[1] = arr[2];
		arr[2] = arr[3];
		arr[3] = temp;
		
		int result = DToNum(arr);
		return result;
		
	}

	private static int S(int cur) {
		int result = cur - 1;
		if(result == -1) return 9999;
		else return result;
		
	}
	
	private static int D(int cur) {
		int result = ( cur * 2 ) % 10000;
		return result;
		
	}

	private static int DToNum(int[] dd) {
		int result = 0;
		for(int i=0;i<4;i++) {
			if(i==0) {
				result = dd[i];
			}
			else {
				result*=10;
				result += dd[i];
			}
		}
		return result;
	}

	private static int[] NumToD(int a) {
		int d[] = new int[4];
		int cnt = 3;
		while(a>0) {
			d[cnt--] = a%10;
			a /=10;
		}
		return d;
	}

	
}
