import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int K;
	static int arr[];
	static int max;
	static int Tree[];
	static boolean visited[];
	static int start = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		
		Tree = new int[1<<K];
		visited = new boolean[1<<K];
		
		max = 1<<K;
		arr = new int[max];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<max-1;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		find(1);
		
		StringBuilder sb = new StringBuilder();
		int cnt = 2;
		for(int i=1;i<max;i++) {
			if(i==cnt) {
				sb.append("\n");
				cnt *=2;
			}
			sb.append(Tree[i]).append(" ");
		}
		System.out.println(sb.toString());
	}
	
	private static void find(int node) {
		if(node*2 < max && visited[node*2] == false) {
			find(node*2);
		}
		if(visited[node] == false) {
			visited[node] = true;
			Tree[node] = arr[start++];
		}
		if(node*2+1 < max && visited[node*2+1] ==false) {
			find(node*2+1);
		}
		
	}

}
