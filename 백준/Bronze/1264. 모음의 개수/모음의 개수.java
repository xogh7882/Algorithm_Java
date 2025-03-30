import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			int result = 0;
			String str = br.readLine();
			if(str.equals("#")) break;
			else {
				for(int i=0;i<str.length();i++) {
					if(str.charAt(i)=='a' || str.charAt(i)=='e' || str.charAt(i)=='i' || str.charAt(i)=='o' ||str.charAt(i)=='u'
							|| str.charAt(i)=='A' || str.charAt(i)=='E' || str.charAt(i)=='I' || str.charAt(i)=='O' ||str.charAt(i)=='U') {
						result++;
					}
				}
			}
			System.out.println(result);
		}
	}

}
