import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int num[];
	static boolean visited[];
	static int select[];
	static int op[];
	static List<String> list;
	
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		num = new int[N];
		select = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		op = new int[N-1];
		int cnt = 0;
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<4;i++) {
			int temp = Integer.parseInt(st.nextToken());
			for(int j=0;j<temp;j++){
				op[cnt++] = i;
			}
		}
		
		visited = new boolean[N-1];
		list = new ArrayList<>();
		list.add(Integer.toString(num[0]));
		
		perm(0);
		
		System.out.println(max);
		System.out.println(min);
	}

	
	private static void perm(int cnt) {
		if(cnt==N-1) {
			calc();
			return;
		}
		for(int i=0;i<N-1;i++) {
			if(visited[i]) continue;
			visited[i] = true;
			if(op[i] == 0)list.add("+");
			else if(op[i] == 1) list.add("-");
			else if(op[i] == 2) list.add("*");
			else if(op[i] == 3) list.add("/");
			
			list.add(Integer.toString(num[cnt+1]));
			perm(cnt+1);
			list.remove(list.size()-1);
			list.remove(list.size()-1);
			visited[i] = false;
		}

	}


	private static void calc() {
		List<Integer> stack = new ArrayList<>();
		stack.add(Integer.parseInt(list.get(0)));
		for(int i=1;i<list.size();i=i+2) {
			if(list.get(i).equals("+")) {
				stack.add(Integer.parseInt(list.get(i+1)));
			}
			else if(list.get(i).equals("-")) {
				stack.add(Integer.parseInt(list.get(i+1))*-1);
			}
			else if(list.get(i).equals("*")) {
				int temp = stack.get(stack.size()-1);
				stack.remove(stack.size()-1);
				stack.add(Integer.parseInt(list.get(i+1))*temp);
			}
			else if(list.get(i).equals("/")) {
				int temp = stack.get(stack.size()-1);
				stack.remove(stack.size()-1);
				stack.add(temp/Integer.parseInt(list.get(i+1)));
			}
			
		}
		int sum = 0;
		while(!stack.isEmpty()) {
			sum+=stack.get(stack.size()-1);
			stack.remove(stack.size()-1);
		}
		if(sum > max) max = sum;
		if(sum < min) min = sum;
		return;
	}

}
