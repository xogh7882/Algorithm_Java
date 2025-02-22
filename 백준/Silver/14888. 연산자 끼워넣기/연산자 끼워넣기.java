import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int num[];
	static boolean visited[];
	static int select[];
	static int op[];
	
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		num = new int[N];
		select = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		op = new int[N-1];
		int cnt = 0;
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<4;i++) {
			int temp = Integer.parseInt(st.nextToken());
			for(int j=0;j<temp;j++){
				op[cnt++] = i;
			}
		}
		
		visited = new boolean[N-1];
		
		perm(0,num[0]);
		
		System.out.println(max);
		System.out.println(min);
		
	}

	
	private static void perm(int cnt, int tot) {
//		System.out.println("cnt : " + cnt + " , tot : " + tot);
		if(cnt==N-1) {
			if(tot > max) max = tot;
			if(tot < min) min = tot;
			return;
		}
		for(int i=0;i<N-1;i++) {
			if(visited[i]) continue;
			visited[i] = true;
			if(op[i] == 0) perm(cnt+1, tot+num[cnt+1]);
			else if(op[i] == 1) perm(cnt+1, tot-num[cnt+1]);
			else if(op[i] == 2) perm(cnt+1, tot*num[cnt+1]);
			else if(op[i] == 3) perm(cnt+1, tot/num[cnt+1]);
			visited[i] = false;
		}

	}

}
