import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
	static int N;
	static String pattern;
	static int mid;
	static int result = 0;
	static String temp;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		pattern = br.readLine();
		
		for(int i=0;i<pattern.length();i++) {
			if(pattern.charAt(i) == '*') {
				mid = i;
			}
		}
		
		for(int i=0;i<N;i++) {
			result = 0;
			temp = br.readLine();

			if(temp.length() < pattern.length()-1) sb.append("NE").append("\n");
			else {
				
				int ps = 0;
				int ts = 0;
				
				while(true) {
					if(result != 0) break;
					if(ps==mid || ts==temp.length()) break;
					if(pattern.charAt(ps) != temp.charAt(ts)) result++;
					ps++;
					ts++;
				}
				
				
				int pe = pattern.length()-1;
				int te = temp.length()-1;
				
				while(true) {
					if(result != 0) break;
					if(pe==mid || te==-1) break;
					if(temp.charAt(te) != pattern.charAt(pe)) result++;
					te--;
					pe--;
				}
				
				if(result == 0) sb.append("DA").append("\n");
				else sb.append("NE").append("\n");
				
			}
						
		}
		System.out.println(sb.toString());
	}

}
