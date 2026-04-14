import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int N,K;

    // 상 우 하 좌
    static int dr[] = {-1,0,1,0};
    static int dc[] = {0,1,0,-1};
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        int map[][] = new int[N+1][N+1];


        for(int i=0;i<K;i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[r][c] = 1;
        }

        int L = Integer.parseInt(br.readLine());
        HashMap<Integer, Character> hashMap = new HashMap<>();
        for(int i=0;i<L;i++){
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            char ch = st.nextToken().charAt(0);
            hashMap.put(time, ch);
        }

        int result = 0;
        int nowR = 1;
        int nowC = 1;
        int nowD = 1;
        map[nowR][nowC] = 9;
        LinkedList<int[]> list = new LinkedList<>();
        list.add(new int[]{nowR, nowC});

        while(true){
            int nr = nowR + dr[nowD];
            int nc = nowC + dc[nowD];

            result++;

            if(!check(nr, nc) || map[nr][nc] == 9) break;


            // 사과 있으면 머리만 늘리고
            if(map[nr][nc] == 1){
                list.addFirst(new int[]{nr, nc});
                map[nr][nc] = 9;
            }

            // 사과 없으면 머리 늘리고, 꼬리 줄이고
            else{
                list.addFirst(new int[]{nr, nc});
                int[] tail = list.removeLast();
                map[nr][nc] = 9;
                map[tail[0]][tail[1]] = 0;
            }

            nowR = nr;
            nowC = nc;

            // 해당 시간에 머리 꺾어야하면
            if(hashMap.containsKey(result)){
                char ch = hashMap.get(result);
                if(ch == 'L'){
                    nowD--;
                    if(nowD == -1) nowD = 3;
                }
                else {
                    nowD++;
                    if(nowD==4) nowD = 0;
                }
            }

        }

        System.out.println(result);

    }

    private static boolean check(int r, int c){
        return r>=1 && r<=N && c>=1 && c<=N;
    }

}
