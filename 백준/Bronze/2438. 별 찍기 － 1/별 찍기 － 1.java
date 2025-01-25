import java.util.Scanner;

public class Main {
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++) {
			for(int j=0;j<=i;j++) {
				sb.append("*");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());

	}

}
