import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,K;
	static boolean visited[];
	static int result = Integer.MAX_VALUE;
	static int num = 0;
	
	static class Tree{
		int num;
		Tree parent;
		Tree left;
		Tree mid;
		Tree right;
		int level;
		
		public Tree(int num, Tree parent, Tree left, Tree mid, Tree right, int level) {
			super();
			this.num = num;
			this.parent = parent;
			this.left = left;
			this.mid = mid;
			this.right = right;
			this.level = level;
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		if(N>K) {    // 갈 수 있는 방법이 -1 해서 가는 것 뿐
			System.out.println(N-K);
			System.out.println(1);
		}
		else if(N==K) {  // 이미 끝남
			System.out.println(0);
			System.out.println(1);
		}
		else {
			Tree root = new Tree(N,null,null,null,null,0);
			visited = new boolean[K*2+1];
			visited[root.num] = true;
			
			BFS(root);  // 트리 만들기
			
			System.out.println(result);
			System.out.println(num);
		}
	}


	private static int BFS(Tree root) {
		Queue<Tree> queue = new ArrayDeque<>();
		queue.offer(root);
		
		while(!queue.isEmpty()) {
			Tree temp = queue.poll();
			visited[temp.num] = true;
			
			
			if(temp.num==K) {
				if(temp.level < result) {
					result = temp.level;
					num = 1;
				}
				else if(temp.level == result) {
					num++;
				}
				continue;
			}
			
			
			if(temp.num-1 >= 0 && visited[temp.num-1] == false && temp.level <= result) {
				temp.left = new Tree(temp.num-1,temp,null,null,null,temp.level+1);
				queue.offer(temp.left);
			}
			
			
			if( temp.num+1 <=K && visited[temp.num+1] == false && temp.level <= result) {
				temp.right = new Tree(temp.num+1,temp,null,null,null,temp.level+1);
				queue.offer(temp.right);
			}
			
			
			if( temp.num*2 <= K*2 && visited[temp.num*2] == false && temp.level <= result) {
				temp.mid = new Tree(temp.num*2,temp,null,null,null,temp.level+1);
				queue.offer(temp.mid);
			}
		}
		
		return -1;
	}

}
