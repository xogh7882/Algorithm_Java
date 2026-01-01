import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[] map;
    static int[] select;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N];
        select = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            map[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(map);

        findArr(0);

        System.out.println(sb.toString());
    }

    private static void findArr(int cnt){
        if(cnt == M){
            for(int i=0;i<M;i++){
                sb.append(select[i]);
                if(i!=M-1) sb.append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=0;i<N;i++){
            select[cnt] = map[i];
            findArr(cnt+1);
            select[cnt] = -1;
        }
    }
}
