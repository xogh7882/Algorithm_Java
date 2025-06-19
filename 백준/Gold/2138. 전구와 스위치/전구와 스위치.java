import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int N;
	static boolean before1[];
	static boolean before2[];
	static boolean after[];
	static int result = Integer.MAX_VALUE;
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		before1 = new boolean[N];
		before2 = new boolean[N];
		after = new boolean[N];
		
		String str = br.readLine();
		for(int i=0;i<N;i++) {
			char ch = str.charAt(i);
			if(ch=='0') before1[i] = false;
			else before1[i] = true;
		}
		
		before2 = before1.clone();
		
		str = br.readLine();
		for(int i=0;i<N;i++) {
			char ch = str.charAt(i);
			if(ch=='0') after[i] = false;
			else after[i] = true;
		}
		
		// 입력까지 3N..?
		// 입력 + 처음 누르기 + 처음 안누르기
		int cnt1 = 0;
		
		for(int i=0;i<N;i++) {
			if(i==0) {
				change(before1, i);
				cnt1++;
				continue;
				
			}
			else {
				if(before1[i-1] == after[i-1]) continue;
				else {
					cnt1++;
					change(before1, i);
				}
				
			}
		}
		
		int cnt2 = 0;
				
		for(int i=0;i<N;i++) {
			if(i==0) {
				continue;
			}
			else {
				if(before2[i-1] == after[i-1]) continue;
				else {
					cnt2++;
					change(before2, i);
				}
				
			}
		}
		
		int count1 = 0, count2 = 0;
		for(int i=0;i<N;i++) {
			if(before1[i] == after[i]) count1++;
			if(before2[i] == after[i]) count2++;
		}
		if(count1 == N) result = Math.min(result, cnt1);
		if(count2 == N) result = Math.min(result, cnt2);
		if(result == Integer.MAX_VALUE) result = -1;
		
		System.out.println(result);
	}


	private static void change(boolean[] now, int idx) {
		for(int i=idx-1;i<=idx+1;i++) {
			if(i<0 || i>=N) continue;
			if(now[i] == true) now[i] = false;
			else now[i] = true;
		}
	}



	


}
