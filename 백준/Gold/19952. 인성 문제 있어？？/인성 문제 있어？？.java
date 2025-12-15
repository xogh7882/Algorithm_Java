import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int H,W,O,F,Xs,Ys,Xe,Ye,X,Y,L;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++) {
            st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            O = Integer.parseInt(st.nextToken());
            F = Integer.parseInt(st.nextToken());
            Xs = Integer.parseInt(st.nextToken());
            Ys = Integer.parseInt(st.nextToken());
            Xe = Integer.parseInt(st.nextToken());
            Ye = Integer.parseInt(st.nextToken());

            map = new int[H+1][W+1];
            visited = new boolean[H+1][W+1];

            for(int i=0;i<O;i++){
                st = new StringTokenizer(br.readLine());
                X = Integer.parseInt(st.nextToken());
                Y = Integer.parseInt(st.nextToken());
                L = Integer.parseInt(st.nextToken());
                map[X][Y] = L;
            }

            if(canGo()) sb.append("잘했어!!").append("\n");
            else sb.append("인성 문제있어??").append("\n");

        }
        System.out.println(sb.toString());
    }

    private static boolean canGo() {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{Xs,Ys,F});
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int currX = curr[0];
            int currY = curr[1];
            int currF = curr[2];

            visited[currX][currY] = true;

            // 목적지 도착하면 True
            if(currX == Xe && currY == Ye) return true;

            // 남은 힘 없으면 끝
            if(currF==0) continue;

            for(int i=0;i<4;i++){
                int nr = currX + dr[i];
                int nc = currY + dc[i];

                // 못가면 패스
                if(!check(nr,nc) || visited[nr][nc]) continue;

                // 나보다 작으면 갈 수 있다 ( 힘 -1 )
                if(map[nr][nc] < map[currX][currY]){
                    queue.offer(new int[]{nr,nc,currF-1});
                    visited[nr][nc] = true;
                }

                // 나보다 크면
                else{
                    if((map[nr][nc] - map[currX][currY]) <= currF){
                        queue.offer(new int[]{nr,nc,currF-1});
                        visited[nr][nc] = true;
                    }
                }

            }

        }
        return false;
    }

    private static boolean check(int r, int c){
        return r>=1 && r<=H && c>=1 && c<=W;
    }
}
