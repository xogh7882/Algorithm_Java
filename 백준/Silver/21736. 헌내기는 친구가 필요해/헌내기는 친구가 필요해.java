import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static char map[][];
    static int startR, startC;
    static int dr[] = {1,-1,0,0};
    static int dc[] = {0,0,1,-1};
    static int result = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];

        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j=0;j<M;j++){
                map[i][j] = str.charAt(j);
                if(map[i][j] == 'I'){
                    startR = i;
                    startC = j;
                }
            }
        }

        BFS(startR,startC);

        if(result==0) System.out.println("TT");
        else System.out.println(result);
    }

    private static void BFS(int nowR, int nowC){
        boolean visited[][] = new boolean[N][M];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{nowR,nowC});
        visited[nowR][nowC] = true;

        while(!queue.isEmpty()){
            int[] temp =  queue.poll();
            int r = temp[0];
            int c = temp[1];


            for(int i=0;i<4;i++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                if(check(nr,nc) == false) continue;
                if(visited[nr][nc] == false && map[nr][nc] != 'X'){
                    if(map[nr][nc] == 'P') result++;
                    visited[nr][nc] = true;
                    queue.offer(new int[]{nr,nc});
                }

            }

        }

    }

    private static boolean check(int r, int c){
        return r>=0 && r<N && c>=0 && c<M;
    }
}
