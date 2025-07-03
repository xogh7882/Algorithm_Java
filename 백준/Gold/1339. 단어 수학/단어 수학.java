import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;


public class Main {
	static int N;
	static String map[];
	static int count[];
	
	static boolean visited[];
	static HashMap<Character, Integer> hash = new HashMap<Character, Integer>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new String[N];
		
		for(int i=0;i<N;i++) {
			map[i] = br.readLine();
		}
		
		count = new int[26];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<map[i].length();j++) {
				count[map[i].charAt(j)-'A'] += Math.pow(10L,(double)(map[i].length()-j)-1);
			}
		}
		
		visited = new boolean[26];
		
		int cnt = 9;
		for(int i=0;i<10;i++) {
			int max = -1;
			int idx = -1;
			for(int j=0;j<26;j++) {
				if(visited[j] == false && count[j] > max ) {
					max = count[j];
					idx = j;
				}
			}
			char ch = (char) ('A' + idx);
			hash.put(ch, cnt);
			cnt--;
			visited[idx] = true;
		}
		
		int result = 0;
				
		for(int i=0;i<N;i++) {
			int now = 0;
			for(int j=0;j<map[i].length();j++) {
				now += hash.get(map[i].charAt(j));
				now *= 10;
			}
			now /= 10;
			result += now;
		}
		System.out.println(result);
		
	}

}
