import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static long arr[];
	static long segTreeMin[];
	static long segTreeMax[];
	static int height, size;
	static int left, right;
	
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
		
		segTreeMin = new long[size];
		segTreeMax = new long[size];
		
		init(segTreeMin,1,0,N-1,0);
		init(segTreeMax,1,0,N-1,1);
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			left = Integer.parseInt(st.nextToken())-1;
			right = Integer.parseInt(st.nextToken())-1;
			long min = get(segTreeMin,1,0,N-1,0);
			long max = get(segTreeMax,1,0,N-1,1);
			System.out.println(min + " " + max);
		}
		
	}

	private static long get(long[] segTree, int node, int start, int end, int flag) {
		if(left > end || right < start) {
			if(flag==0) return Long.MAX_VALUE;
			else return 0;
		}
		if(left <= start && end <= right) {
			return segTree[node];
		}
		else {
			int mid = (start+end)/2;
			long leftvalue = get(segTree, node*2, start, mid, flag);
			long rightvalue = get(segTree, node*2+1, mid+1, end, flag);
			if(flag==0) return Math.min(leftvalue, rightvalue);
			else return Math.max(leftvalue, rightvalue);
		}
	}

	private static void init(long segTree[], int node, int start, int end, int flag) {
		if(start == end) {
			segTree[node] = arr[start];
			return;
		}
		else {
			int mid = (start+end)/2;
			init(segTree, node*2, start, mid, flag);
			init(segTree, node*2+1, mid+1, end, flag);
			if(flag==0) segTree[node] = Math.min(segTree[node*2], segTree[node*2+1]);
			else segTree[node] = Math.max(segTree[node*2], segTree[node*2+1]);
		}
		
	}

}
