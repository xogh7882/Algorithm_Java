import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int start[];
	static int Asize,Bsize,Csize,maxSize = -1;
	static List<Integer> list;
	static boolean check[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Asize = Integer.parseInt(st.nextToken());
		maxSize = Math.max(maxSize, Asize);
		Bsize = Integer.parseInt(st.nextToken());
		maxSize = Math.max(maxSize, Bsize);
		Csize = Integer.parseInt(st.nextToken());
		maxSize = Math.max(maxSize, Csize);
		
		
		start = new int[] {0,0,Csize};    // 오른쪽 물통이 꽉 찬상태에서 스타트
		list = new ArrayList<>();
		check = new boolean[maxSize+1];       // c에 남은 물의 양이 중복이 안되도록
		BFS();
		
		Collections.sort(list);
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<list.size();i++) {
			sb.append(list.get(i)).append(" ");
		}
		
		System.out.println(sb.toString());
		
	}
	
	private static void BFS() {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(start);
		boolean visited[][][] = new boolean[maxSize+1][maxSize+1][maxSize+1];
		
		while(!queue.isEmpty()) {
			int temp[] = queue.poll();
			int a = temp[0];
			int b = temp[1];
			int c = temp[2];
//			System.out.println("=================================");
//			System.out.println(a + " : " + b + " : " + c);
			
			if(a==0 && check[c] == false) {
				list.add(c);
				check[c] = true;
			}
			
			visited[a][b][c] = true;
			
			// 물을 넣을 수 있는 경우의 수? 6개
			// 근데 물이 없는경우 + ( 물을 넣었을 때 꽉 차는 경우 or 꽉 안차는 경우 )
			
			
			if(a!=0) {
				// 1. a -> b
				if(a+b <= Bsize) {
					int na = 0;
					int nb = a+b;
					int nc = c;
					if(visited[na][nb][nc]==false) {
						queue.offer(new int[] {na,nb,nc});
						visited[na][nb][nc] = true;
					}
				}
				else {
					int na = a - (Bsize-b);
					int nb = Bsize;
					int nc = c;
					if(visited[na][nb][nc]==false) {
						queue.offer(new int[] {na,nb,nc});
						visited[na][nb][nc] = true;
					}
				}
				
				
				// 2. a -> c
				if(a+c <= Csize) {
					int na = 0;
					int nb = b;
					int nc = a+c;
					if(visited[na][nb][nc]==false) {
						queue.offer(new int[] {na,nb,nc});
						visited[na][nb][nc] = true;
					}
				}
				else {
					int na = a - (Csize-c);
					int nb = b;
					int nc = Csize;
					if(visited[na][nb][nc]==false) {
						queue.offer(new int[] {na,nb,nc});
						visited[na][nb][nc] = true;
					}
				}
			
			}
			
			if(b!=0) {
				// 3. b->a
				if(b+a <= Asize) {
					int na = a+b;
					int nb = 0;
					int nc = c;
					if(visited[na][nb][nc]==false) {
						queue.offer(new int[] {na,nb,nc});
						visited[na][nb][nc] = true;
					}
				}
				else {
					int na = Asize;
					int nb = b - (Asize-a);
					int nc = c;
					if(visited[na][nb][nc]==false) {
						queue.offer(new int[] {na,nb,nc});
						visited[na][nb][nc] = true;
					}
				}
				
				
				// 4. b -> c
				if(b+c <= Csize) {
					int na = a;
					int nb = 0;
					int nc = b+c;
					if(visited[na][nb][nc]==false) {
						queue.offer(new int[] {na,nb,nc});
						visited[na][nb][nc] = true;
					}
				}
				else {
					int na = a;
					int nb = b - (Csize-c);
					int nc = Csize;
					if(visited[na][nb][nc]==false) {
						queue.offer(new int[] {na,nb,nc});
						visited[na][nb][nc] = true;
					}
				}
			}
			
			
			if(c!=0) {
				// 5. c -> a
				if(c+a <= Asize) {
					int na = a+c;
					int nb = b;
					int nc = 0;
					if(visited[na][nb][nc]==false) {
						queue.offer(new int[] {na,nb,nc});
						visited[na][nb][nc] = true;
					}
				}
				else {
					int na = Asize;
					int nb = b;
					int nc = c - (Asize-a);
					if(visited[na][nb][nc]==false) {
						queue.offer(new int[] {na,nb,nc});
						visited[na][nb][nc] = true;
					}
				}
				
				
				// 6. c -> b
				if(b+c <= Bsize) {
					int na = a;
					int nb = b+c;
					int nc = 0;
					if(visited[na][nb][nc]==false) {
						queue.offer(new int[] {na,nb,nc});
						visited[na][nb][nc] = true;
					}
				}
				else {
					int na = a;
					int nb = Bsize;
					int nc = c - (Bsize-b);
					if(visited[na][nb][nc]==false) {
						queue.offer(new int[] {na,nb,nc});
						visited[na][nb][nc] = true;
					}
				}
			}
			
			
			
		}
	}

}
