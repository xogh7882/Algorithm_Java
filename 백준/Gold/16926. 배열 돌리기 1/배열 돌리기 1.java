import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N,M,R;
    static int map[][];
    static boolean visited[][];
    static int dr[] = {0,1,0,-1};
    static int dc[] = {1,0,-1,0};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map =  new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int start;
        visited = new boolean[N][M];
        for(int i=0;i<R;i++) {
            init();
            start = 0;
            while (true) {
                if (!check(start, start) || visited[start][start]) break;
                rotate(start);
                start++;
            }
        }
        printMap();

    }

    private static void init() {
        for(int i=0;i<N;i++) {
           Arrays.fill(visited[i], false);
        }
    }

    private static void rotate(int start) {
        int r = start;
        int c = start;
        int temp, nr, nc;

        temp = map[r][c];

        for(int dir=0;dir<4;dir++){
            while(true){
                nr = r + dr[dir];
                nc = c + dc[dir];
                if(!check(nr,nc) || visited[nr][nc]) break;

                visited[r][c] = true;
                map[r][c] = map[nr][nc];
                r = nr;
                c = nc;
            }
        }

        map[start+1][start] = temp;

    }

    private static boolean check(int r, int c) {
        return r>=0 && r<N && c>=0 && c<M;
    }

    private static void printMap() {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                sb.append(map[i][j]);
                if(j!=M-1) sb.append(" ");
            }
            if(i!=N-1) sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
