import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static int A,B,C;
	static int total;
	static boolean visited[][];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		total = A+B+C;

		visited = new boolean[1501][1501];
		
		if((A+B+C) % 3 != 0) {
			System.out.println(0);
			System.exit(0);
		}
		
		if(bfs(A,B,C)==true) System.out.println(1);
		else System.out.println(0);
		
		
	}

	private static boolean bfs(int A, int B, int C) {

		Queue<int[]> queue = new ArrayDeque<int[]>();
		queue.offer(new int[] {A,B});
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			if(temp[0] == temp[1] && temp[1] == (total-temp[0]-temp[1])) return true;
			int a = Math.min(temp[0], Math.min(temp[1], total-temp[0]-temp[1]));
			int c = Math.max(temp[0], Math.max(temp[1], total-temp[0]-temp[1]));
			int b = total - a - c;
			
			visited[a][b] = true;
			
			if(b-a>0) {
				b = b-a;
				a = a*2;
				int na = Math.min(a, Math.min(b, c));
				int nc = Math.max(a, Math.max(b, c));
				int nb = total - na - nc;
				
				if(visited[na][nb] == false) {
					visited[na][nb] = true;
					queue.offer(new int[] {na,nb});
				}
				
			}
			if(c-a>0) {
				c = c-a;
				a = a*2;
				int na = Math.min(a, Math.min(b, c));
				int nc = Math.max(a, Math.max(b, c));
				int nb = total - na - nc;
				if(visited[na][nb] == false) {
					visited[na][nb] = true;
					queue.offer(new int[] {na,nb});
				}
			}
			if(c-b>0) {
				c = c-b;
				b = b*2;
				int na = Math.min(a, Math.min(b, c));
				int nc = Math.max(a, Math.max(b, c));
				int nb = total - na - nc;
				if(visited[na][nb] == false) {
					visited[na][nb] = true;
					queue.offer(new int[] {na,nb});
				}
			}
		}
		
		return false;
	
		
	}

}
