import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int result = 0;
	static boolean column[];
	static boolean slash[];
	static boolean bslash[];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		column = new boolean[N+1];  // 1부터 N까지
		slash = new boolean[2*N+1]; // i+j
		bslash = new boolean[2*N];  // (i-j)+N
		
		queen(1);
		
		System.out.println(result);
	}

	private static void queen(int row) {
		if(row > N) {
			result++;
			return;
		}
		for(int c=1;c<=N;c++) {
			if(!check(row, c)) continue;  // 세로, 대각, 반대대각 3개 모두 놓을 수 있니?
			column[c] = slash[row+c] = bslash[row-c+N] = true;
			queen(row+1);
			column[c] = slash[row+c] = bslash[row-c+N] = false;
		}
		
	}

	private static boolean check(int row, int c) {
		return column[c] == false && slash[row+c]==false && bslash[row-c+N]==false;
	}

}
