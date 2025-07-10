import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int P[];
    static int S[];
    static int now[];
    static int start[];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        P = new int[N];
        S = new int[N];
        now = new int[N];
        start = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            P[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<N;i++){
            now[i] = i;
            start[i] = i;
        }

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            S[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;
        while(true){
//            System.out.println("result : " + result);
//            System.out.println("now : " + Arrays.toString(now));

            if(isEnd(now) == true){
                break;
            }
            suffled();
            result++;

            if(isStart(now) == true){
                result = -1;
                break;
            }

        }
        System.out.println(result);
    }

    private static void suffled() {
        int current[] = new int[N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(S[j] == i){
                    current[i] = now[j];
                }
            }
        }
        now = current;
        return;
    }

    private static boolean isEnd(int[] now) {
        int cnt = 0;
        for(int i=0;i<N;i++){
            int t = P[i];
            for(int j=t;j<N;j=j+3){

                if(now[j] == i) {
                    cnt++;
                }
            }
        }
        if(cnt == N) return true;
        else return false;
    }

    private static boolean isStart(int[] now) {
        for(int i=0;i<N;i++){
            if(now[i] != start[i]) return false;
        }
        return true;
    }
}
