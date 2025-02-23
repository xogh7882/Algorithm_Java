import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int num[][];
	static int select[];
	static int order[];
	static boolean visited[];
	static int max = Integer.MIN_VALUE;
	
	static boolean roo[];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		num = new int[N][9];
		order = new int[]{2,3,4,5,6,7,8,9};  // 1번 선수는 무조건 4번타자
		select = new int[8];
		visited = new boolean[8];
		
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<9;j++) {
				num[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 1. perm으로 순서 정하기
		// 2. 그 상태로 점수 계산하기
		// 3. 최대로 찾기
		perm(0);
		
		System.out.println(max);
		
	}

	private static void perm(int cnt) {
		if(cnt == 8) {
			roo = new boolean[3];  // 1루,2루,3루에 사람이 있는지 체크
			calc();
			return;
		}
		for(int i=0;i<8;i++) {
			if(visited[i]) continue;
			visited[i] = true;
			select[cnt] = order[i];
			perm(cnt+1);
			select[cnt] = 0;
			visited[i] = false;
		}
	}

	private static void calc() {
		int cnt = 0;
		int realOrder[] = new int[9];
		for(int i=0;i<8;i++) {
			if(i==2) {
				realOrder[cnt++] = select[i];
				realOrder[cnt++] = 1;
			}
			else {
				realOrder[cnt++] = select[i];
			}
		}
		
//		System.out.println(Arrays.toString(realOrder));
		
		int x = 0;  // 순서
		int score = 0;

		for(int i=0;i<N;i++) {
			int out = 0;
			
			for(int p=0;p<3;p++) {
				roo[p] = false;
			}
			while(true) {
				if(num[i][realOrder[x]-1] == 0) out++;
				else if(num[i][realOrder[x]-1] == 1) {  // 안타
					int temp = 0;
					if(roo[2] == true) {
						roo[2] = false;
						temp++;
					}
					if(roo[1] == true) {
						roo[1] = false;
						roo[2] = true;
					}
					if(roo[0] == true) {
						roo[0] = false;
						roo[1] = true;
					}
					roo[0] = true;
					score+=temp;
				}
				else if(num[i][realOrder[x]-1] == 2) {  // 2루타
					int temp = 0;
					if(roo[2] == true) {
						roo[2] = false;
						temp++;
					}
					if(roo[1] == true) {
						roo[1] = false;
						temp++;
					}
					if(roo[0] == true) {
						roo[0] = false;
						roo[2] = true;
					}
					roo[1] = true;
					score+=temp;
								
				}
				else if(num[i][realOrder[x]-1] == 3) {  // 3루타
					int temp = 0;
					if(roo[2] == true) {
						roo[2] = false;
						temp++;
					}
					if(roo[1] == true) {
						roo[1] = false;
						temp++;
					}
					if(roo[0] == true) {
						roo[0] = false;
						temp++;
					}
					roo[2] = true;
					score+=temp;
				}
				else if(num[i][realOrder[x]-1] == 4) {  // 홈런
					int temp = 0;
					for(int p=0;p<3;p++) {
						if(roo[p]==true) temp++;
						roo[p] = false;
					}
					temp++;
					score+=temp;
				}

				x++;
				x=x%9;
			
				if(out == 3) break;
			}
		}
		
		if(score > max) max = score;
		return;
		
	}

}
