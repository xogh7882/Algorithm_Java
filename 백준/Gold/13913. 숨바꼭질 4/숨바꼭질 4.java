import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,K;
	static boolean visited[];
	static int result = -1;
	static int resultarr[];
	static class Tree {
		int num;
		Tree parent;
		Tree left;
		Tree mid;
		Tree right;
		int level;
		
		public Tree(int num, Tree parent,Tree left, Tree mid, Tree right, int level) {
			super();
			this.num = num;
			this.parent = parent;
			this.left = left;
			this.mid = mid;
			this.right = right;
			this.level = level;
		}
		
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		StringBuilder sb = new StringBuilder();
		
		if(N>K) {
			sb.append(N-K).append("\n");
			for(int i=N;i>=K;i--) {
				sb.append(i).append(" ");
			}
			
		}
		else if(N==K) {
			sb.append(0).append("\n");
			sb.append(N);
		}
		else {
			Tree root = new Tree(N,null,null,null,null,0);
			visited = new boolean[Math.max(N, K)*2+1];
			visited[root.num] = true;
			
			result = BFS(root);
			
			System.out.println(result);
			int nums[] = new int[Math.max(N, K)*2+1];
			findGraph(root, nums, 0);
			
			for(int i=0;i<resultarr.length;i++) {
				sb.append(resultarr[i]).append(" ");
				if(resultarr[i] == K) break;
			}
		}
		System.out.println(sb.toString());
		
	}

	private static void findGraph(Tree root, int[] nums, int cnt) {
		if(cnt > result) return;
		if(root==null) return;
		nums[cnt] = root.num;
		if(root.num==K) {
			resultarr = nums.clone();
			return;
		}
		
		
		findGraph(root.left, nums, cnt+1);
		findGraph(root.mid, nums, cnt+1);
		findGraph(root.right,nums, cnt+1);
		
	}

	private static int BFS(Tree root) {
		Queue<Tree> queue = new ArrayDeque<>();
		queue.offer(root);
		
		while(!queue.isEmpty()) {
			Tree temp = queue.poll();

			if(temp.num==K) return temp.level;
			if(temp.num-1 >= 0 && visited[temp.num-1] == false ) {
				temp.left = new Tree(temp.num-1,temp,null,null,null,temp.level+1);
				visited[temp.num-1] = true;
				queue.offer(temp.left);
			}
			
			if(visited[temp.num+1] == false && temp.num+1 <=K) {
				temp.right = new Tree(temp.num+1,temp,null,null,null,temp.level+1);
				visited[temp.num+1] = true;
				queue.offer(temp.right);
			}
			
			if( temp.num*2 <= Math.max(N, K)*2 && visited[temp.num*2] == false ) {
				temp.mid = new Tree(temp.num*2,temp,null,null,null,temp.level+1);
				visited[temp.num*2] = true;
				queue.offer(temp.mid);
			}
		}
		
		return -1;
	}

}
