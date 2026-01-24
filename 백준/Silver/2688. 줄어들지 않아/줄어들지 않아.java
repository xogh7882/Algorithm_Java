import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int T, max;
    static long[][] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        int result[] = new int[T];
        max = -1;
        for(int i=0;i<T;i++){
            result[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, result[i]);
        }

        dp = new long[max+1][10];

        for(int i=1;i<=max;i++){
            if(i==1){
                for(int j=0;j<10;j++){
                    dp[i][j] = 1;
                }
            }
            else{
                for(int j=0;j<10;j++){
                    for(int k=0;k<=j;k++){
                        dp[i][j] += dp[i-1][k];
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        long answer = 0;
        for(int i=0;i<result.length;i++){
            answer = 0;
            for(int j=0;j<10;j++){
                answer += dp[result[i]][j];
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb.toString());
    }
}


/*
dp[몇자리수][뭘로시작]

N = 1
dp[1][0] = 1
dp[1][1] = 1
dp[1][2] = 1
dp[1][3] = 1
dp[1][4] = 1
dp[1][5] = 1
dp[1][6] = 1
dp[1][7] = 1
dp[1][8] = 1
dp[1][9] = 1

N = 2
dp[2][0] = dp[1][0] = 1
dp[2][1] = dp[1][0] + dp[1][1] = 2
dp[2][2] = dp[1][0] + dp[1][1] + dp[1][2] = 3


 */