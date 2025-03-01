import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static Map<String, Integer> map;
	static Map<Integer, String> map2;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new HashMap<>();
		map2 = new HashMap<>();
		
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			map.put(str, i+1);
			map2.put(i+1, str);
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<M;i++) {
			String str = br.readLine();
			// 숫자인지 아니면 이름인지
			try {
				int N = Integer.parseInt(str);
				sb.append(map2.get(N)).append("\n");
				
			}catch(NumberFormatException e) {
				sb.append(map.get(str)).append("\n");
			}
			
		}
		
		System.out.println(sb);

	}

}
