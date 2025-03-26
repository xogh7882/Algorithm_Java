import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	static int N, M;
	static int arr[];
	static int party[][];
	
	static int p[];
	static boolean lie[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());  // 사람 수
		M = Integer.parseInt(st.nextToken());  // 파티 수
		
		makeset();
		
		st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken());
		arr = new int[k];  // 진실을 아는 사람
		for(int i=0;i<k;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		party = new int[M][];   // party 담고
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			party[i] = new int[t];
			for(int j=0;j<t;j++) {
				party[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		for(int i=0;i<party.length;i++) {
			int a = party[i][0];
			for(int j=1;j<party[i].length;j++) {
				int b = party[i][j];
				union(a,b);
			}
		}
		
		lie = new boolean[N+1];
		
		for(int i=0;i<arr.length;i++) {
			int c = find(arr[i]);
			lie[c] = true;
		}
		
		int result = 0;
		int cnt = 0;
		
		for(int i=0;i<party.length;i++) {
			cnt = 0;
			for(int j=0;j<party[i].length;j++) {
				if(lie[find(party[i][j])] == true) {
					cnt++;
				}
			}
			if(cnt==0) result++;
		}
		
		System.out.println(result);
	}
	
	
	public static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a==b) return;
		p[a] = b;
		return;
	}
	
	public static int find(int x) {
		if(x==p[x]) return p[x];
		else return find(p[x]);
	}
	
	public static void makeset() {
		p = new int[N+1];
		for(int i=0;i<=N;i++) {
			p[i] = i;
		}
	}

}
