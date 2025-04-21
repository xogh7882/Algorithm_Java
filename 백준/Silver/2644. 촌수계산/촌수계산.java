import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int x,y;
	static int start, end;
	static int result = -1;
	static List<Integer> list[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		list = new ArrayList[N+1];
		for(int i=0;i<=N;i++) {
			list[i] = new ArrayList<>();
		}
		
		st = new StringTokenizer(br.readLine());
		
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		M = Integer.parseInt(br.readLine());
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			
			list[x].add(y);
			list[y].add(x);
			
		}
		
		find(start, end);
		find(end,start);
		
		System.out.println(result);
		
	}
	
	private static void find(int a, int b) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(a);
		
		boolean visited[] = new boolean[N+1];
		
		int cnt = 0;
		int size = queue.size();
		
		while(!queue.isEmpty()) {
			if(size==0) {
				size = queue.size();
				cnt++;

			}
			
			int k = queue.poll();
			visited[k] = true;
			size--;
			
			if(k==b) result = cnt;
			
			for(int i=0;i<list[k].size();i++) {
				if(visited[list[k].get(i)] == false) {
					visited[list[k].get(i)] = true;
					queue.offer(list[k].get(i));
				}
			}
		}
		
	}

}
