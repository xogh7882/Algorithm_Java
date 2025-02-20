import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int map[][];
	static int summap[][];
	static int x1,y1,x2,y2;
	static int result;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
//		printMap();
		
		summap = new int[N+1][N+1];
		for(int i=1;i<=N;i++) {
			int x = 0;
			for(int j=1;j<=N;j++) {
				x+=map[i-1][j-1];
				summap[i][j] = x + summap[i-1][j];
			}
		}
		
//		printSummap();
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			
			result = find(x1,y1,x2,y2);
			System.out.println(result);
		}
		
	}
	
	private static int find(int x1, int y1, int x2, int y2) {
		int sum = 0;
		
		sum += summap[x2][y2];
		sum -= summap[x2][y1-1];
		sum -= summap[x1-1][y2];
		sum += summap[x1-1][y1-1];
		
		return sum;
	}

	private static void printMap() {
		System.out.println("----------------------------------");
		for(int i=0;i<N;i++) {
			System.out.println(Arrays.toString(map[i]));
		}
	}


	private static void printSummap() {
		System.out.println("----------------------------------");
		for(int i=0;i<N+1;i++) {
			System.out.println(Arrays.toString(summap[i]));
		}
		
	}

}
