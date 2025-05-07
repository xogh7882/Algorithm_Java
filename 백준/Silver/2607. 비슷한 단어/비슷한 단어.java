import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int N;
	static int inputArr[], outputArr[];
	static int result = 0;
	
	static int cnt = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		String input = br.readLine();
		
		inputArr = new int[26];
		for(int i=0;i<input.length();i++) {
			inputArr[input.charAt(i)-'A']++;
		}
		
		
		for(int i=0;i<N-1;i++) {
			String output = br.readLine();
			
			outputArr = new int[26];
			for(int j=0;j<output.length();j++) {
				outputArr[output.charAt(j)-'A']++;
			}
			
			              
			int cnt = 0;
			int flag = 0;
			int flagCnt = 0;
			for(int j=0;j<26;j++) {
				if(inputArr[j] == 0 && outputArr[j] == 0) continue;
				
				else if(inputArr[j] == outputArr[j]) continue;
				
				else if(Math.abs(inputArr[j] - outputArr[j]) >= 2) {
					cnt++;
					break;
				}
				
				else if(Math.abs(inputArr[j] - outputArr[j]) == 1) {
					flag+=inputArr[j] - outputArr[j];
					flagCnt++;
				}
				
			}
			
//			System.out.println(flag);
			
			if(cnt!=0) continue;
			
			if(Math.abs(flag) <= 1 && flagCnt <=2) result++;
			
		}
		
		
		System.out.println(result);
	
	}

}

