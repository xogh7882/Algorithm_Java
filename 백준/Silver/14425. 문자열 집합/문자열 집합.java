import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

// HashSet

public class Main {
	static int N,M;
	static int result = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		HashSet<String> set = new HashSet<>();
		
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			set.add(str);
		}
		
		for(int i=0;i<M;i++) {
			String str = br.readLine();
			if(set.contains(str)==true) result++;
		}
		System.out.println(result);
	}

}
