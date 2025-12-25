import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] map;

    static int I;
    static int startR, startC;
    static int endR, endC;
    static int result;

    static int[] dr = {-2,-1,1,2,2,1,-1,-2};
    static int[] dc = {-1,-2,-2,-1,1,2,2,1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int testCase=1 ; testCase<=T; testCase++){
            I = Integer.parseInt(br.readLine());
            map = new boolean[I][I];

            st = new StringTokenizer(br.readLine());
            startR = Integer.parseInt(st.nextToken());
            startC = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            endR = Integer.parseInt(st.nextToken());
            endC = Integer.parseInt(st.nextToken());

            result = 0;

            result = findWay(startR, startC, endR, endC);

            sb.append(result).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static int findWay(int startR, int startC, int endR, int endC){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{startR, startC, 0});
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int curR = cur[0];
            int curC = cur[1];
            int curCount = cur[2];

            if(curR == endR && curC == endC){
                return curCount;
            }

            for(int i=0;i<8;i++){
                int nr = curR + dr[i];
                int nc = curC + dc[i];

                if(!check(nr,nc) || map[nr][nc]) continue;

                map[nr][nc] = true;
                queue.offer(new int[]{nr,nc,curCount+1});
            }
        }
        return -1;
    }

    private static boolean check(int r, int c){
        return r>=0 && r<I && c>=0 && c<I;
    }
}
