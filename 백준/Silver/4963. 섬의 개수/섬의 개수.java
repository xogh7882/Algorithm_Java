import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int dr[] = {-1,-1,-1,0,1,1,1,0};
    static int dc[] = {-1,0,1,1,1,0,-1,-1};
    static int h,w;
    static int map[][];
    static boolean visited[][];

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while(true){
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if(h == 0 && w == 0) break;

            int cnt = 0;
            map = new int[h][w];
            visited = new boolean[h][w];

            for(int i=0;i<h;i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<w;j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i=0;i<h;i++){
                for(int j=0;j<w;j++){
                    if(!visited[i][j] && map[i][j] == 1) {
                        BFS(i,j);
                        cnt++;
                    }
                }
            }
            sb.append(cnt + "\n");
        }

        System.out.println(sb.toString());
    }

    private static void BFS(int i,int j){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{i,j});

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];
            visited[r][c] = true;
            for(int k=0;k<8;k++){
                int nr = r + dr[k];
                int nc = c + dc[k];
                if(!check(nr,nc)) continue;
                if(!visited[nr][nc] && map[nr][nc] == 1){
                    visited[nr][nc] = true;
                    queue.offer(new int[]{nr,nc});
                }
            }
        }
    }

    private static boolean check(int r,int c){
        return r>=0 && r<h && c>=0 && c<w;
    }
}
