import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		PriorityQueue<Integer> queue = new PriorityQueue<>((o1,o2)->Integer.compare(o2, o1));
		
		N = Integer.parseInt(br.readLine());
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				queue.offer(Integer.parseInt(st.nextToken()));
			}
		}
		
		for(int i=0;i<N-1;i++) {
			queue.poll();
		}
		
		int result = queue.poll();
		System.out.println(result);
	}

}
