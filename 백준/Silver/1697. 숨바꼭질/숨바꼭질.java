import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,K;
	static int result = -1;
	static boolean visited[];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		// 걸으면 x-1 or x+1
		// 순간이동하면 2*x
		// 가장 빠르게 찾기
		
		visited = new boolean[Math.max(N, K) * 2 + 1];
		
		result = BFS(N);
		
		System.out.println(result);
	}

	private static int BFS(int start) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(start);
		int time = 0;
		int size = queue.size();
		
		while(!queue.isEmpty()) {
			if(size==0) {
				size = queue.size();
				time++;
			}
			int x = queue.poll();
			visited[x] = true;
			size--;
			
			if(x==K) return time;
			
			if(x*2>=0 && x*2 <= K*2 && visited[x*2]==false) {
				queue.offer(x*2);
				visited[x*2] = true;
			}
			if(x+1>=0 && x+1 <= K && visited[x+1] == false) {
				queue.offer(x+1);
				visited[x+1] = true;
			}
			if(x-1>=0 && visited[x-1] == false) {
				queue.offer(x-1);
				visited[x-1] = false;
			}
			
		}
		
		
		return -1;
		
	}

}
