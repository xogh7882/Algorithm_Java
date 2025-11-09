import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int P[];
    static int result = 0;
    static int delay = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        P = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            P[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(P);
        for(int i=0;i<N;i++){
            if(i==0){
                delay = P[i];
                result += P[i];
            }
            else{
                delay = delay += P[i];
                result += delay;
            }
        }
        System.out.println(result);
    }
}

