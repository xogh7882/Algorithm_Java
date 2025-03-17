import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int T;
	static int N,K;
	static StringTokenizer st;
	static int time[];
	static List<Integer> list[];
	static List<Integer> reverse[];
	static int arrIn[];
	static int target;
	static int result[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int test_case=1;test_case<=T;test_case++)
		{
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			time = new int[N+1];
			st = new StringTokenizer(br.readLine());
			for(int i=1;i<N+1;i++) {
				time[i] = Integer.parseInt(st.nextToken());
			}
			
			list = new ArrayList[N+1];
			reverse = new ArrayList[N+1];
			arrIn = new int[N+1];
			
			for(int i=0;i<N+1;i++) {
				list[i] = new ArrayList<>();
				reverse[i] = new ArrayList<>();
			}
			
			for(int i=0;i<K;i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				list[s].add(e);
				reverse[e].add(s);
				arrIn[e]++;
				
			}
			
			target = Integer.parseInt(br.readLine());
			
			result = new int[N+1];
			find();
			
			System.out.println(result[target]);
			
//			System.out.println("--------------------------------");
//			System.out.println(Arrays.toString(result));
			
		}

	}

	private static void find() {
		Queue<Integer> queue = new ArrayDeque<>();
		for(int i=1;i<=N;i++) {
			if(arrIn[i] == 0) queue.offer(i);
		}
		
		while(!queue.isEmpty()) {
			int t = queue.poll();
			int max = 0;
			for(int i=0;i<reverse[t].size();i++) {
				max = Math.max(max, result[reverse[t].get(i)]);
			}
			
//			System.out.println(t + " : " + max + " : " + time[t]);
			
			result[t] = max + time[t];
			
			if(t==target) break;
			
			for(int i=0;i<list[t].size();i++) {
				arrIn[list[t].get(i)]--;
				if(arrIn[list[t].get(i)] == 0) queue.offer(list[t].get(i));
			}
		}
		
	}

}
