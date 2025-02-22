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
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N+1];
		for(int i=0;i<N+1;i++) {
			list[i] = new ArrayList<>();
		}
		visited = new boolean[N+1];
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e= Integer.parseInt(st.nextToken());
			list[s].add(e);
			list[e].add(s);
		}

		find();
		
		System.out.println(count-1);
		
	}

	private static void find() {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(1);
		visited[1] = true;
		
		while(!queue.isEmpty()) {
			int temp = queue.poll();
			count++;
			for(int i=0;i<list[temp].size();i++) {
				int k = list[temp].get(i);
				if(visited[k] == false) {
					visited[k] = true;
					queue.offer(k);
				}
			}
		}
		
	}

}
