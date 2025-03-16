import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static List<Integer> list[];
	static int arrIn[];
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N+1];
		for(int i=0;i<N+1;i++) {
			list[i] = new ArrayList<>();
		}
		arrIn = new int[N+1];
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			list[s].add(e);
			arrIn[e]++;
		}
		
		topol();
		
		System.out.println(sb.toString());
		
	}

	private static void topol() {
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		for(int i=1;i<=N;i++) {
			if(arrIn[i] == 0) queue.offer(i);
		}
		
		while(!queue.isEmpty()) {
			int t = queue.poll();
			sb.append(t).append(" ");
			
			for(int i=0;i<list[t].size();i++) {
				arrIn[list[t].get(i)]--;
				if(arrIn[list[t].get(i)]==0) queue.offer(list[t].get(i));
			}
		}
		
	}

}
