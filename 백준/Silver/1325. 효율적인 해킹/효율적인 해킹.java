import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.concurrent.ArrayBlockingQueue;

public class Main {
	static int N,M;
	static ArrayList<Integer>[] list;
	static boolean[] visited;
	static int max;
	static int[] maxIdx;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N+1];
		for(int i=0;i<=N;i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			list[s].add(e);
		}
		
		visited = new boolean[N+1];
		maxIdx = new int[N+1];
		
		for(int i=1;i<=N;i++) {
			if(list[i].isEmpty()) continue;
			
			Queue<Integer> queue = new LinkedList<>();
			queue.offer(i);
			visited[i] = true;
			
			while(!queue.isEmpty()) {
				int cur = queue.poll();
				for(int j=0;j<list[cur].size();j++) {
					int ni = list[cur].get(j);
					if(visited[ni]) continue;
					queue.offer(ni);
					visited[ni] = true;
					maxIdx[ni]++;
				}
			}
			
			visited = new boolean[N+1];
		}
		
		for(int i : maxIdx) {
			if(i != 0) max = Math.max(max, i);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<=N;i++) {
			if(maxIdx[i] == max) sb.append(i).append(" ");
		}
		System.out.println(sb.toString());
		
		
	}

}
