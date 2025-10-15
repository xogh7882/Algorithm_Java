import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] p, d;
    static int answer = 0;
    static PriorityQueue<int[]> queue = new PriorityQueue<>(
            (o2,o1) -> Integer.compare(o1[0], o2[0])
    );
    static boolean[] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        p = new int[n];
        d = new int[n];
        visited = new boolean[n+1];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            p[i] = Integer.parseInt(st.nextToken());
            d[i] = Integer.parseInt(st.nextToken());

            queue.offer(new int[]{p[i],d[i]});
        }

        while(!queue.isEmpty()){
            int a[] = queue.poll();
//            System.out.println(a[0]+" "+a[1]);

            for(int i=n;i>=1;i--){
                if(i<=a[1] && !visited[i]){
                    answer += a[0];
                    visited[i] = true;
                    break;
                }
            }
        }

        System.out.println(answer);
    }


}
