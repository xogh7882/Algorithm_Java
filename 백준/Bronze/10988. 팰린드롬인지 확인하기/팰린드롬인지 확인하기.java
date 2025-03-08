import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		int start = 0;
		int end = str.length()-1;
		int result = 0;
		while(true) {
			if(start >= end) {
				result = 1;
				break;
			}
			if(str.charAt(start) == str.charAt(end)) {
				start++;
				end--;
			}
			else {
				break;
			}
		}
		
		System.out.println(result);
	}

}
