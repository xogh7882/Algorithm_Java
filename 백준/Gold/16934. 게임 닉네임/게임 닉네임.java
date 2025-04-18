import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main{
	static int N;
	
	static class TrieNode{
		TrieNode[] children;
		boolean isNumber;
		
		public TrieNode() {
			this.children = new TrieNode[26];
			this.isNumber = false;
		}
	}
	
	static TrieNode name = new TrieNode();
	
	static HashMap<String, Integer> map = new HashMap<>();
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		for(int i=0;i<N;i++) {
			String str = br.readLine();

			String k = Insert(str);
			
			
			if(str.equals(k) == true) {
				if(map.containsKey(str) == false) {
					sb.append(k).append("\n");
					map.put(str, 1);
				}
				else {
					int temp = map.get(str);
					temp++;
					sb.append(str).append(temp).append("\n");
					map.put(str, temp);
				}
			}
			else {
				sb.append(k).append("\n");
				map.put(str, 1);
			}
			
			
		}
		
		System.out.println(sb.toString());
	}
	


	private static String Insert(String str) {
		int flag = 0;
		String result = "";
		
		TrieNode cur = name;
		
		for(int i=0;i<str.length();i++) {
			int idx = str.charAt(i) - 'a';
			
			if(flag==0)	result+=str.charAt(i);
			
			if(cur.children[idx] == null) {
				cur.children[idx] = new TrieNode();
				flag++;
			}
			cur = cur.children[idx];
		}
		
		cur.isNumber = true;
		
		return result;
	}

}
