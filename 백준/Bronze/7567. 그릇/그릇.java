import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	public static void main(String[] args) throws FileNotFoundException, Exception {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		//StringTokenizer st = new StringTokenizer(br.readLine());
		
		//N = Integer.parseInt(st.nextToken());
		
		//for(int test_case=1;test_case<=N;test_case++) {
			String str = br.readLine();
			int flag = -1;  // ( = 0 , ) = 1
			int sum = 0;
			for(int j=0;j<str.length();j++) {
				if(j==0) {
					sum = 10;
					if(str.charAt(j) == '(') flag = 0;
					else if(str.charAt(j) == ')') flag = 1;
				}
				else {
					if(flag==0 && str.charAt(j) == '(') sum+=5;
					else if(flag==1 && str.charAt(j)==')') sum+=5;
					else sum+=10;
					if(str.charAt(j) == '(') flag = 0;
					else if(str.charAt(j) == ')') flag = 1;
				}
				
			//}
			//System.out.println("#" + test_case + " " + sum);
		}
			System.out.println(sum);
	}

}
