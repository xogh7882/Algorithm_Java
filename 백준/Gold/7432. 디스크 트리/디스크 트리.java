import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.TreeMap;

public class Main {
	static int N;
	
	static class TrieNode{
		String name;
		TreeMap<String, TrieNode> children;
		
		public TrieNode() {
			this.children = new TreeMap<>();
		}

		public TrieNode(String name) {
			this.name = name;
			this.children = new TreeMap<>(); 
		}
	}
	
	static TrieNode root = new TrieNode();
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		for(int i=0;i<N;i++) {
			TrieNode cur = root;
			
			String str = br.readLine();
	
			// 백슬래시는 4개 해야한다네..?
			String temp[] = str.split("\\\\");
			for(int j=0;j<temp.length;j++) {
				String k = temp[j];
				if(cur.children.containsKey(k) == false) {
					cur.children.put(k, new TrieNode(k));
				}
				cur = cur.children.get(k);
			}
			
		}
		
		print(root, 0);

		System.out.println(sb.toString());
	}

	private static void print(TrieNode node, int cnt) {
		Object[] temp = node.children.keySet().toArray();
		
		for(int i=0;i<temp.length;i++) {
			for(int j=0;j<cnt;j++) {
				sb.append(" ");
			}
			sb.append(temp[i]).append("\n");
			print(node.children.get(temp[i]), cnt+1);
		}
	}

}
