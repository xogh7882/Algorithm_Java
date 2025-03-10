import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// Kruskal Algorithm

public class Main {
	static int V,E;
	static long min;
	static class Edge implements Comparable<Edge>{
		int s;  // start
		int e;   // end
		int w;  // weight
		public Edge(int s, int e, int w) {
			super();
			this.s = s;
			this.e = e;
			this.w = w;
		}
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.w, o.w);
		}
		
	}
	
	static PriorityQueue<Edge> points;   // w가 작은 것부터 나오도록 쁘리아라라큐 사용
	static int[] p;  // parent ( 최종 부모 )
	static int[] r;  // rank  ( 나랑 몇개가 연결되어있게? )
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		points = new PriorityQueue<>();
		
		
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			points.offer(new Edge(s,e,w));
		}
		
		makeSet();
		int cnt = 0;
		min = 0L;
		while(cnt != V-1) {
			Edge edge = points.poll();
			if(union(edge.s, edge.e)) {
				cnt++;
				min+=edge.w;
			}
		}
		System.out.println(min);
	}

	private static boolean union(int x, int y) {
		x = find(x);
		y = find(y);
		if(x==y) return false;  // 최종 부모가 같다 = 이미 연결되어있다.
		if(r[x] < r[y]) {    // rank가 큰 쪽으로 붙는다.
			r[y] += r[x];
			p[x] = y;
		}else {
			r[x] += r[y];
			p[y] = x;
		}
		return true;
	}

	private static int find(int x) {   // 최종 부모까지 재귀로 찾기
		if(x ==p[x]) return p[x];
		else return find(p[x]);
	}

	private static void makeSet() {
		p = new int[V+1];
		r = new int[V+1];
		for (int i = 0; i < V+1; i++) {
			p[i] = i;  // 각각 분리되어 있어서 자기가 최종 부모
			r[i] = 1;  // 처음에는 각각 다 떨어져있어서 그룹당 1개
		}
	}

}
