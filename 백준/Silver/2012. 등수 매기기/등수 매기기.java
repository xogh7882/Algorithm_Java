import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{

	static int N;
	static int rank[];
	static PriorityQueue<Integer> queue;
	static long result = 0;
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		rank = new int[N+1];
		
		queue = new PriorityQueue<>();
		
		for(int i=1;i<=N;i++) {
			int t = Integer.parseInt(br.readLine());
			if(t > N) queue.offer(t);
			else if(rank[t] == 0) rank[t] = i;
			else {
				queue.offer(t);
			}
		}
		
		int k = 0;
		
		for(int i=1;i<=N;i++) {
			if(rank[i] == 0) {
				k = queue.poll();
				result+=Math.abs(i-k);
			}
		}
		
		System.out.println(result);
	}

}
