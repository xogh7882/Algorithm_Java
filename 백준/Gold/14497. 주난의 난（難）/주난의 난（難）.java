
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    static int N,M;
    static int startR, startC, endR, endC;
    static int map[][];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        startR = Integer.parseInt(st.nextToken());
        startC = Integer.parseInt(st.nextToken());
        endR = Integer.parseInt(st.nextToken());
        endC = Integer.parseInt(st.nextToken());

        map = new int[N+1][M+1];

        for(int i=1;i<=N;i++){
            String str = br.readLine();
            for(int j=1;j<=M;j++){
                if(str.charAt(j-1) == '1') map[i][j] = 1;
                else map[i][j] = 0;
            }
        }

        int time = 0;
        while(true){
            time++;
            if(jump()) break;
        }

        System.out.println(time);

    }

    static int dr[] = {0,0,1,-1};
    static int dc[] = {1,-1,0,0};

    public static boolean jump(){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{startR, startC});
        boolean visited[][] = new boolean[N+1][M+1];
        visited[startR][startC] = true;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int nowR = cur[0];
            int nowC = cur[1];

            if(nowR == endR && nowC == endC) return true;

            for(int i=0;i<4;i++){
                int nr = nowR + dr[i];
                int nc = nowC + dc[i];

                if(!check(nr,nc) || visited[nr][nc]) continue;

                if(map[nr][nc] == 1 && !visited[nr][nc]){
                    visited[nr][nc] = true;
                    map[nr][nc] = 0;
                }
                else if(!visited[nr][nc]){
                    visited[nr][nc] = true;
                    queue.offer(new int[]{nr,nc});
                }
            }

        }

        return false;
    }

    public static boolean check(int r, int c){
        return r>=1 && r<=N && c>=1 && c<=M;
    }
}