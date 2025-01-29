import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,M,R;
	static int[][] arr;
	static int dr[] = {1,0,-1,0};
	static int dc[] = {0,1,0,-1};
	static int nowR,nowC, nowR2, nowC2;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int k = Math.min(N, M);
		for(int i=0;i<R;i++) {  //R번 배열 돌리기
			nowR = 0;
			nowC = 0;
			nowR2 = nowR;
			nowC2 = nowC;
			for(int j=0;j<k/2;j++) {
				int temp = arr[nowR][nowC];
				for(int x=0;x<M-1-2*j;x++) {
					arr[nowR][nowC] = arr[nowR][nowC+1];
					nowC++;
				}
				
				for(int x=0;x<N-1-2*j;x++) {
					arr[nowR][nowC] = arr[nowR+1][nowC];
					nowR++;
				}
				
				for(int x=0;x<M-1-2*j;x++) {
					arr[nowR][nowC] = arr[nowR][nowC-1];
					nowC--;
				}
				
				for(int x=0;x<N-1-2*j;x++) {
					arr[nowR][nowC] = arr[nowR-1][nowC];
					nowR--;
				}
				
				arr[nowR2+1][nowC2] = temp;
				nowR = nowR2 + 1;
				nowC = nowC2 + 1;
				nowR2 = nowR;
				nowC2 = nowC;
			}
			
		}
		
		print_arr();
				

	}
	
	public static void print_arr() {
		sb = new StringBuilder();
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				sb.append(arr[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

}
