import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,K;
	static int result = Integer.MAX_VALUE;
	static int time = 0;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		BFS(N);
		
		System.out.println(result);
	}

	private static void BFS(int start) {
		boolean visited[] = new boolean[Math.max(N, K)*2+1];
		
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {start, 0});
		int size = queue.size();
		
		while(!queue.isEmpty()) {
			if(size==0) {
				size = queue.size();
				time++;
			}
			
			int temp[]= queue.poll();
			int num = temp[0];
			int jump = temp[1];
			visited[num] = true;
			size--;
			
//			System.out.println("time : " + time +", num : " + num + ", jump : "+jump);
			
			if(num == K) {
				if(time - jump < result) {
					result = time - jump;
				}
			}
			
			if(num*2>=0 && num*2 <= K*2 && visited[num*2]==false) {
				queue.offer(new int[] {num*2, jump+1});
			}
			
			if(num+1 >= 0 && num+1 <= K && visited[num+1] == false) {
				queue.offer(new int[] {num+1, jump});
			}
			
			if(num-1>=0 && visited[num-1] == false) {
				queue.offer(new int[] {num-1, jump});
			}
		}
			
		
	}

}
