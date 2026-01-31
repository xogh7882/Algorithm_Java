import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N,M,K;

    static int map[][];  // 파이어볼 개수
    static int mmap[][];
    static int smap[][];
    static int dmap[][];


    static int dr[] = {-1,-1,0,1,1,1,0,-1};
    static int dc[] = {0,1,1,1,0,-1,-1,-1};

    static Queue<int[]> queue = new ArrayDeque<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N+1][N+1];
        mmap = new int[N+1][N+1];
        smap = new int[N+1][N+1];
        dmap = new int[N+1][N+1];


        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            queue.offer(new int[]{r,c,m,s,d});

        }

        // 이동 K번 명령
        for(int move=1 ; move<=K ; move++){
            for(int i=0;i<=N;i++){
                Arrays.fill(map[i], 0);
                Arrays.fill(mmap[i], 0);
                Arrays.fill(smap[i], 0);
                Arrays.fill(dmap[i], -2);
            }

            // 이동하고
            while(!queue.isEmpty()){
                int[] cur = queue.poll();

                int nr = cur[0] + (dr[cur[4]] * cur[3]);
                int nc = cur[1] + (dc[cur[4]] * cur[3]);

                // 벽 넘어가기 가능
                nr += N * 1000;
                nc += N * 1000;

                nr = (nr%N==0) ? N : (nr%N);
                nc = (nc%N==0) ? N : (nc%N);

                map[nr][nc]++;
                mmap[nr][nc] += cur[2];
                smap[nr][nc] += cur[3];
                if(dmap[nr][nc] == -2){
                    dmap[nr][nc] = cur[4];
                }
                else if(dmap[nr][nc] == -1) continue;
                else{
                    if(dmap[nr][nc]%2 == cur[4] % 2) continue;
                    else dmap[nr][nc] = -1;
                }

            }

            // 합쳐진거 찾고 뿌리고
            for(int i=1;i<=N;i++){
                for(int j=1;j<=N;j++){
                    if(map[i][j] == 1){
                        queue.offer(new int[]{i,j,mmap[i][j], smap[i][j], dmap[i][j]});
                    }
                    else if(map[i][j] > 1){
                        int m = mmap[i][j] / 5;
                        int s = smap[i][j] / map[i][j];
                        int startNum = (dmap[i][j] == -1) ? (1) : (0);

                        if(m==0) continue;

                        for(int d=startNum;d<=7;d=d+2){
                            int nr = i + dr[d];
                            int nc = j + dc[d];

                            nr += N * 1000;
                            nc += N * 1000;

                            nr = (nr%N==0) ? N : (nr%N);
                            nc = (nc%N==0) ? N : (nc%N);

                            queue.offer(new int[]{i,j,m,s,d});
                        }
                    }
                }
            }

        }

        // 질량 찾고
        int result = 0;
        while(!queue.isEmpty()){
            result += queue.poll()[2];
        }

        System.out.println(result);
    }



    private static boolean check(int r, int c){
        return r>=1 && r<=N && c>=1 && c<=N;
    }


}
