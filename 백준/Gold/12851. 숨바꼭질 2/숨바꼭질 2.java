import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,K;
	static int result = Integer.MAX_VALUE;
	static int time = 0;
	static int count = 0;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		BFS(N);
		
		System.out.println(result);
		System.out.println(count);
		
	}

	private static void BFS(int start) {
		boolean visited[] = new boolean[Math.max(N, K)*2+1];
		
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(start);
		int size = queue.size();
		
		while(!queue.isEmpty()) {
			if(size==0) {
				size = queue.size();
				time++;
			}
			
			int num= queue.poll();
			visited[num] = true;
			size--;
			
			if(num == K) {
				if(time < result) {
					result = time;
					count = 1;
				}
				else if(time == result) {
					count++;
				}
			}
			
			if(num*2>=0 && num*2 <= K*2 && visited[num*2]==false) {
				queue.offer(num*2);
			}
			
			if(num+1 >= 0 && num+1 <= K && visited[num+1] == false) {
				queue.offer(num+1);
			}
			
			if(num-1>=0 && visited[num-1] == false) {
				queue.offer(num-1);
			}
		}
			
		
	}

}
