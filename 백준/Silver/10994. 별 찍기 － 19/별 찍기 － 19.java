import java.util.Scanner;

public class Main {
	static int N;
	static int[][] arr;
	static StringBuilder sb;

	public static void main(String[] args) {
		sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		arr = new int[1+4*(N-1)][1+4*(N-1)];
		
		star(0,N);
		
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr.length;j++) {
				if(arr[i][j] == 1) sb.append("*");
				else sb.append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void star(int start, int cnt) {
		if(cnt <= 0) return;
		
		for(int i=start;i<start+1+4*(cnt-1);i++) {
			for(int j=start;j<start+1+4*(cnt-1);j++) {
				if(i==start || i==start+4*(cnt-1)) {
					arr[i][j] = 1;
				}
				if(j==start || j==start+4*(cnt-1)) {
					arr[i][j] = 1;
				}
			}
		}
		//print_arr();
		star(start+2, cnt-1);
		
	}
	
	public static void print_arr() {
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr.length;j++) {
				if(arr[i][j] == 1) System.out.print("*");
				else System.out.print(" ");
			}
			System.out.println();
		}
	}

}
