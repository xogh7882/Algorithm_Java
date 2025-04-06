import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// ArrayList
// 메모리 : 38664 KB      시간 : 4925 ms

// HashSet 이랑 메모리는 비슷한데 시간이 너어어어무 오래걸림

public class Main {
	static int N,M;
	static int result = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		List<String> list = new ArrayList<>();
		
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			list.add(str);
		}
		
		for(int i=0;i<M;i++) {
			String str = br.readLine();
			if(list.contains(str)==true) result++;
		}
		System.out.println(result);
	}

}
