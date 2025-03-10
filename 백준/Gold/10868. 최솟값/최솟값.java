import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int arr[];
	static long segTree[];
	static int height, size;
	static int left, right;
	static long result;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		height = (int) Math.ceil(Math.log(N) / Math.log(2));
		size = 2<<height;
		
		segTree = new long[size];
		
		init(1,0,N-1);
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			left = Integer.parseInt(st.nextToken())-1;
			right = Integer.parseInt(st.nextToken())-1;
			result = get(1,0,N-1);
			System.out.println(result);
		}
		
	}

	private static long get(int node, int start, int end) {
		if(right < start || end < left) return Long.MAX_VALUE;
		if(left <= start && end <= right) {
			return segTree[node];
		}
		else {
			int mid = (start + end) / 2;
			long leftvalue = get(node*2, start, mid);
			long rightvalue = get(node*2+1, mid+1, end);
			return Math.min(leftvalue, rightvalue);
		}
	}

	private static void init(int node, int start, int end) {
		if(start==end) {
			segTree[node] = arr[start];
		}
		else {
			int mid = (start+end)/2;
			init(node*2, start, mid);
			init(node*2+1, mid+1, end);
			segTree[node] = Math.min(segTree[node*2], segTree[node*2+1]);
		}
		
	}

}
