import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 0 ; test_case < T; test_case++){
            st = new StringTokenizer(br.readLine());
            int aSize = Integer.parseInt(st.nextToken());
            int bSize = Integer.parseInt(st.nextToken());

            int arr[] = new int[aSize];
            int brr[] = new int[bSize];

            st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i < aSize ; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i < bSize ; i++){
                brr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            Arrays.sort(brr);

            int aPivot = 0;

            int cnt = 0;

            while(true){
                if(aPivot == aSize) break;
                for(int i=bSize-1;i>=0;i--){
                    if(arr[aPivot] > brr[i]){
                        cnt += (i+1);
                        break;
                    }
                }
                aPivot++;
            }

            sb.append(cnt).append("\n");

        }
        System.out.println(sb.toString());
    }
}
