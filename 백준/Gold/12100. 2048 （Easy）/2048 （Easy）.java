import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int map[][];
	static int copymap[][];
	static int p[];
	static int result = -1;
	static BufferedReader br;
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		copymap = new int[N][N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				copymap[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		map = new int[N][N];
		
		// 1. 2048 순서 뽑기
		p = new int[5];
		findorder(0);
		
		System.out.println(result);
	}


	

	private static void findorder(int cnt) throws IOException {
		if(cnt==5) {
			for(int i=0;i<N;i++) {
				map[i] = copymap[i].clone();
			}
			calc();
			return;
		}
		
		for(int i=1;i<=4;i++) {
			p[cnt] = i;
			findorder(cnt+1);
			p[cnt] = 0;
		}
	}
	
	
	

	private static void calc() throws IOException {
		// 디버깅 출력
//		System.out.println(Arrays.toString(p));

		for(int i=0;i<5;i++) {
			move(p[i]);
			
//			 디버깅 출력문
//			String str = br.readLine();
//			printMap();
		}
		result = Math.max(result, maxValue());
		return;
	}



	private static void move(int dir) {
		if(dir == 1) {   // 왼쪽
			
			for(int i=0;i<N;i++) {
				for(int j=1;j<N;j++) {
					int t = j;
					while(true) {
						if(t==0 || map[i][t-1] != 0) break;
						map[i][t-1] = map[i][t];
						map[i][t] = 0;
						t--;
					}
				}
			}
			
			
			for(int i=0;i<N;i++) {
				int j = 1;
				while(true) {
					if(j >= N) break;
					if(map[i][j-1] == map[i][j]) {
						map[i][j-1] += map[i][j];
						map[i][j] = 0;
					}
					j++;
				}
			}
			
			for(int i=0;i<N;i++) {
				for(int j=1;j<N;j++) {
					int t = j;
					while(true) {
						if(t==0 || map[i][t-1] != 0) break;
						map[i][t-1] = map[i][t];
						map[i][t] = 0;
						t--;
					}
				}
			}
			
		}
		
		else if(dir==2) {   // 오른쪽
			
			for(int i=0;i<N;i++) {
				for(int j=N-1-1;j>=0;j--) {
					int t = j;
					while(true) {
						if(t+1==N || map[i][t+1] != 0) break;
						map[i][t+1] = map[i][t];
						map[i][t] = 0;
						t++;
					}
				}
			}
			
			
			for(int i=0;i<N;i++) {
				int j=N-1-1;
				while(true) {
					if(j < 0) break;
					if(map[i][j+1] == map[i][j]) {
						map[i][j+1] += map[i][j];
						map[i][j] = 0;
					}
					j--;
				}
				
				
			}
			
			for(int i=0;i<N;i++) {
				for(int j=N-1-1;j>=0;j--) {
					int t = j;
					while(true) {
						if(t+1==N || map[i][t+1] != 0) break;
						map[i][t+1] = map[i][t];
						map[i][t] = 0;
						t++;
					}
				}
			}
			
		}
		
		
		
		else if(dir==3) { // 위쪽
			
			for(int j=0;j<N;j++) {
				for(int i=1;i<N;i++) {
					int t = i;
					while(true) {
						if(t==0 || map[t-1][j] != 0) break;
						map[t-1][j] = map[t][j];
						map[t][j] = 0;
						t--;
					}
				}
			}
			
			
			for(int j=0;j<N;j++) {
				int i = 1;
				while(true) {
					if(i >= N) break;
					if(map[i-1][j] == map[i][j]) {
						map[i-1][j] += map[i][j];
						map[i][j] = 0;
					}
					i++;
				}
			}
			
			for(int j=0;j<N;j++) {
				for(int i=1;i<N;i++) {
					int t = i;
					while(true) {
						if(t==0 || map[t-1][j] != 0) break;
						map[t-1][j] = map[t][j];
						map[t][j] = 0;
						t--;
					}
				}
			}
			
		}
		else if(dir==4) {  
			
			for(int j=0;j<N;j++) {
				for(int i=N-1-1;i>=0;i--) {
					int t = i;
					while(true) {
						if(t+1==N || map[t+1][j] != 0) break;
						map[t+1][j] = map[t][j];
						map[t][j] = 0;
						t++;
					}
				}
			}
			
			
			for(int j=0;j<N;j++) {
				int i=N-1-1;
				while(true) {
					if(i < 0) break;
					if(map[i+1][j] == map[i][j]) {
						map[i+1][j] += map[i][j];
						map[i][j] = 0;
					}
					i--;
				}
			}
			
			
			for(int j=0;j<N;j++) {
				for(int i=N-1-1;i>=0;i--) {
					int t = i;
					while(true) {
						if(t+1==N || map[t+1][j] != 0) break;
						map[t+1][j] = map[t][j];
						map[t][j] = 0;
						t++;
					}
				}
			}
			
		}
		
		
		return;
	}

	
	private static int maxValue() {
		int max = -1;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				max = Math.max(max, map[i][j]);
			}
		}
		return max;
	}
	
	

	private static void printMap() {
		System.out.println("==========PrintMap===========");
		for(int i=0;i<N;i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		System.out.println();
		System.out.println("-------------------------------");
	}

}
