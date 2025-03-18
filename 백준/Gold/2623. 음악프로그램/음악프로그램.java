import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static List<Integer> list[];
	static int arrIn[];
	static int cnt = 0;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N+1];
		arrIn = new int[N+1];
		for(int i=0;i<N+1;i++) {
			list[i] = new ArrayList<>();
		}
		
		int s = -1;
		int e = -1;
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			for(int j=0;j<k;j++) {
				if(j==0) {
					s = Integer.parseInt(st.nextToken());
				}
				else if(j==1) {
					e = Integer.parseInt(st.nextToken());
					list[s].add(e);
					arrIn[e]++;
				}
				else {
					s = e;
					e = Integer.parseInt(st.nextToken());
					list[s].add(e);
					arrIn[e]++;
				}
			}
		}
		
		topol();
		
		if(cnt==N) System.out.println(sb.toString());
		else System.out.println(0);
		
	}

	private static void topol() {
		Queue<Integer> queue = new ArrayDeque<>();
		for(int i=1;i<=N;i++) {
			if(arrIn[i] == 0) queue.offer(i);
		}
		
		while(!queue.isEmpty()) {
			int temp = queue.poll();
			sb.append(temp).append("\n");
			cnt++;
			for(int i=0;i<list[temp].size();i++) {
				arrIn[list[temp].get(i)]--;
				if(arrIn[list[temp].get(i)] == 0) {
					queue.offer(list[temp].get(i));
				}
			}
		}
		
	}

}
