import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M,K;
	static boolean map[][];
	static int dr[] = {1,-1,0,0};
	static int dc[] = {0,0,1,-1};
	static List<Integer> list;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new boolean[N][M];
		
		for(int d=0;d<K;d++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			for(int i=N-y2;i<N-y1;i++) {
				for(int j=x1;j<x2;j++) {
					map[i][j] = true;
				}
			}

		}
		list = new ArrayList<>();
		int result = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j] == false) {
					result++;
					BFS(i,j);
				}
			}
		}
		
		System.out.println(result);
		Collections.sort(list);
		for(int i=0;i<list.size();i++) {
			System.out.print(list.get(i) + " ");
		}
		
	}
	private static void BFS(int r, int c) {
		int sum = 0;
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {r,c});
		
		while(!queue.isEmpty()) {
			int temp[] = queue.poll();
			int cr = temp[0];
			int cc = temp[1];
			map[cr][cc] = true;
			sum++;
			for(int i=0;i<4;i++) {
				int nr = cr + dr[i];
				int nc = cc + dc[i];
				if(check(nr,nc) && map[nr][nc] == false) {
					queue.offer(new int[] {nr,nc});
					map[nr][nc] = true;
				}
			}
			
		}
		list.add(sum);
		
	}
	private static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<M;
	}
	private static void printMap() {
		System.out.println("==========Print Map=============");
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j] == true) System.out.print(1 + " ");
				else System.out.print(0 + " ");
			}
			System.out.println();
		}
		
	}

}
