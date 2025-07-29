import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int map[][];
    static int result = 22;
    static int flag = -1;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        map = new int[6][7];

        for(int t = 1 ; t <= 21; t++)
        {
//            printMap();

            st = new StringTokenizer(br.readLine());
            int s =  Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            if( result != 22 ) continue;

            goDown(s-1,1);

            if(isWin(1)){
                result = t;
                flag = 1;
                continue;
            }

            goDown(j - 1, 2);

            if (isWin(2)) {
                result = t;
                flag = 2;
            }

        }

        if(flag == -1) System.out.println("ss");
        else if(flag==1) System.out.println("sk " + result);
        else System.out.println("ji " + result);

    }

    private static void goDown(int s, int me) {
        int r = 0;
        int c = s;
        while(true){
            if(!check(r+1,c) || map[r+1][c] != 0) break;
            r++;
        }
        map[r][c] = me;
    }

    private static boolean check(int r,int c){
        return r>=0 && r<6 && c>=0 && c<7;
    }

    private static boolean isWin(int me){
        for(int i = 0 ; i < 6 ; i++){
            for(int j = 0 ; j < 7 ; j++){
                if(map[i][j] == me){
                    if(check1(i,j,me) >= 4) return true;
                    if(check2(i,j,me) >= 4) return true;
                    if(check3(i,j,me) >= 4) return true;
                    if(check4(i,j,me) >= 4) return true;
                }
            }
        }
        return false;
    }

    private static int check1(int r, int c, int me) {
        int cnt = 1;
        int nr = r;
        while(true){
            nr--;
            if(!check(nr,c) || map[nr][c] != me) break;
            cnt++;
        }
        nr = r;
        while(true){
            nr++;
            if(!check(nr,c) || map[nr][c] != me) break;
            cnt++;
        }

        return cnt;
    }

    private static int check2(int r, int c, int me) {
        int cnt = 1;
        int nc = c;
        while(true){
            nc--;
            if(!check(r,nc) || map[r][nc] != me) break;
            cnt++;
        }

        nc = c;
        while(true){
            nc++;
            if(!check(r,nc) || map[r][nc] != me) break;
            cnt++;
        }
        return cnt;
    }

    private static int check3(int r, int c, int me) {
        int cnt = 1;
        int nr = r;
        int nc = c;
        while(true){
            nr--;
            nc--;
            if(!check(nr,nc) || map[nr][nc] != me) break;
            cnt++;
        }
        nr = r;
        nc = c;
        while(true){
            nr++;
            nc++;
            if(!check(nr,nc) || map[nr][nc] != me) break;
            cnt++;
        }

        return cnt;
    }

    private static int check4(int r, int c, int me) {
        int cnt = 1;
        int nr = r;
        int nc = c;
        while(true){
            nr++;
            nc--;
            if(!check(nr,nc) || map[nr][nc] != me) break;
            cnt++;
        }
        nr = r;
        nc = c;
        while(true){
            nr--;
            nc++;
            if(!check(nr,nc) || map[nr][nc] != me) break;
            cnt++;
        }

        return cnt;
    }

 

}
