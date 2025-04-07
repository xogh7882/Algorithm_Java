import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int t;
	static int N;
	
	static class TrieNode {
		TrieNode[] children;
		boolean isNumber;
		boolean end;
		public TrieNode() {
			this.children = new TrieNode[10];
			this.isNumber = false;
			this.end = false;
		}
	}
	
	static TrieNode root = new TrieNode();
	
	static int result = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		
		for(int test_case = 0 ; test_case < t ; test_case++)
		{
			root = new TrieNode();
			
			N = Integer.parseInt(br.readLine());
			result = 0;
			
			for(int i=0;i<N;i++) {
				String str = br.readLine();
				Insert(str);
				
			}
			
			if(result == 0) System.out.println("YES");
			else System.out.println("NO");

		}
		
	}
	
	
	private static void Insert(String str) {
		int flag = 0;
		TrieNode cur = root;
		
		for(int i=0;i<str.length();i++) {
			
			int idx = str.charAt(i) - '0';
			
			if(cur.children[idx] == null) {
				cur.children[idx] = new TrieNode();
				cur.isNumber = true;
			}
			cur = cur.children[idx];
			
			
			if(cur.isNumber == false) flag++;
			if(cur.end == true && flag == 0) result++;
			
		}
		cur.isNumber = true;
		cur.end = true;
		
		if(flag == 0) result++;
		
	}

}
