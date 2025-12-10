import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n,m;
    static boolean map[][];
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int count = 0;
    static int size = 0;
    public static void main(String[] args) throws Exception {

        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new boolean[n][m];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                int x = Integer.parseInt(st.nextToken());
                if(x==1) map[i][j] = true;
            }
        }

        visited = new boolean[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visited[i][j] && map[i][j]){
                    checkCount(i,j);
                    count++;
                }
            }
        }

        System.out.println(count + "\n" + size);
    }

    private static void checkCount(int i, int j){
        int cnt = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{i,j});

        while(!queue.isEmpty()){
            int[] temp = queue.poll();
            int r = temp[0];
            int c = temp[1];

            for(int k=0;k<4;k++){
                int nr = r + dr[k];
                int nc = c + dc[k];
                if(check(nr,nc) && !visited[nr][nc] && map[nr][nc]){
                    queue.offer(new int[]{nr,nc});
                    visited[nr][nc] = true;
                    cnt++;
                }
            }
        }
        if(cnt==0) cnt = 1;
        size = Math.max(cnt, size);
    }

    private static boolean check(int r, int c){
        return r>=0 && r<n && c>=0 && c<m;
    }
}
