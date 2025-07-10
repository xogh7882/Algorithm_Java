import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int map[][];
    static int copymap[][];
    static boolean[][] visited;
    static int rest = 0;
    static int time = 0;
    static int dr[] = {1,-1,0,0};
    static int dc[] = {0,0,1,-1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        copymap = new int[N][M];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] != 0 ) rest++;
            }
        }

        while(true){

            if(rest == 0) {  // 전부 다 녹았니?
                time = 0;
                break;
            }

            if(check() >= 2){  // 2덩어리 이상으로 나눠졌니?
                break;
            }

            melting();   // 얼음 녹이기
            time++;      // 시간 증가
        }

        System.out.println(time);

    }

    private static int check(){
        visited = new boolean[N][M];
        int cnt = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j] != 0 && visited[i][j] == false){
                    find(i,j);
                    cnt++;
                }
            }
        }

        return cnt;
    }

    private static void find(int x, int y) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{x,y});
        visited[x][y] = true;

        while(!queue.isEmpty()){
            int temp[] = queue.poll();
            int r = temp[0];
            int c = temp[1];
            visited[r][c] = true;

            for(int i=0;i<4;i++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                if(checkout(nr,nc) == true && visited[nr][nc] == false && map[nr][nc] != 0){
                    visited[nr][nc] = true;
                    queue.offer(new int[]{nr,nc});
                }
            }
        }
    }

    private static boolean checkout(int r, int c) {
        return r>=0 && r<N && c>=0 && c<M;
    }

    private static void melting(){
        for(int i=0;i<N;i++){
            copymap[i] = map[i].clone();
        }


        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(copymap[i][j] != 0){
                    int cnt = 0;
                    for(int k=0;k<4;k++){
                        int nr = i + dr[k];
                        int nc = j + dc[k];
                        if(map[nr][nc] == 0){
                            cnt++;
                        }
                    }
                    copymap[i][j] = (map[i][j] - cnt >= 0 ? map[i][j]-cnt : 0);
                    if(copymap[i][j] == 0) rest--;
                }
            }
        }

        for(int i=0;i<N;i++){
            map[i] = copymap[i].clone();
        }
    }


}
