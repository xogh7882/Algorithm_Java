import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		List<String> list = new ArrayList<>();  // 100자리 숫자 들어올수도 있으니깐 String
		
		
		for(int i=0;i<N;i++) {
			String temp = "";
			String str = br.readLine();
			for(int j=0;j<str.length();j++) {
				if('0' <= str.charAt(j) && str.charAt(j) <= '9' ) {
					if(temp.equals("0") && str.charAt(j)=='0') continue;  // 0 이미 있으면 패수
					else if(temp.equals("0") && str.charAt(j) != '0') temp = "" + str.charAt(j); //0이미 있으면 지우고 입력
					else temp+=str.charAt(j); 
				}
				
				else {
					if(temp == "") continue;
					else list.add(temp);
					temp = "";
				}
				
			}
			if(temp != "") list.add(temp);
		}
		
		Collections.sort(list, new Comparator<String>() {
			
			@Override
			public int compare(String o1, String o2) {
				if(o1.length() != o2.length()) return Integer.compare(o1.length(), o2.length());  //긴게 큰거
				else return o1.compareTo(o2);  // 아니면 그냥
			}
			
		});
		
		StringBuilder sb = new StringBuilder();
		for(String str : list) {
			sb.append(str + "\n");
		}
		System.out.println(sb.toString());
	}

}
