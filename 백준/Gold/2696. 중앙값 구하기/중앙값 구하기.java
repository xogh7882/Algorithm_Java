import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//PQ 2개를 써서 한쪽은 넣으면 작은것부터 나오도록
//한쪽은 넣으면 큰 것부터 나오도록
//사이즈 차이가 2개이상 나면 1개 차이가 나도록 수정
//그러면 큰 쪽에 있는 peek 가 중앙값!!!!!

public class Main{
	static int T,M;
	static PriorityQueue<Integer> small;
	static PriorityQueue<Integer> big;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++)
		{
			small = new PriorityQueue<>((o1,o2) -> Integer.compare(o2, o1));
			big = new PriorityQueue<>();
			M = Integer.parseInt(br.readLine());
			sb.append((M+1)/2).append("\n");
			int a = M / 10;
			int b = M % 10;
			int c;
			for(int i=0;i<=a;i++) {
				if(i==a) c = b;
				else c = 10;
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<c;j++) {
					int temp = Integer.parseInt(st.nextToken());
					
					if(small.isEmpty() || temp < small.peek()) {
						small.offer(temp);
					}
					else {
						big.offer(temp);
					}
					
					
					if(small.size() - big.size() == 3) {
						int k = small.poll();
						big.offer(k);
					}
					else if(big.size() - small.size() == 3) {
						int k = big.poll();
						small.offer(k);
					}
					if(j%2==0) {
						if(small.size() > big.size())
							sb.append(small.peek()).append(" ");
						else
							sb.append(big.peek()).append(" ");
					}
				}
				if(i%2!=0) sb.append("\n");
			
			}
		}
		System.out.println(sb.toString());
	}

}
