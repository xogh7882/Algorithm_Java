import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
	static String str;
	static int result = 0;
	static int arr[];
	static HashSet<String> set = new HashSet<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		str = br.readLine();
		
		for(int i=0;i<str.length();i++) {
			make(""+str.charAt(i), i, i, ""+str.charAt(i));
		}
		
		System.out.println(set.size());
		
	}
	
	private static void make(String now, int left, int right, String path) {
//		System.out.println("----------------------------------");
//		System.out.println(now);
//		System.out.println(path);
		
		if(now.equals(str)) {
			set.add(path);
			return;
		}
		
		if(left > 0) {
			make(str.charAt(left-1) + now , left-1, right, path + " -> " + str.charAt(left-1) + now);
		}
		
		if(right < str.length()-1) {
			make(now + str.charAt(right + 1) , left, right + 1, path + " -> " + now + str.charAt(right + 1));
		}
	}
	

}
