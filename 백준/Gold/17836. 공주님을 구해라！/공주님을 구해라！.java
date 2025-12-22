import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N,M,T;
    static int[][] map;
    static int result = 0;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static boolean[][][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[2][N][M];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        result = findWay(0,0,0);
        if (result == -1) {
            System.out.println("Fail");
        }else{
            System.out.println(result);
        }

    }

    private static int findWay(int startR,int startC,int flag){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{startR, startC, flag, 0});

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int curR = cur[0];
            int curC = cur[1];
            int curF = cur[2];
            int curCount = cur[3];

            visited[curF][curR][curC] = true;

            if(curCount > T) return -1;

            if(curR == N-1 && curC == M-1){
                return curCount;
            }

            for(int i=0;i<4;i++){
                int newR = curR + dr[i];
                int newC = curC + dc[i];

                if(!check(newR,newC) || visited[curF][newR][newC]) continue;

                if(map[newR][newC] == 2){
                    queue.offer(new int[]{newR,newC,1,curCount+1});
                    visited[curF][newR][newC] = true;
                }
                else if(map[newR][newC] == 0){
                    queue.offer(new int[]{newR,newC,curF,curCount+1});
                    visited[curF][newR][newC] = true;
                }
                else if(map[newR][newC] == 1){
                    if(curF==1){
                        queue.offer(new int[]{newR,newC,curF,curCount+1});
                        visited[curF][newR][newC] = true;
                    }
                    else continue;
                }
            }
        }

        return -1;
    }

    private static boolean check(int r,int c){
        return r>=0 && r<N && c>=0 && c<M;
    }
}
