import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static boolean map[][][];
	static int result;
	
	static int dx[] = {9,9,3,3,1,1};
	static int dy[] = {3,1,9,1,9,3};
	static int dz[] = {1,3,1,9,3,9};
	
	static int x=0,y=0,z=0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		map = new boolean[61][61][61];
		
		st = new StringTokenizer(br.readLine());
		
		if(N==1) {
			x = Integer.parseInt(st.nextToken());
		}
		else if(N==2) {
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
		}
		else {
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			z = Integer.parseInt(st.nextToken());
		}
		
		
		result = BFS();
		
		System.out.println(result);

	}

	private static int BFS() {
		int time = 0;
		
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {x,y,z});
		int size = queue.size();
		
		while(!queue.isEmpty()) {
			if(size==0) {
				time++;
				size = queue.size();
			}
			
			int temp[] = queue.poll();
			int cx = temp[0];
			int cy = temp[1];
			int cz = temp[2];
			map[cx][cy][cz] = true;
			size--;
			
			if(cx==0 && cy ==0 && cz==0) {
				return time;
			}
			
			for(int i=0;i<6;i++) {
				int nx = cx - dx[i]<=0 ? 0 : cx-dx[i];
				int ny = cy - dy[i]<=0 ? 0 : cy-dy[i];
				int nz = cz - dz[i]<=0 ? 0 : cz-dz[i];
				
				if(map[nx][ny][nz] == false) {
					map[nx][ny][nz] = true;
					queue.offer(new int[] {nx,ny,nz});
				}
				
			}
			
			
		}
		
		
		return time;
	}

}
