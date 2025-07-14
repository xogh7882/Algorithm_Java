import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,M;
    static int map[][];
    static int result[][];
    static int startR, startC;
    static int dr[] = {0,0,1,-1};
    static int dc[] = {1,-1,0,0};
    public  static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2){
                    startR = i;
                    startC = j;
                }
            }
        }

        result = new  int[N][M];
        for(int i=0;i<N;i++){
            Arrays.fill(result[i],-1);
        }


        BFS(startR, startC);

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(result[i][j] == -1 && map[i][j] == 1) result[i][j] = -1;
                else if(result[i][j] == -1 && map[i][j] != 1) result[i][j] = 0;
                System.out.print(result[i][j]);
                if(j!=M-1) System.out.print(" ");
            }
            System.out.println();
        }

    }

    private static void BFS(int startR, int startC) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{startR,startC});
        result[startR][startC] = 0;
        int size = queue.size();
        int cnt = 1;
        while(!queue.isEmpty()){
            if (size == 0){
                size = queue.size();
                cnt++;
            }
            int[] temp =  queue.poll();
            int r = temp[0];
            int c = temp[1];
            size--;
            for(int i=0;i<4;i++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                if(!check(nr,nc)) continue;
                if(result[nr][nc] == -1 && map[nr][nc] == 1){
                    result[nr][nc] = cnt;
                    queue.offer(new int[]{nr,nc});
                }
            }
        }
    }


    private static boolean check(int r,int c){
        return r>=0 && r<N && c>=0 && c<M;
    }
}
