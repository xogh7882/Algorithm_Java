import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, K, D;

    static class Info implements Comparable<Info> {
        int start;
        int end;
        int idx;

        Info(int start, int end, int idx) {
            this.start = start;
            this.end = end;
            this.idx = idx;
        }

        @Override
        public int compareTo(Info o) {
            if (this.start == o.start) {
                if (this.idx == o.idx) {
                    return Integer.compare(o.end, this.end);
                } else return Integer.compare(this.idx, o.idx);
            } else return Integer.compare(this.start, o.start);
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        List<Info> list = new ArrayList<>();

        for (int t = 0; t < K; t++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            list.add(new Info(A, B, C));
        }

        Collections.sort(list);

        int s = 1;
        int e = N;
        long result = 0;

        while (true) {
            if (s > e) break;

            int mid = (s + e) / 2;

            result = 0;
            for (Info info : list) {
                if (info.start > mid) break;

                result += ((Math.min(mid, info.end) - info.start) / info.idx) + 1;

            }

            if (result >= D) e = mid - 1;
            else s = mid + 1;

        }

        System.out.println(s);

    }

}
