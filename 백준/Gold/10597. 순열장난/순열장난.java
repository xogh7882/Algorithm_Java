import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static String str;
	static int[] perm;
	static int N;
	static boolean[] visited;
	static int cnt = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		str = br.readLine();
		if(str.length() < 10) N = str.length();
		else N = 9 + ((str.length()-9) / 2);
		
		perm = new int[N];
		visited = new boolean[N+1];
		findPerm(0,0);
		print();
	}
	
	// 한자리 수를 먼저 담고
	// 한자리 수가 이미 담은 수라면
	// 두자리 수로 바꿔서 담아본다
	// 끝에 도달하면 전부다 탈출하도록 boolean 함수로
	
	private static boolean findPerm(int cnt, int idx) {
		if(cnt==N) {
			return true;
		}
		
		if(idx >= str.length()) return false;
		
		int num = str.charAt(idx)-'0';
		if(0 < num && num <= N && visited[num] == false) {
			visited[num] = true;
			perm[cnt] = num;
			if(findPerm(cnt+1, idx+1) == true) return true;
			visited[num] = false;
		}
		
		if(idx+1 < str.length()) {
			num = Integer.parseInt(str.substring(idx, idx+2));
			if(0 < num && num<=N && visited[num]==false) {
				visited[num] = true;
				perm[cnt] = num;
				if(findPerm(cnt+1, idx+2) == true) return true;
				visited[num] = false;
			}
		}
		
		return false;
	}


	private static void print() {
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<perm.length;i++) {
			sb.append(perm[i]).append(" ");
		}
		System.out.println(sb.toString());
	}

}

//123456789 : 9자리
//12345678910 : 11자리 ( 11 - 9 = 2  / 2 = 1 ) N = 10
//1234567891011 : 13자리 ( 13 - 9 = 4 / 2  = 2) N = 11
//123.....101112 : 15자리 ( 15 - 9 = 6 / 2 = 3) N =12