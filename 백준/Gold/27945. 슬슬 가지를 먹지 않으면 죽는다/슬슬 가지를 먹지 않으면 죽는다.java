import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;

    static class Node implements Comparable<Node> {
        int s;
        int e;
        int t;

        public Node(int s, int e, int t){
            this.s = s;
            this.e = e;
            this.t = t;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.t, o.t);
        }
    }

    static PriorityQueue<Node> pq = new PriorityQueue<Node>();
    static int r[];
    static int p[];
    static int cnt;
    static int num;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            pq.offer(new Node(u, v, t));
        }

        r = new int[N+1];
        p = new int[N+1];
        cnt = 0;
        num = 1;

        for(int i=0;i<N+1;i++){
            r[i] = 1;
            p[i] = i;
        }

        while(!pq.isEmpty() && cnt != N-1){
            Node node = pq.poll();
            if(node.t != num) continue;

            if(union(node.s, node.e)){
                cnt++;
                num++;
            }
        }

        System.out.println(num);

    }


    private static boolean union(int s, int e){
        s = find(s);
        e = find(e);

        if(s==e) return false;

        if(r[s] > r[e]) {
            r[s] += r[e];
            p[e] = s;
        }
        else{
            r[e] += r[s];
            p[s] = e;
        }

        return true;
    }

    private static int find(int x){
        if(x == p[x]) return p[x];
        else return find(p[x]);
    }

}
