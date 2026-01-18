import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
        }

        // MST는 N-1 개의 간선으로 이루어짐 ( 1개 제거하면 갈라짐 )
        // 2개 제거했을때 분리되야함
        // 간선이 N개면 2개 제거하면 분리됨
        // 더 많으면? 임의로 2개 지웠을 때, 안되는 경우 생김

        if (M <= N) {
            System.out.println("Yes");
        }
        else{
            System.out.println("No");
        }

    }
}
