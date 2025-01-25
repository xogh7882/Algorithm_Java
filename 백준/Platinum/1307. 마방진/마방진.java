import java.util.Scanner;

public class Main {
	
	static int N;
	static int[][] magic;
	static int n;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		magic = new int[N][N];
		n = N;
		
		StringBuilder sb = new StringBuilder();
		
		if(N%2==1) oddMake(sb);
		
		else if(N%4==0) fourMake(sb);
		
		else sixMake(sb);
		
		
		System.out.println(sb.toString());
	}
	
	public static void oddMake(StringBuilder sb) {
		int r=0;
		int c=N/2;
		for(int i=1;i<n*n+1;i++) {
			magic[r][c] = i;
			int temp_r = r;
			int temp_c = c;
			
			if(r-1<0) r=n-1;
			else r--;
			
			if(c-1<0) c=n-1;
			else c--;
			
			if(magic[r][c] != 0) {
				r = temp_r;
				c = temp_c;
				if(r+1==n) r = 0;
				else r++;
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				sb.append(magic[i][j] + " ");
			}
			sb.append("\n");
		}
	}
	
	public static int[][] oddMakeBack(int[][] arr, int m){
		int[][] oddmagic = new int[m][m];
		
		int r=0;
		int c=m/2;
		for(int i=1;i<m*m+1;i++) {
			oddmagic[r][c] = i;
			int temp_r = r;
			int temp_c = c;
			
			if(r-1<0) r=m-1;
			else r--;
			
			if(c-1<0) c=m-1;
			else c--;
			
			if(oddmagic[r][c] != 0) {
				r = temp_r;
				c = temp_c;
				if(r+1==m) r = 0;
				else r++;
			}
			
		}
		
		return oddmagic;
	}
	
	public static void fourMake(StringBuilder sb) {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				magic[i][j] = i*N+j+1;
			}
		}
		
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if((i>=0 && i<N/4) || ( i>=N/4*3)) {
					if(j>=N/4 && j<N/4*3) {
						magic[i][j]=N*N-(i*N+j);
					}
				}else {
					if((j>=0 && j<N/4) || ( j>=N/4*3)) {
						magic[i][j]=N*N-(i*N+j);
					}
				}
			}
		}
		
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				sb.append(magic[i][j] + " ");
			}
			
			sb.append("\n");
		}
		
	}
	
	
	public static void sixMake(StringBuilder sb) {
		int m = n/2;
		for (int i = 0; i < m; i++) {
			for(int j=0; j < m/2; j++) {
				if(i!=m/2) magic[i][j] = 3;
				else magic[i][j+1] = 3;
			}
		}
		
		for (int i = 0; i < m; i++) {
			for(int j=0; j < m; j++) {
				magic[i][j+m]=1;
			}
		}
		for (int i = 0; i < m; i++) {
			for(int j=0; j < m-(m/2-1); j++) {
				magic[i][j+m]=2;
			}
		}
		
		for (int i = 0; i < m; i++) {
			for(int j=0; j < m; j++) {
				if(magic[i][j] == 0) magic[i+m][j] = 3;
				else magic[i+m][j] = 0;
				
				if(magic[i][j+m] == 1) magic[i+m][j+m] = 2;
				else magic[i+m][j+m] = 1;
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				magic[i][j]*=(m*m);
			}
		}
		
		int[][] oddmagic = new int[m][m];
		oddmagic = oddMakeBack(oddmagic, m);
		
		for(int i=0;i<m;i++) {
			for(int j=0;j<m;j++) {
				magic[i][j] += oddmagic[i][j];
				magic[i][j+m] += oddmagic[i][j];
				magic[i+m][j] += oddmagic[i][j];
				magic[i+m][j+m] += oddmagic[i][j];
			
			}
		}		
		
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				sb.append(magic[i][j] + " ");
			}
			
			sb.append("\n");
		}
		
		
	}
	
}