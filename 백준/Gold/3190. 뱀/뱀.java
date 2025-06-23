import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main{
	static int N,K,L;
	static int map[][];
	
	static int dr[] = {0,1,0,-1};
	static int dc[] = {1,0,-1,0};
	
	static int nowR = 1;
	static int nowC = 1;
	
	static HashMap<Integer, String> time = new HashMap<Integer, String>();
	
	static Deque<int[]> location = new ArrayDeque<int[]>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		
		map = new int[N+1][N+1];
		
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b] = 9;
		}
		
		L = Integer.parseInt(br.readLine());
		
		for(int i=0;i<L;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			String b = st.nextToken();
			time.put(a, b);
		}
		
		
		map[nowR][nowC] = 1;
		location.addLast(new int[] {nowR,nowC});
		
		int sec = 0;
		int flag = 0;  // 뱀 머리 방향
		
		while(true) {
						
//			System.out.println("sec : " + sec);
//			printmap();
			
			
			if(time.containsKey(sec) == true) {
				String ch = time.get(sec);
				if(ch.equals("L")) flag--;
				else flag++;
				flag = (flag + 4) % 4;
			}
			
			nowR += dr[flag];
			nowC += dc[flag];
			
			if(check(nowR, nowC) == false) break;
			
			if(map[nowR][nowC] == 9) {
				map[nowR][nowC] = 1;
				location.addLast(new int[] {nowR,nowC});
			}
			else {
				map[nowR][nowC] = 1;
				location.addLast(new int[] {nowR,nowC});
				int[] tail = location.pollFirst();
				map[tail[0]][tail[1]] = 0;
			}
			
			sec++;
		}
		
		System.out.println(sec+1);

	}

	private static boolean check(int r, int c) {
		return (r>=1 && r<=N && c>=1 && c<=N) && (map[r][c] != 1);
	}

	
	private static void printmap() {
		System.out.println();
		System.out.println("---------Print Map----------");
		
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println();
	}

}
