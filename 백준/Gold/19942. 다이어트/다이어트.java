import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int std[];
	static int list[][];
	static boolean visited[];
	static int resultCost = Integer.MAX_VALUE;
	static String resultOrder = "";
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		std = new int[4];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<4;i++) {
			std[i] = Integer.parseInt(st.nextToken());
		}
		
		list = new int[N][5];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<5;j++) {
				list[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited = new boolean[N];
		subset(0);
		if(resultCost == Integer.MAX_VALUE) System.out.println("-1");
		else {
			System.out.println(resultCost);
			System.out.println(resultOrder);
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
		int sum[] = new int[5];
		String order= "";
		
		for(int i=0;i<N;i++) {
			if(visited[i] == true) {
				for(int j=0;j<5;j++) {
					sum[j] += list[i][j];
				}
				order += (i+1) + " ";
			}
		}
		
		for(int i=0;i<4;i++) {
			if(std[i] > sum[i]) return;
		}
		
		
		if(resultCost > sum[4]) {
			resultCost = sum[4];
			resultOrder = order;
		}
		
		else if(resultCost == sum[4]) {
			if(resultOrder.compareTo(order) > 0) {
				resultOrder = order;
			}
		}
		
		
	}

}
