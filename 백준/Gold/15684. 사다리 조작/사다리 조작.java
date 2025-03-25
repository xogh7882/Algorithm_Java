
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N,M,H;
    static int map[][];
    static boolean result;
    static int resultValue;
    static int count;
    static int t = 1;
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        
        map = new int[H+1][N+2];   // N+2 : 왼쪽 오른쪽 공간 두기
        
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            map[a][b] = t;
            map[a][b+1] = t;
            t++;
        }
        
//        printMap();
        resultValue = -1;
        
        // 각 자리에서 내려갔을때 자기자리 나오는지 확인하는 함수 만들고
        // 사다리 Combi(1) , Combi(2) , Combi(3) 돌리기
        result = check();
        if(result == true) resultValue = 0;
        else {
            for(int i=1;i<=3;i++) {
                count = i;
                combi(0,1);
                if(result == true) {
                    resultValue = count;
                    break;
                }
            }
        }
        

        
        System.out.println(resultValue);
    }


    private static void combi(int cnt, int startR) {
        if(result == true) return;
        
        if(cnt==count) {
            if(check()==true) result = true;
            //printMap();
            return;
        }
        for(int i=startR; i<=H ;i++) {
            for(int j=0; j<N;j++) {
                if(map[i][j] == 0 && map[i][j+1] == 0) {
                    map[i][j] = cnt+t;
                    map[i][j+1] = cnt+t;
                    combi(cnt+1, i);
                    map[i][j+1] = 0;
                    map[i][j] = 0;
                }
            }
        }
    }


    private static boolean check() {
        int r,c;
        for(int i=1;i<=N;i++) {
            r = 1;
            c = i;
            
            while(true) {
                if(r>H) break;
                
                if(map[r][c] == 0) {
                    r++;
                }
                else {
                    int k = map[r][c];
                    if(map[r][c+1] == k) {
                        r++;
                        c++;
                    }
                    else {
                        r++;
                        c--;
                    }
                }
            }
            
            if(c!=i) return false;
        }

        return true;
        
    }

    private static void printMap() {
        System.out.println("=============PrintMap==============");
        for(int i=1;i<=H;i++) {
            for(int j=1;j<=N;j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
