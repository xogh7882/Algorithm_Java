import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	static int N,M;
	static String list[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new String[M-N+1];
		
		int cnt = 0;
		
		for(int i=N;i<=M;i++) {
			if(i<10) {
				list[cnt] = change(i);
			}
			else {
				String str = "";
				int a = i/10;
				int b = i%10;
				
				str = change(a);
				str += " ";
				str += change(b);
				list[cnt] = str;
			}
			cnt++;
		}
		
		Arrays.sort(list);
		StringBuilder sb = new StringBuilder();
		int now = -1;
		
		for(int i=0;i<list.length;i++) {
			if(i!=0 && i%10==0) sb.append("\n"); 
			
			String[] result = list[i].split(" ");
			if(result.length==2) {
				now = changeNumber(result[0]) * 10 + changeNumber(result[1]);
			}
			else {
				now = changeNumber(result[0]);
			}
			sb.append(now);
			if(i%10!=9) sb.append(" ");
			
		}
		
		System.out.println(sb.toString());
		
	}
	
	private static String change(int i) {
		String result= "";
		if(i==1) {
			result = "one";
		}else if(i==2) {
			result = "two";
		}else if(i==3) {
			result = "three";
		}else if(i==4) {
			result = "four";
		}else if(i==5) {
			result = "five";
		}else if(i==6) {
			result = "six";
		}else if(i==7) {
			result = "seven";
		}else if(i==8) {
			result = "eight";
		}else if(i==9) {
			result = "nine";
		}else if(i==0) {
			result = "zero";
		}
		
		return result;
	}

	
	private static int changeNumber(String word) {
		int result = -1;
		if(word.equals("one")) {
			result = 1;
		}else if(word.equals("two")) {
			result = 2;
		}else if(word.equals("three")) {
			result = 3;
		}else if(word.equals("four")) {
			result = 4;
		}else if(word.equals("five")) {
			result = 5;
		}else if(word.equals("six")) {
			result = 6;
		}else if(word.equals("seven")) {
			result = 7;
		}else if(word.equals("eight")) {
			result = 8;
		}else if(word.equals("nine")) {
			result = 9;
		}else if(word.equals("zero")) {
			result = 0;
		}
		return result;
	}
}
