import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static class Word implements Comparable<Word>{
		String name;
		int length;
		int count;
		public Word(String name, int length, int count) {
			super();
			this.name = name;
			this.length = length;
			this.count = count;
		}
		public Word() {
			super();
		}
		
		@Override
		public String toString() {
			return "Word [name=" + name + ", length=" + length + ", count=" + count + "]";
		}
		
		@Override
		public int compareTo(Word o) {
			
			if(this.count != o.count) return Integer.compare(o.count, this.count);
			else {
				if(this.length != o.length) return Integer.compare(o.length, this.length);
				else {
					return this.name.compareTo(o.name);
				}
			}
			
		}
		
	}
	
	static int N,M;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		HashMap<String, Word> hash = new HashMap<>();
		
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			if(str.length()<M) continue;
			
			if(hash.containsKey(str)) {
				Word temp = hash.get(str);
				temp.count++;
				hash.put(str, temp);
			}
			
			else {
				Word newword = new Word(str, str.length(), 1);
				hash.put(str, newword);
			}
		}
		
//		System.out.println(hash);
		List<Word> list = new ArrayList<>();
		for (Word words : hash.values()) {
			list.add(words);
		}
		Collections.sort(list);
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<list.size();i++) {
			sb.append(list.get(i).name).append("\n");
		}
		
		System.out.println(sb.toString());
	}

}
