import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] p; // parent
	static int[] r; // rank
	
	static class Edge implements Comparable<Edge>{
		int s;
		int e;
		int w;
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
	
	static PriorityQueue<Edge> points;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		
		points = new PriorityQueue<>();
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			points.offer(new Edge(s,e,w));
		}
		p = new int[N+1];
		r = new int[N+1];
		
		int min = 0;
		
		makeSet();
		
		int cnt = 0;   // 간선 개수
		
		while(cnt != N-1) {  // 간선 N-1개 이면 끝
			Edge edge = points.poll();
			if(union(edge.s, edge.e)) {
				cnt++;
				min += edge.w;
			}
		}
		
		System.out.println(min);
		
	}
	

	private static boolean union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x==y) return false;  // 부모가 같다
		if(r[x] < r[y]) {
			r[y] += r[x];
			p[x] = y;
		}
		else {
			r[x] += r[y];
			p[y] = x;
		}
		return true;
	}


	private static int find(int x) {
		if(x == p[x] ) return x;
		else return find(p[x]);
	}


	private static void makeSet() {
		for(int i=0;i<N+1;i++) {
			p[i] = i;
			r[i] = 1;
		}
	}

}
