import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int T;
	static int N,M;
	static BigInteger arr[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new BigInteger[31];
		for(int i=0;i<=30;i++) {
			arr[i] = new BigInteger("0");
		}
		arr[0] = BigInteger.valueOf(1);
		for(int i=1;i<=30;i++) {
			arr[i] = arr[i-1].multiply(BigInteger.valueOf(i));
		}
		//System.out.println(Arrays.toString(arr));
		T = Integer.parseInt(st.nextToken());
		for(int test_case = 1; test_case <= T; test_case++)
		{
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			System.out.println(arr[M].divide(arr[N].multiply(arr[M-N])));
		}

	}

}
