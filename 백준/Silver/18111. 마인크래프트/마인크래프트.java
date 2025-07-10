import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,M,B;
    static int map[][];
    static int max = -1;
    static int min = 257;
    static int time = Integer.MAX_VALUE;
    static int height = -1;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max,map[i][j]);
                min = Math.min(min,map[i][j]);
            }
        }

        for(int i=min;i<=max;i++){
            check(i);
        }

        System.out.println(time + " " + height);

    }

    private static void check(int nowheight){
        int nowtime = 0;

        int usebox = 0;
        int deletebox = 0;

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                // 높이가 같으면 패스
                if(map[i][j] == nowheight) continue;

                // 기준 높이가 더 높으면
                else if(nowheight > map[i][j]){
                    usebox += nowheight - map[i][j];
                    nowtime += (nowheight-map[i][j]);
                }

                // 기준 높이가 더 낮으면
                else{
                    deletebox += map[i][j] - nowheight;
                    nowtime += (map[i][j] - nowheight)*2;
                }
            }
        }

        if(B - usebox + deletebox >= 0) {
            if(nowtime < time){
                time = nowtime;
                height = nowheight;
            }

            else if(nowtime == time){
                if(nowheight > height){
                    height = nowheight;
                }
            }

            else return;
        }

    }

}
