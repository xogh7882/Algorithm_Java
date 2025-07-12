import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main{
	static int N, M;
	static PriorityQueue<Integer> queue;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		
		queue = new PriorityQueue<>((o1,o2) -> 
		(Math.abs(o1) == Math.abs(o2) ? Integer.compare(o1,o2) 
				: Integer.compare(Math.abs(o1), Math.abs(o2))));
		
		for(int i=0;i<N;i++) {
			M = Integer.parseInt(br.readLine());
			if(M==0) {
				if(queue.isEmpty()) sb.append(0).append("\n");
				else {
					sb.append(queue.poll()).append("\n");
				}
			}
			else queue.offer(M);
			
		}
		
		System.out.println(sb.toString());

	}

}
