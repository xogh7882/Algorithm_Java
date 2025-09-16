import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    static int T;
    static int N;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            String temp = "1";
            DFS(N, 2, temp);
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    private static void DFS(int N, int now, String result) {
        if(now > N){
            if(calc(result)) sb.append(result).append("\n");
            return;
        }

        for(int i=0;i<3;i++){
            if(i==1){  // +
                result = result + "+" + Integer.toString(now);
                DFS(N, now+1, result);
                result = result.substring(0, result.length()-2);
            }
            else if(i==2){  // -
                result = result + "-" + Integer.toString(now);
                DFS(N, now+1, result);
                result = result.substring(0, result.length()-2);
            }
            else if(i==0){ // 숫자 이어 붙이기
                result = result + " " + Integer.toString(now);
                DFS(N, now+1, result);
                result = result.substring(0, result.length()-2);
            }
        }
    }

    private static boolean calc(String str){
        int sum = 0;
        int flag = 0;
        int temp = 0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='+'){
                if(flag==0) sum += temp;
                else sum -= temp;
                temp = 0;
                flag = 0;
            }
            else if(str.charAt(i)=='-'){
                if(flag==0) sum += temp;
                else sum -= temp;
                temp = 0;
                flag = 1;
            }
            else if(str.charAt(i)==' '){
                temp *=10;
            }
            else{
                temp += Integer.parseInt(str.charAt(i)+"");
            }
        }
        if(flag==0) sum += temp;
        else sum -= temp;

        if(sum==0) return true;
        else return false;
    }
}
