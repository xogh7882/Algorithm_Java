import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int R,C;
    static int[][] map;
    static int winner = -1;

    static int[] dr = {-1,-1,-1,0,1,1,1,0};
    static int[] dc = {-1,0,1,1,1,0,-1,-1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        map = new int[7][7];

        map[3][3] = 1;  // 1 = white
        map[4][4] = 1;

        map[3][4] = 2;  // 2 = black
        map[4][3] = 2;


        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            move(R,C,i);

//            print();
        }

        winner = checkWinner();

        for(int i=1;i<=6;i++){
            for(int j=1;j<=6;j++){
                if(map[i][j] == 0) sb.append(".");
                else if(map[i][j] == 1) sb.append("W");
                else sb.append("B");
            }
            sb.append("\n");
        }

        if(winner == 1) sb.append("White");
        else sb.append("Black");

        System.out.println(sb.toString());
    }

    private static int checkWinner(){
        int blackCnt = 0;
        int whiteCnt = 0;

        for(int i=1;i<=6;i++){
            for(int j=1;j<=6;j++){
                if(map[i][j] == 1) whiteCnt++;
                else if(map[i][j] == 2) blackCnt++;
            }
        }

        if(blackCnt > whiteCnt) return 2;
        else return 1;
    }

    private static void move(int r, int c, int flag){
        if(flag%2==0){  // turn black
            flag = 2;
        }
        else flag = 1;  // turn white

        map[r][c] = flag;

        for(int i=0;i<8;i++){
            // 한쪽 방향으로 같은 색깔이 있는지 체크
            if(isSameColor(r,c,i)) {
                flip(r,c,i);
            }
            else continue;
        }

    }

    private static void flip(int r, int c, int i){
        int nowColor = map[r][c];
        int nr,nc;
        while(true){
            nr = r + dr[i];
            nc = c + dc[i];

            if(map[nr][nc] == nowColor) return;
            else{
                map[nr][nc] = nowColor;
                r = nr;
                c = nc;
            }

        }
    }

    private static boolean isSameColor(int r, int c, int i){
        int nowColor = map[r][c];
        int nr,nc;
        while(true){
            nr = r + dr[i];
            nc = c + dc[i];

            if(!check(nr,nc)) break;
            if(map[nr][nc] == nowColor) return true;
            else if(map[nr][nc] == 0) break;
            else{
                r = nr;
                c = nc;
            }
        }

        return false;
    }

    private static boolean check(int r, int c){
        return r>=1 && r<=6 && c>=1 && c<=6;
    }

    private static void print(){
        System.out.println("---------- Map ----------");
        for(int i=1;i<=6;i++){
            for(int j=1;j<=6;j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
