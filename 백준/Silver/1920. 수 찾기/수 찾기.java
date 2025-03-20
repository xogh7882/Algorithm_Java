import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	static int N;
	static int arr[];
	static int M;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			int find = Integer.parseInt(st.nextToken());
			findnum(find);
		}
		System.out.println(sb.toString());
	}

	private static void findnum(int find) {
		int s = 0;
		int e = N-1;
		int mid;
		while(true) {
			if(s>e) break;
			mid = (s + e) / 2;
			if(arr[mid] == find) {
				sb.append(1).append("\n");
				return;
			}
			else if(arr[mid] < find) {
				s = mid + 1;
			}
			else {
				e = mid - 1;
			}
		}
		sb.append("0").append("\n");
		return;
		
	}

}
