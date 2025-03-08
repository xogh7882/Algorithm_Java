import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int limit[];
	static int num[][];
	
	static String order;
	static int mincost = Integer.MAX_VALUE;
	
	static boolean visited[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		limit = new int[4];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<4;i++) {
			limit[i] = Integer.parseInt(st.nextToken());
		}
		
		num = new int[N][5];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<5;j++) {
				num[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited = new boolean[N];
		subset(0);
		if(mincost == Integer.MAX_VALUE) {
			System.out.println(-1);
		}
		else {
			System.out.println(mincost);
			System.out.println(order);
		}
	}


	private static void subset(int cnt) {
		if(cnt==N) {
			calc();
			return;
		}
		
		visited[cnt] = true;
		subset(cnt+1);
		visited[cnt] = false;
		subset(cnt+1);
		
	}


	private static void calc() {
		String str = "";
		int sum[] = new int[5];
		
		for(int i=0;i<N;i++) {
			if(visited[i] == true) {
				str+=Integer.toString(i+1);
				str+=" ";
				for(int j=0;j<5;j++) {
					sum[j] += num[i][j];
				}
			}
		}
		
		for(int i=0;i<4;i++) {
			if(limit[i] > sum[i]) return;
		}
		
		if(sum[4] < mincost) {
			mincost = sum[4];
			order = str;
		}
		
        // 같으면 앞에서 부터 비교해서 사전 순서가 빠른걸로
		else if(sum[4] == mincost) {
			if(order.length() == 0 || str.compareTo(order) < 0) {
				order = str;
			}
		}
		
		return;
		
	}

}
