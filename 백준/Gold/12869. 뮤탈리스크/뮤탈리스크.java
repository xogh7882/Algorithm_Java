import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int result;
	static int visited[][][];
	static int dx[] = {1,1,3,3,9,9};
	static int dy[] = {3,9,1,9,1,3};
	static int dz[] = {9,3,9,1,3,1};
	List<int[]> list;
	static int maxvalue = -1;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int temp[] = new int[N];
		for(int i=0;i<N;i++) {
			temp[i] = Integer.parseInt(st.nextToken());
			maxvalue = Math.max(maxvalue, temp[i]);
		}
		

		if(N==1) {
			result = 0;
			while(true) {
				if(temp[0] <= 0) break;
				temp[0] -= 9;
				result++;
			}
			
		}else if(N==2) {
			result = 0;
			while(true) {
				if(temp[0] <=0 && temp[1] <=0) break;
				if(temp[0] > temp[1]) {
					temp[0] -= 9;
					temp[1] -= 3;
				}
				else {
					temp[0] -= 3;
					temp[1] -= 9;
				}
				result++;
			}
			
		}else if(N==3) {
			visited = new int[maxvalue+1][maxvalue+1][maxvalue+1];
			result = BFS(temp[0],temp[1],temp[2]);
		}
		
		
		System.out.println(result);
	}

	private static int BFS(int x, int y, int z) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {x,y,z});
		int size = queue.size();
		int time = 0;
		
		while(!queue.isEmpty()) {
			if(size==0) {
				size = queue.size();
				time++;
			}
			int temp[] = queue.poll();
			size--;
			int cx = temp[0];
			int cy = temp[1];
			int cz = temp[2];
			
			if(cx==0 && cy ==0 && cz ==0) return time;
			
			for(int i=0;i<6;i++) {
				int nx = (cx - dx[i]<0 ? 0 : cx-dx[i]);
				int ny = (cy - dy[i]<0 ? 0 : cy-dy[i]);
				int nz = (cz - dz[i]<0 ? 0 : cz-dz[i]);
				
				if(checkvisited(nx,ny,nz) == 0) {
					addvisited(nx,ny,nz,time);
					queue.offer(new int[] {nx,ny,nz});
				}
				else {
					addvisited(nx,ny,nz,checkvisited(nx,ny,nz));
				}
				
			}
			
		}
		
		
		return -1;
	}

	private static void addvisited(int cx, int cy, int cz, int time) {
		visited[cx][cy][cz] = time;
		visited[cx][cz][cy] = time;
		visited[cy][cx][cz] = time;
		visited[cy][cz][cx] = time;
		visited[cz][cx][cy] = time;
		visited[cz][cy][cx] = time;
		
	}

	private static int checkvisited(int cx, int cy, int cz) {
		int result = 0;
		result = Math.max(result, visited[cx][cy][cz]);
		result = Math.max(result, visited[cx][cz][cy]);
		result = Math.max(result, visited[cy][cx][cz]);
		result = Math.max(result, visited[cy][cz][cx]);
		result = Math.max(result, visited[cz][cx][cy]);
		result = Math.max(result, visited[cz][cy][cx]);
		return result;
	}

}
