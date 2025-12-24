import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int T;
    static int M,N,K;
    static boolean[][] map;
    static boolean[][] visited;
    static int result;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new boolean[M][N];
            visited = new boolean[M][N];

            for(int num=0; num<K; num++){
                st = new StringTokenizer(br.readLine());
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                map[r][c] = true;
            }
            result = 0;
            for(int i=0;i<M;i++){
                for(int j=0;j<N;j++){
                    if(map[i][j] && !visited[i][j]){
                        findResult(i,j);
                        result++;
                    }
                }
            }
            sb.append(result).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void findResult(int r, int c) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{r,c});
        visited[r][c] = true;
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int curR = cur[0];
            int curC = cur[1];

            for(int i=0;i<4;i++){
                int nr = curR + dr[i];
                int nc = curC + dc[i];

                if(check(nr,nc) && !visited[nr][nc] && map[nr][nc]){
                    visited[nr][nc] = true;
                    queue.offer(new int[]{nr,nc});
                }
            }

        }
    }

    private static boolean check(int r, int c){
        return r>=0 && r<M && c>=0 && c<N;
    }
}
