import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N,M,K;
	static long arr[];
	static int height, size;
	static long segTree[];
	
	
	static long sum = 0L;
	static int index;
	static long value;        // update
	static int left, right;    // get
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new long[N];
		for(int i=0;i<N;i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
		
		height = (int) Math.ceil(Math.log(N) / Math.log(2));
		size = 2 << height;
		
//		System.out.println("height : " + height);
//		System.out.println("size : " + size);
		
		
		segTree = new long[size];
		
		init(1, 0, N-1);
		
		for(int i=0;i<M+K;i++) {
			
			//printSeg();
			
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			if(a==1) {  //update
				index = Integer.parseInt(st.nextToken()) - 1;
				value = Long.parseLong(st.nextToken());
				update(1, 0, N-1);
			}
			else {  // get
				left = Integer.parseInt(st.nextToken())-1;
				right = Integer.parseInt(st.nextToken())-1;
				sum = 0L;
				sum = get(1, 0, N-1);
				System.out.println(sum);
			}
		}
		
	}

	private static long get(int node, int start, int end) {
		if(left > end || right < start) {
			return 0;
		}
		if(left <= start && end <= right) {
			return segTree[node];
		}
		else {
			int mid = (start+end)/2;
			long leftsum = get(node*2, start, mid);
			long rightsum = get(node*2+1, mid+1, end);
			return leftsum + rightsum;
		}
		
	}

	private static void update(int node, int start, int end) {
		if(start > index || end < index) return;
		if(start == end) {
			segTree[node] = value;
			return;
		}else {
			int mid = (start + end)/2;
			update(node*2, start, mid);
			update(node*2+1, mid+1, end);
			segTree[node] = segTree[node*2] + segTree[node*2+1];
		}
		
		
	}

	private static void printSeg() {
		System.out.println("==============Print Seg===========");
		for(int i=1;i<size;i++) {
			System.out.printf("segTree[%d] = %d\n", i, segTree[i]);
		}
		
	}

	private static void init(int node, int start, int end) {
		if(start == end) {
			segTree[node] = arr[start];
		}else {
			init(node*2, start, (start+end)/2);
			init(node*2+1, (start+end)/2+1, end);
			segTree[node] = segTree[node*2] + segTree[node*2+1];
		}
	}

}
