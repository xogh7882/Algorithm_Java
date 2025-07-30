import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int N,M;
    static int map[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        N = 0;
        M = 0;
        map = new int[str.length()];

        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='0'){
                N++;
                map[i] = 0;
            }
            else {
                M++;
                map[i] = 1;
            }
        }
        N /= 2;
        M /= 2;

        int start = 0;
        int flag = 0;
        while(true){
            if(flag == M) break;
            if(map[start] == 1){
                map[start] = -1;
                flag++;
            }
            start++;
        }

        start = str.length()-1;
        flag = 0;
        while(true){
            if(flag==N) break;
            if(map[start]==0){
                map[start] = -1;
                flag++;
            }
            start--;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<str.length();i++){
            if(map[i] != -1){
                sb.append(map[i]);
            }
        }

        System.out.println(sb.toString());

    }
}
