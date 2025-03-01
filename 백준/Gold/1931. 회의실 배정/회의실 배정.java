import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int result = 0;
	
	static class Time implements Comparable<Time>{
		int start;
		int end;
		public Time(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}
		@Override
		public int compareTo(Time o) {
			return this.end != o.end ? this.end - o.end : this.start - o.start;
		}
		// 끝나는 시간이 같으면, 시작시간이 빠른 것 부터
		// 끝나는 시간이 다르면, 끝나는 시간이 빠른 것 부터
	}
	
	static PriorityQueue<Time> queue;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		queue = new PriorityQueue<>();
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			queue.offer(new Time(s,e));
		}
		
		int prev = -1;
		while(!queue.isEmpty()) {
			Time time = queue.poll();
			if(time.start >= prev) {
				result++;
				prev = time.end;
			}
			
		}
		
		System.out.println(result);
	}

}

// 빨리 끝나는거 부터 고르면
// 최대한 많이 할 수 있다?
// 근데 안겹치게
