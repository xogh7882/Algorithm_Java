import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static List<Integer>[] list;
	static boolean visited[];
	static int count = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N+1];
		visited = new boolean[N+1];
		
		for(int i=0;i<N+1;i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			list[s].add(e);
			list[e].add(s);
		}
		for(int i=1;i<=N;i++) {
			if(visited[i] == false) {
				find(i);
				count++;
			}
		}
		
		System.out.println(count);
	}
	
	
	private static void find(int start) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(start);
		visited[start] = true;
		while(!queue.isEmpty()) {
			int temp = queue.poll();
			for(int i=0;i<list[temp].size();i++) {
				int k = list[temp].get(i);
				if(visited[k]) continue;
				visited[k] = true;
				queue.offer(k);
			}
		}
	}

}
