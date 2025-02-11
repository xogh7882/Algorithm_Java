import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			if(open(str) == true) sb.append("YES").append("\n");
			else sb.append("NO").append("\n");
		}
		
		System.out.println(sb.toString());
	}

	private static boolean open(String str) {
		int cnt = 0;
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)=='(') {
				cnt++;
			}
			else cnt--;
			if(cnt < 0) return false;
		}
		if(cnt==0) return true;
		else return false;
	}

}
