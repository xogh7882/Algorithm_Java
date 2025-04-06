import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Trie 사용

// 메모리 : 872436 KB       시간 : 2300 ms
// 이 문제는 아에 같은 문자열을 찾는 문제라서 HashSet이 더 효율적인 방법인듯

public class Main {
	static int N,M;
	
	static class TriNode{
		TriNode[] children;
		boolean isNumber;
		
		public TriNode() {
			this.children = new TriNode[26];
			this.isNumber = false;
		}
	}
	
	static TriNode root = new TriNode();
	static int result = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			Insert(str);
		}
		
		for(int i=0;i<M;i++) {
			String str = br.readLine();
			if(find(str)==true) result++;
		}
		
		System.out.println(result);
	}


	private static void Insert(String str) {
		TriNode cur = root;
		
		for(int i=0;i<str.length();i++) {
			int idx = str.charAt(i) - 'a';
			
			if(cur.children[idx] == null) {
				cur.children[idx] = new TriNode();
			}
			cur = cur.children[idx];
		}
		
		cur.isNumber = true;
	}

	
	private static boolean find(String str) {
		TriNode cur = root;
		
		for(int i=0;i<str.length();i++) {
			int idx = str.charAt(i)-'a';
			
			if(cur.children[idx] == null) return false;
			
			cur = cur.children[idx];
		}
		if(cur.isNumber==true) return true;
		else return false;
		
	}
}
