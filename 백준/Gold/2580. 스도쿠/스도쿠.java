import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int map[][];
	static boolean visited1[][];
	static boolean visited2[][];
	static boolean visited3[][][];
	static StringBuilder sb = new StringBuilder();
	static int flag = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		map = new int[9][9];
		visited1 = new boolean[10][10];
		visited2 = new boolean[10][10];
		visited3 = new boolean[10][10][10];
		
		for(int i=0;i<9;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<9;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				visited1[i][map[i][j]] = true;
				visited2[j][map[i][j]] = true;
				visited3[i/3][j/3][map[i][j]] = true;
			}
		}
		
		backtracking(0);
	}

	private static void backtracking(int start) {
		if(flag != 0) return;
		if(start == 81) {
			printMap();
			flag++;
			return;
		}

		int r = start / 9;
		int c = start % 9;
		
		if(map[r][c] != 0) {
			backtracking(start+1);
			return;
		}
		
		for(int k=1;k<=9;k++) {
			if(check(r,c,k) == true) {
				checkTrue(r,c,k);
				backtracking(start+1);
				checkFalse(r,c,k);
			}
		}
		
	}

	private static void checkFalse(int r, int c, int k) {
		visited1[r][k] = false;
		visited2[c][k] = false;
		visited3[r/3][c/3][k] = false;
		map[r][c] = 0;
	}

	private static void checkTrue(int r, int c, int k) {
		visited1[r][k] = true;
		visited2[c][k] = true;
		visited3[r/3][c/3][k] = true;
		map[r][c] = k;

	}

	private static boolean check(int r, int c, int k) {
		return visited1[r][k] == false && visited2[c][k] == false && visited3[r/3][c/3][k] == false;
	}

	private static void printMap() {
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				sb.append(map[i][j]);
				if(j!=8) sb.append(" ");
			}
			if(i!=8) sb.append("\n");
		}
		System.out.println(sb.toString());
	}

}
