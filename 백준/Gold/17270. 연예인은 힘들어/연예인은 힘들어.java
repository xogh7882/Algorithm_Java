import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int V,M;

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
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList[V+1];
        for(int i=0;i<=V;i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list[s].add(new Edge(s, e, w));
            list[e].add(new Edge(e, s, w));
        }

        st = new StringTokenizer(br.readLine());
        int startA = Integer.parseInt(st.nextToken());
        int startB = Integer.parseInt(st.nextToken());

        int[] distA = new int[V+1];
        Arrays.fill(distA, Integer.MAX_VALUE/10);
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (o1,o2) -> Integer.compare(o1[1], o2[1])
        );

        pq.offer(new int[]{startA, 0});
        distA[startA] = 0;

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int nowNode = cur[0];
            int nowW = cur[1];

            for(int i=0;i<list[nowNode].size();i++){
                Edge edge = list[nowNode].get(i);

                int next = edge.e;
                int nextW = nowW + edge.w;

                if(distA[next] > nextW){
                    distA[next] = nextW;
                    pq.offer(new int[]{next, nextW});
                }
            }
        }

        int[] distB = new int[V+1];
        Arrays.fill(distB, Integer.MAX_VALUE/10);
        pq.clear();;
        pq.offer(new int[]{startB, 0});
        distB[startB] = 0;

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int nowNode = cur[0];
            int nowW = cur[1];

            for(int i=0;i<list[nowNode].size();i++){
                Edge edge = list[nowNode].get(i);
                int next = edge.e;
                int nextW = nowW + edge.w;
                if(distB[next] > nextW){
                    distB[next] = nextW;
                    pq.offer(new int[]{next, nextW});
                }
            }
        }

        int minDist = Integer.MAX_VALUE;
        for(int i=1;i<=V;i++){
            if(i==startA || i==startB) continue;
            if(distA[i] == Integer.MAX_VALUE/10 || distB[i] == Integer.MAX_VALUE/10) continue;

            minDist = Math.min(minDist, distA[i] + distB[i]);
        }


        int result = -1;

        for(int i=1;i<=V;i++){
            if(i==startA || i==startB) continue;
            if(distA[i] == Integer.MAX_VALUE/10 || distB[i] == Integer.MAX_VALUE/10) continue;


            int nowSum = distA[i] + distB[i];
            if(nowSum != minDist) continue;
            if(distA[i] > distB[i]) continue;

            if(result==-1){
                result = i;
                continue;
            }


            if(distA[i] < distA[result]){
                result = i;
            }

        }

        System.out.println(result);
    }
}
