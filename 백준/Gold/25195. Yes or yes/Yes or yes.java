import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int u,v;
    static HashSet<Integer> set = new HashSet<>();
    static List[] list;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());  // 정점
        M = Integer.parseInt(st.nextToken());  // 간선

        list = new List[N+1];
        for(int i=1;i<=N;i++){
            list[i] = new ArrayList<Integer>();
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            list[u].add(v);
        }

        // 출력
//        for(int i=1;i<=N;i++){
//            print(list[i], i);
//        }


        // 곰곰이 존재하는 정점
        int c = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<c;i++){
            int a = Integer.parseInt(st.nextToken());
            set.add(a);
        }

        if (findWay(1))
            System.out.println("yes");
        else {
            System.out.println("Yes");
        }


    }

    private static boolean findWay(int u){
        // 1번이라도 곰곰이 안만나면 true로 바꿔주기
        boolean result = false;

        Queue<int[]> queue = new ArrayDeque<int[]>();
        if(set.contains(u)) return false;
        queue.offer(new int[]{u,0});

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int start = cur[0];
            int flag = cur[1];

            // 갈곳이 없다면
            if(list[start].isEmpty()){
                // 갈곳 없는데 아직 곰곰이 안만났다면
                if(flag==0) result = true;
            }

            // 갈곳이 있으면
            else{
                for(int i=0;i<list[start].size();i++){
                    if(set.contains(start) || set.contains((int) list[start].get(i))){
                        queue.offer(new int[]{(int) list[start].get(i), 1});
//                        System.out.println(start + "->" + list[start].get(i) + " : " + flag);
                    }
                    else{
                        queue.offer(new int[]{(int) list[start].get(i), flag});
//                        System.out.println(start + "->" + list[start].get(i) + " : " + flag);
                    }
                }
            }
        }

        return result;
    }

    private static void print(List list, int start){
        System.out.println("start: "+start + " ");
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i)+" ");
        }
        System.out.println("\n");
    }
}
