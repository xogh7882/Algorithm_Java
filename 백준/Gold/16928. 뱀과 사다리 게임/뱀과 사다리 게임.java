import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,M;
    static int result[];
    static HashMap<Integer,Integer> hash = new HashMap<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i=0;i<N+M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            hash.put(a,b);
        }

        result = new int[101];
        Arrays.fill(result, Integer.MAX_VALUE);

        BFS(1);
        System.out.println(result[100]);
    }

    private static void BFS(int start){
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        int size = queue.size();
        int cnt = 1;
        while(!queue.isEmpty()){
            if(size==0){
                size = queue.size();
                cnt++;
            }

            int now = queue.poll();
            size--;
            if(now == 100) return;
            for(int i=1;i<=6;i++){
                int next = now + i;
                if(next > 100) continue;
                if(hash.containsKey(next)){
                    if(result[next] > cnt) {
                        result[next] = cnt;
                        result[hash.get(next)] = cnt;
                        queue.offer(hash.get(next));
                    }
                }
                else{
                    if(result[next] > cnt){
                        result[next] = cnt;
                        queue.offer(next);
                    }
                }
            }
        }
    }
}
