import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	static int N;
	static class Node{
		char left;
		char right;
		public Node(char left, char right) {
			super();
			this.left = left;
			this.right = right;
		}
		
		public Node() {
			super();
			
		}
		
	
	}
	
	static Node node[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		node = new Node[N];
		for(int i=0;i<N;i++) {
			node[i] = new Node();
		}
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			char parent = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);
			
			node[parent-'A'].left = left;
			node[parent-'A'].right = right;
		}
		
		preorder('A');
		System.out.println();
		inorder('A');
		System.out.println();
		postorder('A');
			
		
	}

	private static void postorder(char ch) {
		if(ch == '.') return;
		postorder(node[ch-'A'].left);
		postorder(node[ch-'A'].right);
		System.out.print(ch);
	}

	private static void inorder(char ch) {
		if(ch == '.') return;
		inorder(node[ch-'A'].left);
		System.out.print(ch);
		inorder(node[ch-'A'].right);
		
	}

	private static void preorder(char ch) {
		if(ch == '.') return;
		System.out.print(ch);
		preorder(node[ch-'A'].left);
		preorder(node[ch-'A'].right);
		
	}

}
