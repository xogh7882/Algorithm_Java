import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static List[] list;
    static boolean[] visited;
    static boolean result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new List[N];
        for(int i=0;i<N;i++){
            list[i] = new ArrayList<Integer>();
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }


        visited = new boolean[N];
        result = false;

        for(int i=0;i<N;i++){
            if(result) break;
            visited[i] = true;
            findFriend(i,0);
            visited[i] = false;
        }

        if(result) System.out.println("1");
        else System.out.println("0");
    }

    private static void findFriend(int now, int cnt){
        if(result) return;

        if(cnt == 4){
            result = true;
            return;
        }

        for(int i=0;i<list[now].size();i++){
            if(visited[(int)list[now].get(i)]) continue;

            visited[(int)list[now].get(i)] = true;
            findFriend((int)list[now].get(i),cnt+1);
            visited[(int)list[now].get(i)] = false;

        }
    }
}
