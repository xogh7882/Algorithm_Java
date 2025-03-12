import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int T,M;
	static int arr[];
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t=0;t<T;t++)
		{
			M = Integer.parseInt(br.readLine());
			arr = new int[M];
			Arrays.fill(arr, Integer.MAX_VALUE);
			sb.append((M+1)/2).append("\n");
			
			int a = M / 10;
			if(a==0) a = 1;
			else a++;
			int b = M % 10;
			int c;
			for(int i=0;i<a;i++) {
				if(i!=0 && i%2==0) sb.append("\n");
				st = new StringTokenizer(br.readLine());
				if(i!=a-1) c = 10;
				else c= b;
				for(int j=0;j<c;j++) {
					arr[i*10+j] = Integer.parseInt(st.nextToken());
					if(j%2==0) {
						Arrays.sort(arr);
						sb.append(arr[(i*10+j)/2]).append(" ");
					}
				}
				
			}
			if(t!=T-1)
				sb.append("\n");	
		}
		System.out.println(sb.toString());

	}

}
