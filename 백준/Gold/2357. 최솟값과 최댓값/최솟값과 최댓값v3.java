import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// segTree 하나만 사용
// 사이즈를 2배로 늘려서 옆에 하나 더 있는 것 처럼 사용하기
// 1부터 N-1까지는 minTree
// 1+size부터 N-1+size 까지는 maxTree

public class Main{
	static int N,M;
	static long arr[];
	static long segTree[];
	static int height, size;
	static int left, right;
	static long min, max;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		height = (int)(Math.ceil(Math.log(N)/Math.log(2)));
		size = 2 << height;
		arr = new long[N];
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		segTree = new long[size*2];
		
		init(1,0,N-1);

		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			left = Integer.parseInt(st.nextToken())-1;
			right = Integer.parseInt(st.nextToken())-1;
			min = Long.MAX_VALUE;
			max = Long.MIN_VALUE;
			get(1,0,N-1);
			System.out.println(min + " " + max);
		}
		
	}


	private static void get(int node, int start, int end) {
		if(left > end || right < start) {
			return;
		}
		if(left <= start && end <= right) {
			min = Math.min(min, segTree[node]);
			max = Math.max(max, segTree[node+size]);
		}
		else {
			int mid = (start+end)/2;
			get(node*2,start,mid);
			get(node*2+1,mid+1,end);
			
		}
		
	}


	private static void init(int node, int start, int end) {
		if(start == end) {
			segTree[node] = arr[start];
			segTree[node+size] = arr[start];
			return;
		}
		else {
			int mid = (start+end)/2;
			init(node*2, start, mid);
			init(node*2+1, mid+1, end);
			segTree[node] = Math.min(segTree[node*2], segTree[node*2+1]);
			segTree[node+size] = Math.max(segTree[node*2 + size], segTree[node*2+1 + size]);
		}
		
	}

}
