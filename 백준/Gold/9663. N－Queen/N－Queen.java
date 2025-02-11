import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int N;
	static int count = 0;
	static int[][] map;
	static boolean[] visited;
	static int[] q;
	
	// 대각선만 체크하면 되는데
	// 행 열 끼리 빼면 값이 똑같네
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		q = new int[N];
		visited = new boolean[N];
		
		queen(0);
		System.out.println(count);
	}

	private static void queen(int cnt) {
		if(cnt == N) {
			count++;
			return;
		}
		
		for(int i=0;i<N;i++) {
			if(visited[i] == false && checkqueen(cnt,i)) {  // 지금까지 들어온 queen 이랑 비교
				visited[i] = true;
				q[cnt] = i;
				queen(cnt+1);
				q[cnt] = 0;
				visited[i] = false;
			}
		}
		
	}

	private static boolean checkqueen(int cnt, int i) {  // 새로 들어오는 queen 이랑 안만나면 true
		if(cnt==0) return true;
		
		int r1 = cnt;
		int c1 = i;
		
		for(int x=0;x<cnt;x++) {
			int r2 = x;
			int c2 = q[x];
			
			if(Math.abs(r1-r2) == Math.abs(c1-c2)) return false;
			else continue;
		}
		
		return true;
	}

}
