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
	static int result = 0;
	static Queue<Integer> queue;
	static boolean visited[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		M = Integer.parseInt(br.readLine());
		list = new ArrayList[N+1];
		
		for(int i=0;i<N+1;i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			list[s].add(e);
			list[e].add(s);
		}
		
		
		visited = new boolean[N+1];
		queue = new ArrayDeque<>();
		
		for(int i=0;i<list[1].size();i++) {
			queue.offer(list[1].get(i));
		}
		find();
		
		for(int i=2;i<=N;i++) {
			if(visited[i] == true) result++;
		}
		
		System.out.println(result);
		
	}
	private static void find() {
		while(!queue.isEmpty()) {
			int t = queue.poll();
			visited[t] = true;
			
			for(int i=0;i<list[t].size();i++) {
				visited[list[t].get(i)] = true;
			}
		}
		
	}

}
