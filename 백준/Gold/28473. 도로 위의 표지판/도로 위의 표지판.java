import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static class Node implements Comparable<Node>{
        int s;
        int e;
        int z;
        int w;

        public Node(int s, int e, int z, int w){
            this.s = s;
            this.e = e;
            this.z = z;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return (this.z==o.z) ? (Integer.compare(this.w, o.w)) : (Integer.compare(this.z, o.z));
        }
    }

    static PriorityQueue<Node> pq = new PriorityQueue<>();
    static int[] r;
    static int[] p;
    static int cnt;
    static long min;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            pq.offer(new Node(s,e,z,w));

        }

        r = new int[N+1];
        p = new int[N+1];
        for(int i=0;i<N+1;i++){
            r[i] = 1;
            p[i] = i;
        }
        cnt = 0;
        min = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        while(!pq.isEmpty() && cnt != N-1){
            Node node = pq.poll();
            if(union(node.s, node.e)){
                cnt++;
                min += node.w;
                queue.offer(node.z);
            }
        }

        StringBuilder sb = new StringBuilder();
        if(queue.isEmpty() || cnt != N-1) sb.append("-1");
        else{
            int before = queue.poll();
            sb.append(before);
            while(!queue.isEmpty()){
                int temp = queue.poll();
//                if(before == temp) continue;
//                else{
//                    sb.append(temp);
//                }
                sb.append(temp);
                before = temp;
            }

            sb.append(" ").append(min);
        }

        System.out.println(sb.toString());
    }

    private static boolean union(int s, int e){
        s = find(s);
        e = find(e);

        if(s == e) return false;

        if(r[s] > r[e]){
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
        if(p[x] == x) return p[x];
        else return find(p[x]);
    }
}
