import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N,M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int result[] = new int[N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			
			if(p < l) result[i] = 1;
			else {
				List<Integer> list = new ArrayList<>();
				for(int j=0;j<p;j++) {
					list.add(Integer.parseInt(st.nextToken()));
				}
				Collections.sort(list);
				Collections.reverse(list);
				result[i] = list.get(l-1);
			}
		}
		
		int count = 0;
		Arrays.sort(result);
		
//		System.out.println(Arrays.toString(result));
		
		for(int i=0;i<result.length;i++) {
			M -= result[i];
			if(M >= 0) count++;
			else break;
		}
		System.out.println(count);
	}

}
