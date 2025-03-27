import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int p[],r[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		makeset();
		
		for(int i=0;i<N-2;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			union(a,b);
		}
		
		
		aa:for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				if(i==j) continue;
				else {
					if(find(i) != find(j)) {
						System.out.println(i + " " + j);
						break aa;
					}
				}
			}
		}
		
		
	}

	private static void makeset() {
		p = new int[N+1];
		r = new int[N+1];
		for(int i=0;i<=N;i++) {
			p[i] = i;
			r[i] = 1;
		}
		
	}

	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a==b) return;
		
		if(r[a] > r[b]) {
			r[a] += r[b];
			p[b] = a;
		}
		else {
			r[b] += r[a];
			p[a] = b;
		}
		return;
		
		
	}

	private static int find(int a) {
		if(a==p[a]) return p[a];
		else return find(p[a]);
	}
}
