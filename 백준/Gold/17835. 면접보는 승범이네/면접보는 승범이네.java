import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
    static int N,M,K;

    static class Node{
        int e;
        long w;
        public Node(int e, long w){
            this.e = e;
            this.w = w;
        }
    }
    static List<Node> list[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        list = new List[N+1];
        for(int i=0;i<=N;i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list[e].add(new Node(s, w));
        }


        PriorityQueue<Node> queue = new PriorityQueue<>(
                (o1,o2) -> Long.compare(o1.w, o2.w)
        );

        long dist[] = new long[N+1];
        Arrays.fill(dist, Long.MAX_VALUE);

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<K;i++){
            int start = Integer.parseInt(st.nextToken());
            dist[start] = 0;
            queue.offer(new Node(start,0));
        }

        while(!queue.isEmpty()){
            Node node = queue.poll();

            if(dist[node.e] < node.w) continue;

            for(Node n : list[node.e]){
                long nextW = node.w + n.w;

                if(dist[n.e] > nextW){
                    dist[n.e] = nextW;
                    queue.offer(new Node(n.e, nextW));
                }
            }
        }

        int node = 1;
        long result = -1;

        for(int i=1;i<=N;i++){
            if(dist[i] > result){
                result = dist[i];
                node = i;
            }
        }

        System.out.println(node);
        System.out.println(result);


    }
}