import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static String str;
	static int result = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		str = br.readLine();
		
		for(int i=0;i<str.length();i++) {
			for(int j=i+1;j<str.length();j=j+2) {
				find(i,j);
			}
		}
		
		System.out.println(result);
		
	}
	
	
	private static void find(int left, int right) {
		int mid = (left + right) / 2;
		
		int sum1 = 0;
		int sum2 = 0;
		
		for(int i=left;i<=mid;i++) {
			sum1 += str.charAt(i) - '0';
		}
		
		for(int i=mid+1;i<=right;i++) {
			sum2 += str.charAt(i) - '0';
		}
		
//		System.out.println("---------------------------------------");
//		System.out.println(left + " : " + right);
//		System.out.println(sum1 + " : " + sum2);
		
		if(sum1 == sum2) {
			result = Math.max(result, right - left + 1);
		}
		
	}

}
