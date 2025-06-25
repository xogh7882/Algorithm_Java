import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int map[][];
	static int count[];
	static int result = Integer.MAX_VALUE;
	static int rest = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		map = new int[10][10];
		
		for(int i=0;i<10;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<10;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) rest++;
			}
		}
		
		count = new int[6];
		for(int i=1;i<=5;i++) {
			count[i] = 5;
		}

		check(0,0,rest,0);
		
		if(result == Integer.MAX_VALUE) result = -1;
		System.out.println(result);

	}
	
	
	
	private static void check(int r, int c, int cnt, int page) {
		if(cnt==0) {
			result = Math.min(result, page);
			return;
		}
		
		for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++) {
				if(map[i][j] == 1) {
					for(int k=5;k>=1;k--) {
						if(isPaste(i, j, k) == true && count[k] > 0) {
							paste(i,j,k);
							check(i,j,cnt-(k*k), page+1);
							unPaste(i,j,k);
						}
					}
					return;
				}
			}
		}
		
	}


	private static void unPaste(int r, int c, int cnt) {
		count[cnt]++;
		for(int i=r;i<r+cnt;i++) {
			for(int j=c;j<c+cnt;j++) {
				map[i][j] = 1; 
			}
		}
		
	}

	private static void paste(int r, int c, int cnt) {
		count[cnt]--;
		for(int i=r;i<r+cnt;i++) {
			for(int j=c;j<c+cnt;j++) {
				map[i][j] = 2; 
			}
		}
		
	}



	private static boolean isPaste(int r, int c, int cnt) {
		for(int i=r;i<r+cnt;i++) {
			for(int j=c;j<c+cnt;j++) {
				if(i>=10 || j>=10) return false;
				if(map[i][j] != 1) return false;
			}
		}
		
		return true;
	}

}
