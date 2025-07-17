import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static char map[][];
    static int result = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new char[10][10];
        for(int i=0;i<10;i++){
            String str = br.readLine();
            for(int j=0;j<10;j++){
                map[i][j] =  str.charAt(j);
            }
        }

        aa:for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                if(map[i][j] == '.'){
                    if(canwin(i,j) == true){
                        result = 1;
                        break aa;
                    }
                }
            }
        }

        System.out.println(result);

    }

    private static boolean canwin(int r, int c) {
        boolean result = false;
        map[r][c] = 'X';

        if(check1(r,c) >= 5) result = true;
        if(check2(r,c) >= 5) result = true;
        if(check3(r,c) >= 5) result = true;
        if(check4(r,c) >= 5) result = true;

        map[r][c] = '.';
        return result;
    }

    private static int check1(int r, int c) {
        int cnt = 1;
        int nr = r;
        while(true){
            nr--;
            if(!check(nr,c) || map[nr][c] != 'X') break;
            cnt++;
        }
        nr = r;
        while(true){
            nr++;
            if(!check(nr,c) || map[nr][c] != 'X') break;
            cnt++;
        }

        return cnt;
    }

    private static int check2(int r, int c) {
        int cnt = 1;
        int nc = c;
        while(true){
            nc--;
            if(!check(r,nc) || map[r][nc] != 'X') break;
            cnt++;
        }

        nc = c;
        while(true){
            nc++;
            if(!check(r,nc) || map[r][nc] != 'X') break;
            cnt++;
        }

        return cnt;
    }

    private static int check3(int r, int c) {
        int cnt = 1;
        int nr = r;
        int nc = c;
        while(true){
            nr--;
            nc--;
            if(!check(nr,nc) || map[nr][nc] != 'X') break;
            cnt++;
        }
        nr = r;
        nc = c;
        while(true){
            nr++;
            nc++;
            if(!check(nr,nc) || map[nr][nc] != 'X') break;
            cnt++;
        }

        return cnt;
    }

    private static int check4(int r, int c) {
        int cnt = 1;
        int nr = r;
        int nc = c;
        while(true){
            nr++;
            nc--;
            if(!check(nr,nc) || map[nr][nc] != 'X') break;
            cnt++;
        }
        nr = r;
        nc = c;
        while(true){
            nr--;
            nc++;
            if(!check(nr,nc) || map[nr][nc] != 'X') break;
            cnt++;
        }

        return cnt;
    }


    private static boolean check(int r, int c) {
        return r>=0 && r<10 && c>=0 && c<10;
    }

}
