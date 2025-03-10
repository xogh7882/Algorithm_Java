import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


// MST - Prim 알고리즘
// weight가 작은 것부터 선택?

public class Main {
	static int V,E;
	static class P{
		int v;  
		int w;
		public P(int v, int w) {
			super();
			this.v = v;
			this.w = w;
		} 
		
	}
	
	static PriorityQueue<P> points;  
	static int min;
	static boolean[] visited;
	static List<P>[] adj;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		points = new PriorityQueue<>((o1,o2) -> (Integer.compare(o1.w, o2.w)));
		
		adj = new ArrayList[V+1];
		for(int i=0;i<V+1;i++) {
			adj[i] = new ArrayList<>();
		}
		
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			adj[s].add(new P(e,w));
			adj[e].add(new P(s,w));
		}
		
		min = prim();
		
		System.out.println(min);
	}

	private static int prim() {
		int min = 0;
		visited = new boolean[V+1];
		points = new PriorityQueue<>((o1,o2) -> (Integer.compare(o1.w, o2.w)));
		points.offer(new P(1,0));  // 시작점이 어디든 상관없다
		
		int count = 0;
		while(!points.isEmpty()) {
			P cur = points.poll();
			if(visited[cur.v]) continue;
			min += cur.w;
			visited[cur.v] = true;
			if(V-1 == count) return min;
			for (int i = 0; i < adj[cur.v].size(); i++) {
				P next = adj[cur.v].get(i);
				if(visited[next.v]) continue;
				points.offer(next);
			}
		}
		
		return min;
	}

}
