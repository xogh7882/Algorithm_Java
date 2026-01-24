import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,K;
    static int[] W;
    static int[] V;

    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        W = new int[N+1];
        V = new int[N+1];

        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }


        dp = new int[N+1][K+1];

        for(int i=1;i<=N;i++){
            for(int j=0;j<=K;j++){
                if(j-W[i]>=0)
                    dp[i][j] = Math.max(dp[i-1][j], V[i] + dp[i-1][j-W[i]] );
                else
                    dp[i][j] = dp[i-1][j];
            }
        }

//        print();


        System.out.println(dp[N][K]);

    }

    private static void print(){
        System.out.println("--------------------------------------");
        for(int i=0;i<=N;i++){
            for(int j=0;j<=K;j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

}


/*

 최대 K만큼의 무게만을 너흘 수 있는 배낭
 -> 물건 가치의 최댓값

             ( K : 7 )
 W :      6   |   4   |   3   |   5
 V :      13  |   8   |   6   |   12

 순서대로 하나씩 담는다고 해보자


 dp[몇번까지 담았을때][이정도 무게가방] 최적으로 채우기 ( 가치 )
 dp[4][7] 을 구해야 한다

 */