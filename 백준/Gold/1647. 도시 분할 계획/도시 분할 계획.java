import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static class Node implements Comparable<Node>{
        int s;
        int e;
        int w;

        public Node(int s, int e, int w){
            this.s = s;
            this.e = e;
            this.w = w;
        }
        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.w, o.w);
        }
    }

    static PriorityQueue<Node> pq = new PriorityQueue<Node>();
    static int r[];
    static int p[];
    static int min;
    static int cnt = 0;


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
            int w = Integer.parseInt(st.nextToken());
            pq.offer(new Node(s,e,w));
        }

        // MST ( 근데 개수가 하나 더 작게 - 마을 나누기 )
        // union & find

        r = new int[N+1];
        p = new int[N+1];
        for(int i=0;i<N+1;i++){
            r[i] = 1;  // rank
            p[i] = i;  // parent
        }

        while(cnt != N-2){  // 1개 적게 연결
            Node node = pq.poll();  // 간선 가중치 작은 것 하나 pq에서 꺼내기
            if(union(node.s, node.e)){  // 만약 연결이 X
                cnt++;          // 연결 간선 개수
                min += node.w;  // 가중치 계산
            }
        }
        System.out.println(min);
    }

    private static boolean union(int s, int e){
        s = find(s);
        e = find(e);
        
        if(s==e) return false; // 부모가 같다면 false
        
        if(r[s] > r[e]) {  // 더 개수가 많은 쪽으로 붙이기
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
        if(x == p[x]) return p[x]; // 최종 부모 만나면 리턴
        else return find(p[x]);  // 부모 찾을 때 까지 돌리기
    }
}
