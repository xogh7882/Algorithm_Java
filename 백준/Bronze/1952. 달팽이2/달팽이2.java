import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int arr[][];
	static int r,c;
	static int cnt = 0;
	static int count = 1;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N+2][M+2];
		
		for(int i=0;i<N+2;i++) {
			for(int j=0;j<M+2;j++) {
				arr[i][j] = -1;
			}
		}
		
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=M;j++) {
				arr[i][j] = 0;
			}
		}
		
		r = 1;
		c = 1;
		arr[r][c] = count;
		count++;
		int flag = 1;
		
		while(true) {
			//print_arr();
			//System.out.println();
			if(count > N*M) break;
			move(flag);
			flag++;
			if(flag>4) flag = 1;
			cnt++;
		}
		
		System.out.println(cnt-1);
	}
	
	private static void move(int flag) {
		if(flag == 1) {
			while(true) {
				int nc = c + 1;
				if(arr[r][nc] != 0) return;
				arr[r][nc] = count;
				count++;
				c = nc;
				
			}
		}
		else if(flag==2) {
			while(true) {
				int nr = r + 1;
				if(arr[nr][c] != 0) return;
				arr[nr][c] = count;
				count++;
				r = nr;
			}
		}
		else if(flag==3) {
			while(true) {
				int nc = c - 1;
				if(arr[r][nc] != 0) return;
				arr[r][nc] = count;
				count++;
				c = nc;
				
			}
		}
		else if(flag==4) {
			while(true) {
				int nr = r - 1;
				if(arr[nr][c] != 0) return;
				arr[nr][c] = count;
				count++;
				r = nr;
			}
		}
		
	}

	public static void print_arr() {
		for(int i=0;i<N+2;i++) {
			for(int j=0;j<M+2;j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

}
