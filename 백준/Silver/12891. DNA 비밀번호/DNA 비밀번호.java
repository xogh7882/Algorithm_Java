import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int S,P;
	static char[] crr;
	static char[] select;
	static boolean[] visited;
	static int[] limit;
	static int[] num;
	static int count = 0;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		
		crr = new char[S];
		select = new char[P];
		visited = new boolean[P];
		
		limit = new int[4];
		num = new int[4];
		
		String str = br.readLine();
		for(int i=0;i<S;i++) {
			crr[i] = str.charAt(i);
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<4;i++) {
			limit[i] = Integer.parseInt(st.nextToken());
		}
		
		int x = 0;
		int y = P-1;
		for(int i=0;i<P;i++) {
			if(crr[i] == 'A') num[0]++;
			else if(crr[i] == 'C') num[1]++;
			else if(crr[i] == 'G') num[2]++;
			else if(crr[i] == 'T') num[3]++;
		}
		if(check()==true) count++;
		
		while(true) {
			if(y+1==S) break;  // S,P 가 같을 경우 바로 범위 벗어나버림
			
			if(crr[x] == 'A') num[0]--;
			else if(crr[x] == 'C') num[1]--;
			else if(crr[x] == 'G') num[2]--;
			else if(crr[x] == 'T') num[3]--;
			x++;
			
			y++;
			if(crr[y] == 'A') num[0]++;
			else if(crr[y] == 'C') num[1]++;
			else if(crr[y] == 'G') num[2]++;
			else if(crr[y] == 'T') num[3]++;
			
			//System.out.println(Arrays.toString(num));
			
			if(check()==true) count++;
			
		}
		
		System.out.println(count);
	}

	private static boolean check() {
		for(int i=0;i<4;i++) {
			if(limit[i] > num[i]) return false;
		}
		return true;
	}



}
