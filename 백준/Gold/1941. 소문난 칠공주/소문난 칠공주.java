import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class Main {
    static boolean[][] map;
    static int N;
    static int[] select;
    static boolean[] visited;
    static int result = 0;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = 5;

        map = new boolean[N][N];
        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < N; j++){
                if(str.charAt(j) == 'S') map[i][j] = true;
                else map[i][j] = false;
            }
        }

        // true = S  |  false = Y   ( S가 4개 이상 )
        // 25 C 7 ?
        visited = new boolean[25];
        select = new int[7];

        combi(0,0);
        System.out.println(result);
    }

    private static void combi(int start, int count){
        if(count == 7){
            if(isPossible()) result++;
            return;
        }
        for(int i=start;i<25;i++){
            if(visited[i]) continue;
            visited[i] = true;
            select[count] = i;
            combi(i+1, count+1);
            visited[i] = false;
        }
    }

    private static boolean isPossible(){
        Set<Integer> set = new HashSet<>();
        Queue<int[]> queue = new ArrayDeque<>();

        int r = select[0] / 5;
        int c = select[0] % 5;

        queue.offer(new int[]{r,c});

        for(int i=1;i<7;i++){
            set.add(select[i]);
        }

        int cnt = 0;
        int sNum = 0;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int curR = cur[0];
            int curC = cur[1];
            if(map[curR][curC]) sNum++;

            cnt++;

            for(int i=0;i<4;i++){
                int nr = curR + dr[i];
                int nc = curC + dc[i];

                if(!check(nr,nc)) continue;

                if(set.contains((nr*5) + nc)){
                    set.remove(nr*5 + nc);
                    queue.offer(new int[]{nr,nc});
                }

            }
        }

        if(cnt == 7 && sNum >= 4) return true;

        return false;
    }

    private static boolean check(int r, int c){
        return r>=0 && r<N && c>=0 && c<N;
    }
}
