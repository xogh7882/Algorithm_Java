import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static List<Integer> list;
	static int arr[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		N = Integer.parseInt(st.nextToken());
		HashMap<Integer, Integer> map = new HashMap<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			int temp = Integer.parseInt(st.nextToken());
			if(map.containsKey(temp) == false) {
				map.put(temp, 1);
			}
			else {
				map.replace(temp, map.get(temp)+1);
			}
		}
		
//		System.out.println(map.toString());
		
		// Key값 빼서 정렬
		list = new ArrayList<>(map.keySet());
		Collections.sort(list);
		
		arr = new int[N];
		
		for(int i=0;i<list.size();i++) {
			arr[i] = list.get(i);
		}
		
		
		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<M;i++) {
			int find = Integer.parseInt(st.nextToken());
			
			int s = 0;
			int e = list.size()-1;
			int mid;
			
			while(true) {
				if(s>e) {
					sb.append(0).append(" ");
					break;
				}
				mid = (s+e)/2;
				
				if(arr[mid] == find) {
					sb.append(map.get(arr[mid])).append(" ");
					break;
				}
				else if(arr[mid] < find) {
					s = mid+1;
				}
				else {
					e = mid-1;
				}
				
				
			}
		}
		
		System.out.println(sb.toString());
		
	}

}
