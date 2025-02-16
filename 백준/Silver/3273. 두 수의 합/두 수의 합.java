import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int X;
	static int num[];
	static int count = 0;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		num = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		X = Integer.parseInt(st.nextToken());
		
		Arrays.sort(num);
		
		int x = 0;
		int y = num.length-1;
		
		while(true) {
			if(x >= y) break;
			if(num[x] + num[y] == X) {
				count++;
				x++;
				y--;
			}
			else if(num[x] + num[y] > X) {
				y--;
			}
			else {
				x++;
			}
		}
		
		System.out.println(count);
		
	}

}
