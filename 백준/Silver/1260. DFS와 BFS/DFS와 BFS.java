import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, V;
	static List<Integer>[] list;
	static boolean visited[];
	static StringBuilder sbbfs;
	static StringBuilder sbdfs = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N+1];
		visited = new boolean[N+1];
		
		for(int i=0;i<N+1;i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			list[s].add(e);
			list[e].add(s);
		}
		
		for(int i=1;i<N+1;i++) {
			Collections.sort(list[i]);
		}
		
		DFS(V);
		System.out.println(sbdfs.toString());;
		for(int i=1;i<N+1;i++) {
			visited[i] = false;
		}
		BFS(V);
		System.out.print(sbbfs.toString());
		
	}
	
	
	private static void BFS(int start) {
		sbbfs = new StringBuilder();
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(start);
		while(!queue.isEmpty()) {
			int q = queue.poll();
			if(visited[q]==false) {
				visited[q] = true;
				sbbfs.append(q + " ");
			}
			for(int i=0;i<list[q].size();i++) {
				if(visited[list[q].get(i)] == false)
					queue.offer(list[q].get(i));
			}
		}
		
	}
	
	
	private static void DFS(int start) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(start);
		while(!queue.isEmpty()) {
			int q = queue.poll();
			if(visited[q] == false) {
				visited[q] = true;
				sbdfs.append(q + " ");
			}
			for(int i=0;i<list[q].size();i++) {
				if(visited[list[q].get(i)] == false)
					DFS(list[q].get(i));		
			}
		}
	}

}
