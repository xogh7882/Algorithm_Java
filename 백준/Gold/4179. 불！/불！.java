import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int R,C;
	static int map[][];
	static Queue<int[]> queue;
	static int result = 0;
	static int dr[] = {0,0,-1,1};
	static int dc[] = {1,-1,0,0};
	static boolean visited[][];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		queue = new ArrayDeque<>();
		visited = new boolean[R][C];
		
		int startR = -1;
		int startC = -1;
		
		for(int i=0;i<R;i++) {
			String str = br.readLine();
			for(int j=0;j<C;j++) {
				char ch = str.charAt(j);
				if(ch=='#') {
					map[i][j] = -1;
				}
				else if(ch=='.') map[i][j] = 0;
				else if(ch=='J') {
					map[i][j] = 1;
					startR = i;
					startC = j;
				}
				else if(ch=='F') {
					map[i][j] = -2;
					queue.offer(new int[] {2,i,j});;
				}
			}
		}
		queue.offer(new int[] {1,startR,startC});
		result = BFS();
		
		if(result == -1) System.out.println("IMPOSSIBLE");
		else System.out.println(result);

	}
	private static int BFS() {
		int size = queue.size();
		int time = 1;
		
		while(!queue.isEmpty()) {
			if(size==0) {
				size = queue.size();
				time++;
			}
			
			int temp[] = queue.poll();
			int flag = temp[0];
			int r = temp[1];
			int c = temp[2];
			size--;
			for(int i=0;i<4;i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if(flag==1) {  //사람
					if(check(nr,nc)==false) return time;
					if(check(nr,nc)==true && map[nr][nc] == 0 && visited[nr][nc] == false) {
						queue.offer(new int[] {1,nr,nc});
						visited[nr][nc] = true;
					}
				}
				else if(flag==2) { //불
					if(check(nr,nc)==true && map[nr][nc] != -1 && map[nr][nc] != -2) {
						map[nr][nc] = -2;
						queue.offer(new int[] {2,nr,nc});
					}
				}
			}
		}
		
		return -1;
	}
	private static boolean check(int r, int c) {
		return r>=0 && r<R && c>=0 && c<C;
	}

}
