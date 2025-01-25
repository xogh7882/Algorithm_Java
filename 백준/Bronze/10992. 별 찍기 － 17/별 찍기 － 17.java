import java.util.Scanner;

public class Main {
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		
		for(int i=1;i<=N;i++) {
			for(int j=N-i; j>0 ;j--) {
				sb.append(" ");
			}
			if(i==0) sb.append("*");
			else if(i==N) {
				for(int k=1;k<=i*2-1;k++) {
					sb.append("*");
				}
			}
			else {
				for(int k = 1; k<=i*2-1;k++) {
					if(k==1 || k==i*2-1) sb.append("*");
					else sb.append(" ");
				}
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}

}
