import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int T;
	static int N,M;
	static boolean[] visited;
	static int[] score;
	static int[] limit;
	static int result = 0;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		
		for(int test_case = 1 ; test_case <= T ; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			visited = new boolean[N];
			score = new int[N];
			limit = new int[N];
			result = 0;
			
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				score[i] = Integer.parseInt(st.nextToken());
				limit[i] = Integer.parseInt(st.nextToken());
			}
			
			BestHam(0,0,0);
			
			System.out.println("#" + test_case + " " + result);
			
		}
		
	}
	
	
	private static void BestHam(int cnt, int sum, int kal) {
		if(cnt == N) {
			if(sum > result && kal <= M) result = sum;
			return;
		}
		
		visited[cnt] = true;
		BestHam(cnt+1, sum+score[cnt], kal+limit[cnt]);
		visited[cnt] = false;
		BestHam(cnt+1, sum, kal);
		
	}

}
