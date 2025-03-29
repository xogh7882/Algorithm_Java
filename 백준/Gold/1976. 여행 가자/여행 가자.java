import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int p[], r[];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		makeset();
		
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=N;j++) {
				int k = Integer.parseInt(st.nextToken());
				if(i==j) union(i,j);
				if(k==1) union(i,j);
			}
		}
		
		int result = 0;
		int prev = -1;
		int next = -1;
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			if(i==0) {
				prev = Integer.parseInt(st.nextToken());
				prev = find(prev);
			}
			
			else {
				next = Integer.parseInt(st.nextToken());
				if(prev!= find(next)) {
					result++;
					break;
				}
			}
		}
		
		if(result==0) System.out.println("YES");
		else System.out.println("NO");

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
