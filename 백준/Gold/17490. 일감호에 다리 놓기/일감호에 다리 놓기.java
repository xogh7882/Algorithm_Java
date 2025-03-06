import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int countRock[];
	static long K;
	
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
	
	static int p[];
	static int r[];
	static long min;
	static PriorityQueue<Edge> points;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Long.parseLong(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		countRock = new int[N];
		for(int i=0;i<N;i++) {
			countRock[i] = Integer.parseInt(st.nextToken());
		}
		
		int start = -1;
		
		boolean visited[] = new boolean[N];
		Arrays.fill(visited, true);
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			if(s==1 || e==1) visited[Math.max(s-1, e-1)] = false;
			else visited[Math.min(s-1, e-1)] = false;
			start = Math.max(s-1, e-1);  // 마지막으로 공사한 지역부터 시작할거임
		}
		// M개의 공사를 하면 구역이 M개로 나뉜다
		
		
		if(M<=1) {  
			System.out.println("YES");
			return;
		}
		
		points = new PriorityQueue<>();
		
        // 공사 다음 구역부터 시작해서 M개로 나누기
        // 각 지역마다 돌맹이 개수 가장 작은걸로
        
		int top = start;
		int minW = countRock[top];
		
		int cnt = 0;
		while(true) {
			if(points.size()==M) break;
			
			if(visited[start]==true) {
				start++;
				start = start%N;
				minW = Math.min(countRock[start], minW);
			}
			else {
				points.add(new Edge(cnt++, M, minW));
				start++;
				start = start%N;
				top = start;
				minW = countRock[top];
			}
			
		}
		
		makeset();
		while(!points.isEmpty()) {
			Edge edge = points.poll();
			if(union(edge.s, edge.e)){
				min += edge.w;
			}
		}
		
		//System.out.println(min);

		if(min <= K) System.out.println("YES");
		else System.out.println("NO");
		
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
		if(x == p[x]) return p[x];
		else return find(p[x]);
	}

	private static void makeset() {
		p = new int[M+1];
		r = new int[M+1];
		for(int i=0;i<M+1;i++) {
			p[i] = i;
			r[i] = 1;
		}
	}

	
}

