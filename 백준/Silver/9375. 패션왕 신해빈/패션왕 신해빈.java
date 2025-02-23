import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static int T;
	static int N;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		
		for(int test_case = 1 ; test_case <= T ; test_case++)
		{
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			
			Map<String, Integer> map = new HashMap<>();
			
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				String name = st.nextToken();
				String kind = st.nextToken();
				if(map.containsKey(kind) == true) {
					int count = map.get(kind);
					map.put(kind, count+1);
				}
				else {
					map.put(kind, 1);
				}
			}
			
			int result = 1;

			for (int value : map.values()) {
				result *= (value+1);
			}
			
			System.out.println(result-1);
			
		}

	}

}
