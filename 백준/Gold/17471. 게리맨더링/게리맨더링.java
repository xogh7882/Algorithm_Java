import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int num[];
	static List<Integer> list[];
	static int result = Integer.MAX_VALUE/10;
	static boolean visited[];
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		num = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		list = new ArrayList[N+1];
		for(int i=0;i<N+1;i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			for(int j=0;j<M;j++) {
				int k = Integer.parseInt(st.nextToken());
				list[i].add(k);
			}
		}
		
		visited = new boolean[N+1];
		subset(0,1);
		
		if(result == Integer.MAX_VALUE/10) result = -1;
		System.out.println(result);
		
	}


	private static void subset(int cnt, int start) {
		if(cnt==N) {
			calc();
			return;
		}
		
		for(int i=start;i<=N;i++) {
			visited[i] = true;
			subset(cnt+1, i+1);
			visited[i] = false;
			subset(cnt+1, i+1);
		}
		
	}


	private static void calc() {
		List<Integer> teamA = new ArrayList<>();
		List<Integer> teamB = new ArrayList<>();
		
		for(int i=1;i<=N;i++) {
			if(visited[i] == true) teamA.add(i);
			else teamB.add(i);
		}
		
		if(teamA.size()==0 || teamB.size()==0) return;
		
		boolean vis[] = new boolean[N+1];
		BFS(teamA, vis);
		for(int i=0;i<teamA.size();i++) {
			if(vis[teamA.get(i)] == false) return;
		}
		
		vis = new boolean[N+1];
		BFS(teamB, vis);
		for(int i=0;i<teamB.size();i++) {
			if(vis[teamB.get(i)] == false) return;
		}
		
		result = Math.min(result, Math.abs(teamsum(teamA) - teamsum(teamB)));
	}


	private static int teamsum(List<Integer> team) {
		int sum = 0;
		for(int i=0;i<team.size();i++) {
			sum += num[team.get(i)];
		}
		return sum;
	}


	private static void BFS(List<Integer> team, boolean[] vis) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(team.get(0));
		
		while(!queue.isEmpty()) {
			int k = queue.poll();
			vis[k] = true;
			for(int i=0;i<list[k].size();i++) {
				if(vis[list[k].get(i)] ==false && team.contains(list[k].get(i))) {
					vis[list[k].get(i)] = true;
					queue.offer(list[k].get(i));
				}
			}
		}
	}

}
