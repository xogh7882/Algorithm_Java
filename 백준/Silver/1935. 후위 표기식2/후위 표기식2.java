import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static double[] num;
	static String str;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		str = br.readLine();
		num = new double[N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		double k = calc();
		
		System.out.printf("%.2f",k);
		
	}

	private static double calc() {
		Stack<Double> stack = new Stack<>();
		for(int i=0;i<str.length();i++) {
//			System.out.println(i + "번째 : " + str.charAt(i));
			if(str.charAt(i) == '+') {
				double temp1 = stack.pop();
				double temp2 = stack.pop();
				stack.push(temp2 + temp1);
			}
			else if(str.charAt(i) == '-') {
				double temp1 = stack.pop();
				double temp2 = stack.pop();
				stack.push(temp2 - temp1);			
			}
			else if(str.charAt(i) == '*') {
				double temp1 = stack.pop();
				double temp2 = stack.pop();
				stack.push(temp2 * temp1);
			}
			else if(str.charAt(i) == '/') {
				double temp1 = stack.pop();
				double temp2 = stack.pop();
				stack.push(temp2 / temp1);
			}
			else {
				stack.push(num[str.charAt(i)-'A']);
			}
		}
		
		return stack.pop();
	}

}
