import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] map;
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,-1,0,1};

    static int sharkSize = 2;  // 아기 상어 크기
    static int sharkSizeForNum = 2;  // 이만큼 먹으면 커진다

    static int sharkR, sharkC;
    static int time = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 9){
                    sharkR = i;
                    sharkC = j;
                    map[i][j] = 0;
                }
            }
        }

        boolean finish = false;

        while(true){
            // 먹을 수 있는 먹이가 있니?
            finish = findFeed();
            if(finish) break;
        }

        System.out.println(time);

    }

    private static boolean findFeed(){
        boolean[][] visited = new boolean[N][N];
        int breakCnt = Integer.MAX_VALUE;
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (o1,o2) -> (o1[0] == o2[0]) ? Integer.compare(o1[1], o2[1]) : Integer.compare(o1[0], o2[0])
        );  // 같은 거리 먹이를 pq에 넣고 가장 위이면서 왼쪽 꺼내기
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{sharkR, sharkC, 0});
        visited[sharkR][sharkC] = true;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int curR = cur[0];
            int curC = cur[1];
            int cnt = cur[2];

            if(breakCnt < cnt) break;

            if(map[curR][curC] < sharkSize && map[curR][curC] != 0){  // 먹을게 있으면
                // 먹고 수정할 것들 수정하고 return false;
                breakCnt = cnt;
                pq.offer(new int[]{curR, curC});
            }

            for(int i=0;i<4;i++){
                int nr = curR + dr[i];
                int nc = curC + dc[i];

                if(!check(nr,nc) || visited[nr][nc]) continue;

                if(map[nr][nc] <= sharkSize){
                    visited[nr][nc] = true;
                    queue.offer(new int[]{nr,nc,cnt+1});
                }
            }


        }

        if(pq.isEmpty()) return true;  // 먹이가 없다
        else{
            int[] cur = pq.poll();
            time += breakCnt;
            sharkR = cur[0];
            sharkC = cur[1];
            sharkSizeForNum--;
            if(sharkSizeForNum==0){
                sharkSize++;
                sharkSizeForNum = sharkSize;
            }
            map[sharkR][sharkC] = 0;

            return false;
        }

    }

    private static boolean check(int r, int c){
        return r>=0 && r<N && c>=0 && c<N;
    }
}
