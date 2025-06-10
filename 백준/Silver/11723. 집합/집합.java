import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int M;
	static int N = 0b00000000000000000000;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		M = Integer.parseInt(br.readLine());
		
		for(int i=0;i<M;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			if(str.equals("all")) {
				N = N | 0b11111111111111111111;
			}
			else if(str.equals("empty")) {
				N = N & 0b00000000000000000000;
			}
			else {
				int k = Integer.parseInt(st.nextToken());
				int t = 1 << (k-1);
				if(str.equals("add")) {
					N = N | t;
				}
				else if(str.equals("remove")) {
					N = N & ~t;
				}
				else if(str.equals("check")) {
					if((N & t) == 0) {
						sb.append("0").append("\n");
					}
					else sb.append("1").append("\n");
				}
				else if(str.equals("toggle")) {
					if((N & t) == 0) {
						N = N | t;
					}
					else N = N & ~t;
				}
			}
			
		}
		
		System.out.println(sb.toString());
	}

}
