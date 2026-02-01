import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int map[][];
    static int result = 0;

    // 왼 -> 아래 -> 오 -> 위

    static int[] dr = {0,1,0,-1};
    static int[] dc = {-1,0,1,0};


    static int moveR[][] = {
            {0,-1,1,-2,-1,1,2,-1,1,0},
            {2,1,1,0,0,0,0,-1,-1,1},
            {0,1,-1,2,1,-1,-2,1,-1,0},
            {-2,-1,-1,0,0,0,0,1,1,-1}
    };

    static int moveC[][] = {
            {-2,-1,-1,0,0,0,0,1,1,-1},
            {0,-1,1,-2,-1,1,2,-1,1,0},
            {2,1,1,0,0,0,0,-1,-1,1},
            {0,1,-1,2,1,-1,-2,1,-1,0}
    };

    static double percent[] = { 0.05, 0.1, 0.1, 0.02, 0.07, 0.07, 0.02, 0.01, 0.01 };


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int startR = (N-1)/2;
        int startC = (N-1)/2;
        int nowD = 0;

        int cnt = 0;
        int nowCount = 1;

        while(true){
            if(startR == 0 && startC == 0) break;

            int nr = startR + dr[nowD];
            int nc = startC + dc[nowD];

            // logic
            int totalSand = map[nr][nc];
            map[nr][nc] = 0;

            int removeSand = 0;
            for(int i=0;i<9;i++){
                int x = nr + moveR[nowD][i];
                int y = nc + moveC[nowD][i];

                if(!check(x,y)){
                    int temp = (int)(totalSand * percent[i]);
                    removeSand += temp;
                    result += temp;
                }

                else{
                    int temp = (int)(totalSand * percent[i]);
                    removeSand += temp;
                    map[x][y] += temp;
                }
            }
            int x = nr + moveR[nowD][9];
            int y = nc + moveC[nowD][9];

            int temp = totalSand - removeSand;

            if(!check(x,y)) result += temp;
            else map[x][y] += temp;

            startR = nr;
            startC = nc;


            cnt++;  // 한칸 이동
            if(cnt == nowCount){  // 이번 라인에 이동해야할 칸만큼 이동했다면?
                nowD++;
                cnt = 0;

                if(nowD % 2 ==0){
                    nowCount++;
                    if(nowD == 4) nowD = 0;
                }
            }

        }



        System.out.println(result);
    }


    private static boolean check(int r, int c){
        return r>=0 && r<N && c>=0 && c<N;
    }


    private static void printMap(){
        System.out.println("-----------------------------------");
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

}
