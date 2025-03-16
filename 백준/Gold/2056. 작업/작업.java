import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static List<Integer> list[];
	static int time[];
	static int arrIn[];
	
	static int result[];
	static int result_time = 0;
	
	static List<Integer> reverse[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		list = new ArrayList[N+1];
		for(int i=0;i<N+1;i++) {
			list[i] = new ArrayList<>();
		}
		time = new int[N+1];
		arrIn = new int[N+1];
		
		reverse = new ArrayList[N+1];
		for(int i=0;i<N+1;i++) {
			reverse[i] = new ArrayList<>();
		}
		
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			time[i] = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			
			for(int j=0;j<t;j++) {
				int e = Integer.parseInt(st.nextToken());
				list[e].add(i);
				
				reverse[i].add(e);
				
				arrIn[i]++;
			}
		}
		
		result = new int[N+1];
		
		topol();
		
		for(int i=1;i<=N;i++) {
			result_time = Math.max(result_time, result[i]);
		}
		System.out.println(result_time);
	}


	private static void topol() {
		Queue<Integer> queue = new ArrayDeque<>();
		for(int i=1;i<=N;i++) {
			if(arrIn[i] == 0) queue.offer(i);
		}
		
		while(!queue.isEmpty()) {
			int t = queue.poll();
			if(reverse[t].size()==0) {
				result[t] = time[t];
			}
			else {
				int max = 0;
				for(int i=0;i<reverse[t].size();i++) {
					max = Math.max(result[reverse[t].get(i)], max);
					result[t] = max + time[t];
				}
			}
			
			for(int i=0;i<list[t].size();i++) {
				arrIn[list[t].get(i)]--;
				if(arrIn[list[t].get(i)] == 0) {
					queue.offer(list[t].get(i));
				}
			}
			
		}
	}

}
