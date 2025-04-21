import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static char arr[][];
	static int K;
	static boolean visited[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		arr = new char[4][8];
		
		for(int i=0;i<4;i++) {
			String str = br.readLine();
			for(int j=0;j<8;j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		
		
		K = Integer.parseInt(br.readLine());
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int flag = Integer.parseInt(st.nextToken());
			
			visited = new boolean[4];
			
			rotate(num-1, flag);
//			printMap();
		}
		
		int result = calc();
		
		System.out.println(result);
		
	}
	
	
	private static int calc() {
		int sum = 0;
		if(arr[0][0] == '1') sum += 1;
		if(arr[1][0] == '1') sum += 2;
		if(arr[2][0] == '1') sum += 4;
		if(arr[3][0] == '1') sum += 8;
		return sum;
	}


	private static void rotate(int num, int flag) {
		visited[num] = true;
		if(num-1 >=0 && visited[num-1] == false) {
			if(arr[num][6] != arr[num-1][2]) {
				rotate(num-1, flag*(-1));
			}
			
		}
		if(num+1<4 && visited[num+1] == false) {
			if(arr[num][2] != arr[num+1][6]) {
				rotate(num+1, flag*(-1));
			}
		}
		
		
		if(flag==1) {
			time(num);
		}
		else if(flag==-1) {
			retime(num);
		}
		
		
	}
	
	
	private static void retime(int num) {
		char temp = arr[num][0];
		for(int i=0;i<7;i++) {
			arr[num][i] = arr[num][i+1];
		}
		arr[num][7] = temp;
	}


	private static void time(int num) {
		char temp = arr[num][7];
		for(int i=7;i>0;i--) {
			arr[num][i] = arr[num][i-1];
		}
		arr[num][0] = temp;
		
	}


	private static void printMap() {
		System.out.println("=============Print Map=============");
		for(int i=0;i<4;i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
		System.out.println();
	}

}
