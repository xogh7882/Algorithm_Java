import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		int map[] = new int[26];
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		for(int i=0;i<str.length();i++) {
			char ch = str.charAt(i);
			map[ch-'a']++;
		}
		
		for(int i=0;i<26;i++) {
			System.out.print(map[i] + " ");
		}
	}
	

}
