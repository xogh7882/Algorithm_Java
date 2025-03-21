import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,E;
	static int start;
	static int result[];
	
	static class Node implements Comparable<Node>{
		int e;
		int w;
		
		public Node(int e, int w) {
			super();
			this.e = e;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.w, o.w);
		}
		
	}
	
	static List<Node> list[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		
		start = Integer.parseInt(br.readLine());
		
		
		list = new ArrayList[N+1];
		for(int i=0;i<=N;i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());	
			
			list[s].add(new Node(e,w));

		}

		
		result = new int[N+1];
		Arrays.fill(result, Integer.MAX_VALUE);
		
		dijkstra();
		
		
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<=N;i++) {
			if(result[i] == Integer.MAX_VALUE) sb.append("INF").append("\n");
			else sb.append(result[i]).append("\n");
		}
		System.out.println(sb.toString());
		
	}

	private static void dijkstra() {
		PriorityQueue<Node> queue = new PriorityQueue<>();
		queue.offer(new Node(start,0));
		result[start] = 0;
	
		while(!queue.isEmpty()) {
			Node current = queue.poll();

			
			if(result[current.e] < current.w) continue;
			
			for (Node next : list[current.e]) {
				int newcost = result[current.e] + next.w;
				
				if(result[next.e]<= newcost ) continue;
				
				
				result[next.e] = newcost;
				queue.offer(new Node(next.e, newcost));
				
			}
			
			
		}
	}

}
