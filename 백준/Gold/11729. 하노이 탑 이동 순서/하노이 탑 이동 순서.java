import java.util.Scanner;

public class Main {
	static StringBuilder sb;
	static int count = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();  // 옮길 원판의 수
		// 기둥이 3개라고 가정
		sb = new StringBuilder();
		hanoi(N,1,2,3);
		System.out.println(count);
		System.out.println(sb.toString());
	}
	
	// 옮길 원판 수, 시작기둥, 임시기둥, 목적기둥
	private static void hanoi(int n, int from, int temp, int to) {
		if(n==0) return;
		
		hanoi(n-1, from, to, temp); // 나 바로 위에 전체가 임시기둥으로 가도록 한다.
		sb.append(from).append(" ").append(to).append("\n");
		count++;
		hanoi(n-1, temp, from, to);
		
	}

}
