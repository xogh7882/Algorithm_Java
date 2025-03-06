import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static List<double[]> list;
	static double map[][];
	
	static class Edge implements Comparable<Edge>{
		int s;
		int e;
		double w;
		
		public Edge(int s, int e, double w) {
			super();
			this.s = s;
			this.e = e;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			return Double.compare(this.w, o.w);
		}
		
	}
	
	static int p[];
	static int r[];
	static PriorityQueue<Edge> points;
	static double min;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		list = new ArrayList<>();
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());
			
			list.add(new double[] {x,y});
		}
		
		map = new double[N][N];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				calc(i,j);
			}
		}
		
		points = new PriorityQueue<>();
		p = new int[N];
		r = new int[N];
		min = 0L;
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				points.add(new Edge(i,j,map[i][j]));
			}
		}
		
		makeset();
		
		while(!points.isEmpty()){
			Edge edge = points.poll();
			if(union(edge.s, edge.e)) {
				min += edge.w;
			}
		}
		System.out.printf("%.2f", min);
		
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
		for(int i=0;i<N;i++) {
			p[i] = i;
			r[i] = 1;
		}
		
	}

	private static void calc(int v1, int v2) {
		double temp1[] = list.get(v1);
		double temp2[] = list.get(v2);
		
		double t = distance(temp1,temp2);
		
		map[v1][v2] = t;
		map[v2][v1] = t;
		
		return;
		
	}

	private static double distance(double[] temp1, double[] temp2) {
		double x1 = temp1[0];
		double y1 = temp1[1];
		
		double x2 = temp2[0];
		double y2 = temp2[1];
		
		return Math.sqrt((Math.abs(x1-x2) * Math.abs(x1-x2))+(Math.abs(y1-y2) * Math.abs(y1-y2)));
	}

}
