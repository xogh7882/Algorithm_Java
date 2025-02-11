// 구역을 A, B로 나눈다
// visited는 하나만 쓴다
// 구간을 나누고, 각자 BFS를 돌린다
// visited에 안간게 있다 = 제대로 못나눈거

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] nums;               
	static List<Integer>[] list;    
	static boolean[] visited;        
	static int result = Integer.MAX_VALUE;

	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		nums = new int[N];
		visited = new boolean[N];
		list = new ArrayList[N];
		
		for(int i=0;i<N;i++) {
			list[i] = new ArrayList<>();
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<N;i++) {
			int s = i;
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			for(int j=0;j<M;j++) {
				int e = Integer.parseInt(st.nextToken());
				list[s].add(e-1);
			}
		}
		
		subset(0);
		if(result == Integer.MAX_VALUE) result = -1;
		System.out.println(result);
		
		
	}



	private static void subset(int cnt) {
		if(cnt == N) {
				
			conn(visited);
			return;
		}
		visited[cnt] = true;
		subset(cnt+1);
		visited[cnt] = false;
		subset(cnt+1);
		
	}

	private static void conn(boolean[] visitedAB) {
		List<Integer> teamA = new ArrayList<>();
		List<Integer> teamB = new ArrayList<>();
		
		for(int i=0;i<N;i++) {
			if(visitedAB[i]) teamA.add(i);
			else teamB.add(i);
		}
		
		if(teamA.isEmpty() || teamB.isEmpty()) return;
		
		boolean BFSVisited[] = new boolean[N];
		BFS(teamA, BFSVisited, true);
		BFS(teamB, BFSVisited, false);
		
		for(int i=0;i<N;i++) {
			if(BFSVisited[i] == false) return;
		}
		calcTeam();
		return;
	}



	private static void calcTeam() {
		int A = 0;
		int B = 0;
		for(int i=0;i<N;i++) {
			if(visited[i] == true) A+=nums[i];
			else B+=nums[i];
		}
		if(result > Math.abs(A-B)) result = Math.abs(A-B);
	}



	private static void BFS(List<Integer> team, boolean[] BFSVisited, boolean flag) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(team.get(0));
		
		while(!queue.isEmpty()) {
			int k = queue.poll();
			BFSVisited[k] = true;
			for(int i=0;i<list[k].size();i++) {
				if(visited[list[k].get(i)] == flag && BFSVisited[list[k].get(i)] == false) {
					queue.add(list[k].get(i));

				}
			}
		}
		
	}




}
