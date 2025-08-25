import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int V,E;
    static int K;
    static List<Node> list[];
    static int result[];

    static class Node implements Comparable<Node>{
        int e;
        int w;

        public Node(int e, int w){
            this.e = e;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.w, o.w);
        }

    }

    static PriorityQueue<Node> queue = new PriorityQueue<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        K = Integer.parseInt(br.readLine());

        list = new ArrayList[V+1];
        for(int i=0;i<V+1;i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0;i<E;i++){
            st = new StringTokenizer(br.readLine());
            int u =  Integer.parseInt(st.nextToken());
            int v =  Integer.parseInt(st.nextToken());
            int w =  Integer.parseInt(st.nextToken());
            list[u].add(new Node(v,w));
        }

        result = new int[V+1];
        Arrays.fill(result, Integer.MAX_VALUE);

        dijkstra();

        for(int i=1;i<=V;i++){
            if(result[i] == Integer.MAX_VALUE) sb.append("INF").append("\n");
            else sb.append(result[i]).append("\n");
        }

        System.out.println(sb.toString());
    }

    private static void dijkstra(){
        queue.offer(new Node(K,0));            // K가 시작점
        result[K] = 0;                              // 시작점은 가중치 0 ( 출발과 동시에 도착 )

        while(!queue.isEmpty()){
            Node current = queue.poll();                        // 하나 꺼내고

            if(result[current.e] < current.w) continue;         // 이미 작아 그럼 패스

            for(Node next : list[current.e]){                 // 연결되어 있는걸 전부 찾아보고
                int newCost = result[current.e] + next.w;     // 새로운 가중치 = 현재까지 최소로 온 가중치 + 다음 가중치

                if(result[next.e] <= newCost)  continue;               // 다음 도착지까지 새로운 가중치보다 작으면 패스


                result[next.e] = newCost;                          // 더 짧게 갈수있으면 업데이트
                queue.offer(new Node(next.e, newCost));            // 및 queue에 추가

            }
        }
    }
}
