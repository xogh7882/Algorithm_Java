import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int p[], r[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		makeset();
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			if(k==0) {   // Union
				union(x,y);
			}
			
			else {       // Find
				if(find(x) == find(y)) sb.append("YES").append("\n");
				else sb.append("NO").append("\n");
			}
		}
		System.out.println(sb.toString());
	}
	
	
	
	
	
	private static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x==y) return;
		
		if(r[x] > r[y]) {
			r[x] += r[y];
			p[y] = x;
		}
		else {
			r[y] += r[x];
			p[x] = y;
		}
		
		return;
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
