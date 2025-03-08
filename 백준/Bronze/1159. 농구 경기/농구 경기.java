import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static int num[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		num = new int[26];
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			num[str.charAt(0)-'a']++;
		}
		int result = 0;
		String str = "";
		for(int i=0;i<num.length;i++) {
			if(num[i] >= 5) {
				result++;
				str+=(char)('a'+i);
			}
		}
		if(result == 0) System.out.println("PREDAJA");
		else {
			System.out.println(str);
		}
	}

}
