import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int V, K;

    static class Edge implements Comparable<Edge> {
        int s;
        int e;
        int w;

        public Edge(int s, int e, int w) {
            this.s = s;
            this.e = e;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.w, o.w);
        }
    }

    static List<Edge> list[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        list = new List[V+1];

        for(int i=1;i<=V;i++){
            list[i] = new ArrayList<Edge>();
        }

        for(int i=0;i<K;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[s].add(new Edge(s, e, w));
            list[e].add(new Edge(e, s, w));
        }


        int[] parent = new int[V+1];


        int[] dist = new int[V+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (o1,o2) -> Integer.compare(o1[1], o2[1])
        );
        pq.offer(new int[]{1,0});

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int nowNode = cur[0];
            int nowW = cur[1];

            for(int i=0;i<list[nowNode].size();i++){
                Edge edge = list[nowNode].get(i);

                int next = edge.e;
                int nextW = nowW + edge.w;

                if(dist[next] > nextW){
                    dist[next] = nextW;
                    pq.offer(new int[]{next,nextW});
                    parent[next] = nowNode;
                }
            }
        }

        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=2;i<=V;i++){
            if(parent[i] == 0) continue;

            cnt++;
            sb.append(i).append(" ").append(parent[i]).append("\n");

        }
        System.out.println(cnt);
        System.out.println(sb.toString());


    }
}
