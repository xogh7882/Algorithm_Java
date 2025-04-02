import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
	static int T;
	static int N;
	static class score implements Comparable<score>{
		int scoreA;
		int scoreB;
		public score( int scoreA, int scoreB) {
			super();
			this.scoreA = scoreA;
			this.scoreB = scoreB;
		}
		@Override
		public int compareTo(score o) {
			return Integer.compare(this.scoreA, o.scoreA);
		}
		
	}
	static int result;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1 ; test_case <= T ; test_case ++ ) 
		{
			result = 0;
			N = Integer.parseInt(br.readLine());
			
			List<score> list = new ArrayList<>();
			
			for(int i=1;i<=N;i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				list.add(new score(a,b));
			}
			
			Collections.sort(list);
			
			int min = -1;
			
			for(int i=0;i<N;i++) {
				score temp = list.get(i);
				if(i==0) {
					min = temp.scoreB;
					result++;
				}
				else {
					if(temp.scoreB < min) {
						min = temp.scoreB;
						result++;
					}
				}
			}
			
			sb.append(result).append("\n");
		}
		System.out.println(sb.toString());
	}

}
