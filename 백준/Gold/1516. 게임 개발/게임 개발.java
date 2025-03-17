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
	static int time[];
	static List<Integer> list[];
	static List<Integer> reverse[];
	static int arrIn[];
	static int result[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		time = new int[N+1];
		list = new ArrayList[N+1];
		reverse = new ArrayList[N+1];
		result = new int[N+1];
		arrIn = new int[N+1];
		
		for(int i=0;i<N+1;i++) {
			list[i] = new ArrayList<>();
			reverse[i] = new ArrayList<>();
		}
		
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			time[i] = Integer.parseInt(st.nextToken());
			while(true) {
				int s = Integer.parseInt(st.nextToken());
				if(s==-1) break;
				list[s].add(i);
				reverse[i].add(s);
				arrIn[i]++;
			}
		}
		
		// Check
//		for(int i=1;i<=N;i++) {
//			System.out.print(i + " : ");
//			for(int j=0;j<list[i].size();j++) {
//				System.out.print(list[i].get(j) + " ");
//			}
//			System.out.println();
//			System.out.println("Arr : " + arrIn[i]);
//		}
		
		
		find();
		
		for(int i=1;i<=N;i++) {
			System.out.println(result[i]);
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
			result[t] = max + time[t];
			
			for(int i=0;i<list[t].size();i++) {
				arrIn[list[t].get(i)]--;
				if(arrIn[list[t].get(i)] == 0) queue.offer(list[t].get(i));
			}
		}
		
	}

}
