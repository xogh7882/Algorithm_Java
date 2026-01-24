import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    static int N,M;
    static int[][] map;
    static int[][] dp;

    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,1,-1};

    // 가봤다가 결국 못간곳은 다시 안들어가야하네

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[N][M];
        for(int i=0;i<N;i++){
            Arrays.fill(dp[i], -1);
        }

        int result = find(0,0);

//        printMap();

        System.out.println(result);
    }

    private static int find(int r, int c){

        if(r==N-1 && c==M-1) return 1;

        if(dp[r][c] != -1) return dp[r][c];

        dp[r][c] = 0;  // 여기 왔으면 0부터 ( 0 = 오긴 왔음  |  -1 = 아직 못옴 )

        for(int i=0;i<4;i++){
            int nr = r + dr[i];
            int nc = c + dc[i];

            if(!check(nr,nc)) continue;

            if(map[nr][nc] < map[r][c]){
                dp[r][c] += find(nr,nc);
            }
        }

        return dp[r][c];
    }

    private static boolean check(int r, int c){
        return r>=0 && r<N && c>=0 && c<M;
    }

    private static void printMap(){
        System.out.println("--------------------------------------");
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

}