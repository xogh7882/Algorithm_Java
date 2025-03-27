import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	
	static class Edge{
		int s;
		int e;
		int w;
		
		public Edge(int s, int e, int w) {
			super();
			this.s = s;
			this.e = e;
			this.w = w;
		}
	}
	
	static PriorityQueue<Edge> queue1;
	static PriorityQueue<Edge> queue2;
	
	static long max=0;
	static long min=0;
	
	static int p[], r[];
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		queue1 = new PriorityQueue<>((o1,o2) -> Integer.compare(o1.w, o2.w));
		queue2 = new PriorityQueue<>((o1,o2) -> Integer.compare(o2.w, o1.w));
		
		for(int i=0;i<M+1;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			if(w==0) w = 1;
			else w=0;
			
			queue1.offer(new Edge(s,e,w));
			queue2.offer(new Edge(s,e,w));
	
		}
		
		makeset();
		min = MST(queue1);
		
		makeset();
		max = MST(queue2);
		
		System.out.println((max*max) - (min*min));
		
	}


	private static long MST(PriorityQueue<Edge> queue) {
		int cnt = 0;
		long result = 0;
		while(!queue.isEmpty()) {
			Edge edge = queue.poll();
			
			if(union(edge.s, edge.e) == false ) continue;
			result += edge.w;
			cnt++;
			if(cnt==N) break;
		}
		return result;
	}


	private static boolean union(int x, int y) {
		x = find(x);
		y = find(y);
		if(x==y) return false;
		
		if(r[x] > r[y]) {
			r[x] += r[y];
			p[y] = x;
		}
		else {
			r[y] += r[x];
			p[x] = y;
		}
		
		return true;
	}


	private static int find(int x) {
		if(x==p[x]) return p[x];
		else return find(p[x]);
	}


	private static void makeset() {
		p = new int[N+1];
		r = new int[N+1];
		
		for(int i=0;i<=N;i++) {
			p[i] = i;
			r[i] = 1;
		}
	}

}
