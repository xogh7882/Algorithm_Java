import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static int arr[][];
	static int r,c;
	static int cnt = 1;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		arr = new int[N+2][N+2];
		r = (N+1)/2;
		c = (N+1)/2;
		arr[r][c] = cnt;
		cnt++;
		int m = 1;
		int repeat = 1;
		int flag = 0;
		while(true) {
			//System.out.println();
			//print_arr();
			if(cnt > N*N) break;
			move(m,repeat);
			m++;
			if(m>4)m=1;
			flag++;
			if(flag==2) {
				flag = 0;
				repeat++;
			}
			
		}
		int resultr = 0,resultc = 0;
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				sb.append(arr[i][j] + " ");
				if(arr[i][j] == M) {
					resultr = i;
					resultc = j;
				}
			}
			if(i!=N) sb.append("\n");
		}
		System.out.println(sb.toString());
		System.out.println(resultr +" "+ resultc);
	}
	
	public static void move(int m, int repeat) {
		if(m==1) {
			for(int i=0;i<repeat;i++) {
				r--;
				arr[r][c] = cnt;
				cnt++;
			}
		}
		else if(m==2) {
			for(int i=0;i<repeat;i++) {
				c++;
				arr[r][c] = cnt;
				cnt++;
			}
		}
		else if(m==3) {
			for(int i=0;i<repeat;i++) {
				r++;
				arr[r][c] = cnt;
				cnt++;
			}
		}
		else if(m==4) {
			for(int i=0;i<repeat;i++) {
				c--;
				arr[r][c] = cnt;
				cnt++;
			}
		}
	}
	
	public static void print_arr() {
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				System.out.printf("%-2d ", arr[i][j]);
			}
			System.out.println();
		}
	}

}
