import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static int T, N;
	static int comR, comC, homeR, homeC;
	static List<int[]> list;
	static int num[];
	static boolean visited[];
	static int select[];
	static int result;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		T = Integer.parseInt(st.nextToken());
		
		for(int test_case = 1 ; test_case<=T ; test_case++)
		{
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			comR = Integer.parseInt(st.nextToken());
			comC = Integer.parseInt(st.nextToken());
			
			homeR = Integer.parseInt(st.nextToken());
			homeC = Integer.parseInt(st.nextToken());
			
			list = new ArrayList<>();
			
			for(int i=0;i<N;i++) {
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				list.add(new int[] {r,c});
			}
			
			num = new int[N];
			for(int i=0;i<N;i++) {
				num[i] = i;
			}
			visited = new boolean[N];
			select = new int[N];
			
			result = Integer.MAX_VALUE;
			
			perm(0);
			
			System.out.println("#"+test_case+" " + result);
			
		}
	}

	private static void perm(int cnt) {
		if(cnt==N) {
			calc();
			return;
		}
		for(int i=0;i<N;i++) {
			if(visited[i]) continue;
			visited[i] = true;
			select[cnt] = num[i];
			perm(cnt+1);
			select[cnt] = 0;
			visited[i] = false;
		}
		
	}

	private static void calc() {
		int sum = 0;
		int prevR = comR;
		int prevC = comC;
		for(int i=0;i<N;i++) {
			int temp[] = list.get(select[i]);
			int r = temp[0];
			int c = temp[1];
			if(i==0) {
				sum += distance(prevR, prevC, r, c);
				prevR = r;
				prevC = c;
			}
			else {
				sum+= distance(prevR, prevC, r, c);
				prevR = r;
				prevC = c;
			}
		}
		sum+=distance(prevR, prevC, homeR, homeC);
		if(sum < result) result = sum;
		
	}

	private static int distance(int x1, int y1, int x2, int y2) {
		return Math.abs(x1-x2) + Math.abs(y1-y2);
	}

}
