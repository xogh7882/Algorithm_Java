
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main{

    static int T;

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


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        for(int t=1;t<=T;t++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            List<Node> list[] = new List[M];
            for(int i=0;i<M;i++){
                list[i] = new ArrayList<>();
            }

            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());

                list[s].add(new Node(e,w));
                list[e].add(new Node(s,w));
            }

            int[] dist = new int[M];
            int[] way = new int[M];

            for(int i=0;i<M;i++){
                dist[i] = Integer.MAX_VALUE;
                way[i] = -1;
            }

            dist[0] = 0;

            PriorityQueue<Node> queue = new PriorityQueue<>();
            queue.offer(new Node(0,0));

            while(!queue.isEmpty()){
                Node cur = queue.poll();

                if(cur.e == M-1) break;

                for(Node n : list[cur.e]){
                    int nextNode = n.e;
                    int nextW = cur.w + n.w;

                    if(dist[nextNode] > nextW){
                        dist[nextNode] = nextW;
                        way[nextNode] = cur.e;
                        queue.offer(new Node(nextNode,nextW));
                    }
                }
            }

            sb.append("Case #").append(t).append(": ");

            if(dist[M-1] == Integer.MAX_VALUE) sb.append("-1");
            else{
                int now = M-1;
                Stack<Integer> stack = new Stack<>();
                while(true){
                    stack.push(now);
                    if(now == 0) break;
                    now = way[now];
                }

                while(!stack.isEmpty()){
                    sb.append(stack.pop()).append(" ");
                }
            }


            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}