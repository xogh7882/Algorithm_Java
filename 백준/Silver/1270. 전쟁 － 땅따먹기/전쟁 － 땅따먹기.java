import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            String max = null;
            int count = 0;
            HashMap<String, Integer> map = new HashMap<>();
            for(int j=0;j<m;j++){
                String now = st.nextToken();
                if(!map.containsKey(now)){
                    map.put(now, 1);
                }
                else{
                    map.put(now, map.get(now)+1);
                }
                if(map.get(now) > count){
                    count = map.get(now);
                    max = now;
                }
            }
            if (count > m / 2) {
                sb.append(max).append("\n");
            }
            else{
                sb.append("SYJKGW").append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}
