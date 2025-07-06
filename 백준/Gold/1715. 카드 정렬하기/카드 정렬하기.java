import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	static int N;
	static PriorityQueue<Integer> queue;
	static int result = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		queue = new PriorityQueue<Integer>();
		
		for(int i=0;i<N;i++) {
			queue.offer(Integer.parseInt(br.readLine()));
		}
		
		if(queue.size()==1) {
			System.out.println(0);
			System.exit(0);
		}
		
		
		while(!queue.isEmpty()) {
			int a = queue.poll();
			int b = queue.poll();
			result += (a+b);
			if(queue.isEmpty()) break;
			else queue.offer(a+b);
		}
		
		System.out.println(result);
		
	}

}
