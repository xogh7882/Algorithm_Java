import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int H,W;
    static int map[][];
    static int result = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        map = new int[H][W];

        st = new StringTokenizer(br.readLine());
        for(int j=0;j<W;j++){
            int k = Integer.parseInt(st.nextToken());
            for(int i=0;i<k;i++){
                map[H-1-i][j] = 1;
            }
        }

        for(int i=0;i<H;i++){
            for(int j=0;j<W;j++){
                if(map[i][j] == 0){
                    if(checkWater(i,j)){
                        map[i][j] = 2;
                        result++;
                    }
                }
            }
        }

        System.out.println(result);
    }

    private static boolean checkWater(int i, int j){
        int r = i;
        int c = j;
        while(true){
            c--;
            if(c<0) return false;
            if(map[r][c] != 0) break;
        }
        c = j;
        while(true){
            c++;
            if(c==W) return false;
            if(map[r][c] != 0) break;
        }
        return true;


    }
}
