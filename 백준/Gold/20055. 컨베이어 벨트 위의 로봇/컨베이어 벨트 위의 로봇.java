import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static int N,K;
    static int count[];
    static boolean isRobot[];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 1-2N까지 배열을 컨베이어 벨트라고 생각하자
        count = new int[(2*N) + 1];
        isRobot = new boolean[(2*N) + 1];
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=2*N;i++){
            count[i] = Integer.parseInt(st.nextToken());
        }

        int step = 1;

        int up = 1;
        int down = N;

        while(true){
            // 1. 벨트가 각 칸 위에 있는 로봇과 함께 한칸 이동한다
            up--;
            if(up==0) up = 2*N;
            down--;
            if(down==0) down = 2*N;

            if(isRobot[down]) isRobot[down] = false;

            // 2. 가장 먼저 벨트에 올라간 로봇부터, 한칸 이동
            int cur = down-1;
            if(cur==0) cur = 2*N;

            for(int i=0;i<N-1;i++) {
                int next = cur + 1;
                if (next > 2*N) next = 1;
                if (isRobot[cur] && !isRobot[next] && count[next] > 0) {
                    isRobot[cur] = false;
                    isRobot[next] = true;
                    count[next]--;

                    if(next == down) isRobot[next] = false;
                }
                cur--;
                if(cur==0) cur = 2*N;
            }

            // 도착점에 로봇이 있으면 내린다
            if(isRobot[down]) isRobot[down] = false;

            // 3. 올리는 위치에 있는 칸의 내구도가 0이 아니면 올리는 위치에 로봇을 올린다
            if(count[up]>0){
                isRobot[up] = true;
                count[up]--;
            }


            // 4. 내구도가 0인 칸의 개수가 K개 이상이면 종료
            int cnt = 0;
            for(int i=1;i<=2*N;i++){
                if(count[i] == 0) cnt++;
            }
            if(cnt >= K) break;


            step++;
        }

        System.out.println(step);

    }


}
