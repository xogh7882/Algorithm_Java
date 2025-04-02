import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N,M, start, end;
	static class Edge implements Comparable<Edge>{
		int e;
		int w;
		
		public Edge(int e, int w) {
			super();
			this.e = e;
			this.w = w;
		}
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.w, o.w);
		}
	}
	
	static List<Edge> list[];
	static int result[];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		list = new ArrayList[N+1];
		for(int i=0;i<N+1;i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list[s].add(new Edge(e,w));
		}
		
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		result = new int[N+1];
		Arrays.fill(result, Integer.MAX_VALUE/10);
		
		dijkstra();
		
		System.out.println(result[end]);

	}

	private static void dijkstra() {
		boolean visited[] = new boolean[N+1];
		PriorityQueue<Edge> queue = new PriorityQueue<>();
		queue.offer(new Edge(start, 0));
		
		while(!queue.isEmpty()) {
			Edge cur = queue.poll();
			if(visited[cur.e]) continue;
			visited[cur.e] = true;
			result[cur.e] = cur.w;
			
			for(int i=0;i<list[cur.e].size();i++) {
				int cost = cur.w + list[cur.e].get(i).w;
				if(result[list[cur.e].get(i).e] > cost) {
					queue.offer(new Edge(list[cur.e].get(i).e , cost));
				}
			}
		}
		
	}

}
