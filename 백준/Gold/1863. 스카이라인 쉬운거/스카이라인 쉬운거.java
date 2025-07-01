import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int result = 0;
	static Stack<Integer> stack;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		stack = new Stack<>();
		
		stack.push(0);
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
//			System.out.println("=======================");
//			System.out.println("size : " + stack.size());
//			if(!stack.isEmpty()) System.out.println("peek : " + stack.peek());
			
			while(true) {
				if(stack.isEmpty()) break;
				
				if(stack.peek() < b) {
					stack.push(b);
					break;
				}
				else if(stack.peek() == b) {
					break;
				}
				else {
					stack.pop();
					result++;
				}
				
			}
				
		}
		
		while(!stack.isEmpty()) {			
			stack.pop();
			result++;
		}
		
		System.out.println(result-1);
	}

}
