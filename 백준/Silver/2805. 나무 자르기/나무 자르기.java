import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static long num[];
	static long minH = 0;
	static long maxH = 0;
	static long result = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		num = new long[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
			maxH = Math.max(maxH, num[i]);
		}

		while (true) {
			if(maxH - minH == 1) {
				long maxvalue = calc(maxH);
				long minvalue = calc(minH);
				if(maxvalue == M || minvalue < M) {
					minH = maxH;
					break;
				}
				else if(minvalue == M || maxvalue < M) {
					break;
				}
				else {
					break;
				}
			}
			
			result = (minH + maxH) / 2;

			if (calc(result) == M) {
				minH = result;
				break;
			}

			if (calc(result) > M) {
				minH = result;
			} else {
				maxH = result;
			}

		}

		System.out.println(minH);

	}

	private static long calc(long height) {
		long sum = 0;
		for (int i = 0; i < N; i++) {
			sum += (num[i] - height >= 0 ? num[i] - height : 0);
		}
		return sum;
	}

}
