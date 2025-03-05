import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int T;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		for (int t = 0; t < T; t++) {
			String func = br.readLine();
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int num[] = new int[N];

			st = new StringTokenizer(br.readLine(), ",");
			for (int i = 0; i < N; i++) {
				if (N == 1) {
					String str = st.nextToken();
					str = str.substring(1, str.length() - 1);
					num[i] = Integer.parseInt(str);
					continue;
				}

				if (i == 0) {
					String str = st.nextToken();
					str = str.substring(1, str.length());
					num[i] = Integer.parseInt(str);
				}

				else if (i == N - 1) {
					String str = st.nextToken();
					int size = str.length();
					str = str.substring(0, size - 1);
					num[i] = Integer.parseInt(str);
				}

				else {
					num[i] = Integer.parseInt(st.nextToken());
				}
			}

			int start = 0;
			int end = N - 1;
			int cnt = 0;

			for (int i = 0; i < func.length(); i++) {
				if (func.charAt(i) == 'R') {
					if (cnt == start) {
						cnt = end;
					} else
						cnt = start;
				}

				if (func.charAt(i) == 'D') {
					if (cnt == start) {
						cnt++;
						start++;
					} else {
						cnt--;
						end--;
					}
				}
			}
			StringBuilder sb = new StringBuilder();
			
//			System.out.println("start : " + start + ", end : " + end);
		
			if (start > end && Math.abs(start - end) == 1) {
				sb.append("[");
				sb.append("]");
			}
			else if (start > end)
				sb.append("error");
			else if (cnt == start) {
				sb.append("[");
				for (int i = start; i <= end; i++) {
					sb.append(num[i]);
					if (i != end)
						sb.append(",");
				}
				sb.append("]");
			} else {
				sb.append("[");
				for (int i = end; i >= start; i--) {
					sb.append(num[i]);
					if (i != start)
						sb.append(",");
				}
				sb.append("]");
			}

			System.out.println(sb.toString());

		}

	}
}
