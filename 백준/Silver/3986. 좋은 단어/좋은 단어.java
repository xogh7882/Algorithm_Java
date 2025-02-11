import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int count = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			good(str);
		}
		System.out.println(count);
	}
	
	
	private static void good(String str) {
		Stack<Character> stack = new Stack<>();
		for(int i=0;i<str.length();i++) {
			if(stack.isEmpty()) stack.push(str.charAt(i));
			else {
				if(stack.peek().equals(str.charAt(i))) {
					stack.pop();
				}
				else stack.push(str.charAt(i));
			}
		}
		if(stack.isEmpty()) count++;
		return;
		
	}

}
