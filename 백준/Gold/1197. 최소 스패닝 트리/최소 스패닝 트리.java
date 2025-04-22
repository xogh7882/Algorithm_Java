import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N,E;
	
	static class Node implements Comparable<Node>{
		int s;
		int e;
		int w;
		
		public Node(int s, int e, int w) {
			super();
			this.s = s;
			this.e = e;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.w, o.w);
		}
	}
	
	static PriorityQueue<Node> queue = new PriorityQueue<>();
	static int p[];
	static int r[];
	static long result = 0L;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			queue.offer(new Node(s,e,w));
		}
		
		makeset();
		
		while(!queue.isEmpty()) {
			Node cur = queue.poll();
			if(union(cur.s, cur.e) == true) {
				result += cur.w;
			}
		}
		
		System.out.println(result);
		
	}

	private static boolean union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x==y) return false;
		
		if(r[x] < r[y]) {  
			r[y] += r[x];
			p[x] = y;
		}else {
			r[x] += r[y];
			p[y] = x;
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
