import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int A,B,C;
	static int num[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		num = new int[101];
		for(int i=0;i<3;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			for(int j=s;j<e;j++) {
				num[j]++;
			}
		}
		int result = 0;
		for(int i=0;i<num.length;i++) {
			if(num[i] == 1) {
				result += A;
			}
			else if(num[i] == 2) {
				result+=B*2;
			}
			else if(num[i] == 3) {
				result+=C*3;
			}
		}
		//System.out.println(Arrays.toString(num));
		System.out.println(result);

	}

}
