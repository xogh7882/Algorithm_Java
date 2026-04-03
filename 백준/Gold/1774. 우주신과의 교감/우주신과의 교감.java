import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;

    static class Info {
        int id;
        int x;
        int y;

        Info(int id, int x, int y) {
            this.id = id;
            this.x = x;
            this.y = y;
        }
    }


    static class Node implements Comparable<Node> {
        int s;
        int e;
        double w;

        Node(int s, int e, double w) {
            this.s = s;
            this.e = e;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return Double.compare(this.w, o.w);
        }
    }

    static PriorityQueue<Node> pq = new PriorityQueue<>();
    static int parent[];
    static int rank[];

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        List<Info> list = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new Info(i, x, y));

            for (int j = 1; j < i; j++) {
                Info info = list.get(j - 1);
                pq.offer(new Node(i, info.id, calc(x, y, info.x, info.y)));
            }

        }

        parent = new int[N + 1];
        rank = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            union(start, end);

        }

        double result = 0L;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            if (union(node.s, node.e)) {
                result += node.w;
            }
        }

        System.out.printf("%.2f\n", result);


    }

    private static boolean union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y) return false;

        if (rank[x] > rank[y]) {
            rank[x] += rank[y];
            parent[y] = x;
        } else {
            rank[y] += rank[x];
            parent[x] = y;
        }

        return true;
    }

    private static int find(int x) {
        if (x == parent[x]) return x;
        else return find(parent[x]);
    }

    private static double calc(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
}