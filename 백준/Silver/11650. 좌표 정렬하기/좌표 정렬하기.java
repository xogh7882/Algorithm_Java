import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
	static int N;
	static int x,y;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());

		PriorityQueue<int[]> queue = new PriorityQueue<>((o1,o2) -> o1[0] == o2[0] ? Integer.compare(o1[1], o2[1]) : Integer.compare(o1[0], o2[0]));
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			queue.offer(new int[] {x,y});
		}
		
		StringBuilder sb = new StringBuilder();
		while(!queue.isEmpty()) {
			int temp[] = queue.poll();
			sb.append(temp[0]).append(" ").append(temp[1]).append("\n");
		}
		System.out.println(sb.toString());
	}

}
