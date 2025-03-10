import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// SegTree 클래스 만들기?

public class Main {
	static int N,M;
	static long arr[];
	static int left, right;
	
	static class Tree{
		int size;
		int height;
		long segTree[];
		
		public Tree(int N) {
			this.height = (int)(Math.ceil(Math.log(N) / Math.log(2)));
			this.size = 2<<this.height;
			segTree = new long[size];
		}
		
		public void init(int node, int start, int end, int flag) {
			if(start == end) {
				segTree[node] = arr[start];
				return;
			}
			else {
				int mid = (start+end)/2;
				init(node*2, start, mid, flag);
				init(node*2+1, mid+1, end, flag);
				if(flag==0) this.segTree[node] = Math.min(this.segTree[node*2], this.segTree[node*2+1]);
				else this.segTree[node] = Math.max(this.segTree[node*2], this.segTree[node*2+1]);
			}
			
		}
		
		public long get(int node, int start, int end, int flag) {
			if(left > end || right < start) {
				if(flag==0) return Long.MAX_VALUE;
				else return 0;
			}
			if(left <= start && end <= right) {
				return this.segTree[node];
			}
			else {
				int mid = (start+end)/2;
				long leftvalue = get(node*2, start, mid, flag);
				long rightvalue = get(node*2+1, mid+1, end, flag);
				if(flag==0) return Math.min(leftvalue, rightvalue);
				else return Math.max(leftvalue, rightvalue);
			}
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new long[N];
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Tree segTreeMin = new Tree(N);
		Tree segTreeMax = new Tree(N);
		
		segTreeMin.init(1, 0, N-1, 0);
		segTreeMax.init(1, 0, N-1, 1);
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			left = Integer.parseInt(st.nextToken())-1;
			right = Integer.parseInt(st.nextToken())-1;
			long min = segTreeMin.get(1,0,N-1,0);
			long max = segTreeMax.get(1,0,N-1,1);
			System.out.println(min + " " + max);
		}

	}

}
