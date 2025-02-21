import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int L,C;
	static String[] arr;
	static String[] select;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		arr = new String[C];
		select = new String[L];
		visited = new boolean[C];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<C;i++) {
			arr[i] = st.nextToken();
		}
		
		Arrays.sort(arr);
		
		perm(0,0);

	}

	private static void perm(int cnt, int start) {
		if(cnt == L) {
			print();
			return;
		}
		for(int i=start;i<C;i++) {
			if(visited[i]) continue;
			visited[i] = true;
			select[cnt] = arr[i];
			perm(cnt+1,i);
			select[cnt] = "";
			visited[i] = false;
		}
		
	}

	private static void print() {
		int cnt1 = 0;
		int cnt2 = 0;
		String str = "";
		for(int i=0;i<L;i++) {
			str += select[i];
			if(select[i].equals("a") ||select[i].equals("e") ||select[i].equals("i")||select[i].equals("o")||select[i].equals("u")) {
				cnt1++;
			}
			else cnt2++;
		}
		if(cnt1>=1 && cnt2>=2) System.out.println(str);
	}

}
