import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;

public class Main {
    static Character[][] map;
    static HashMap<Character, int[]> hashMap = new HashMap<>();
    static int result = 0;
    static int dr[] = {0,0,-1,-1,1,1};
    static int dc[] = {-2,2,-1,1,-1,1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        map = new Character[3][19];

        String str = "QWERTYUIOP";
        for(int i=0;i<str.length();i++){
            map[0][i*2] = str.charAt(i);
            hashMap.put(str.charAt(i), new int[]{0,i*2});
        }

        str = "ASDFGHJKL";
        for(int i=0;i<str.length();i++){
            map[1][i*2+1] = str.charAt(i);
            hashMap.put(str.charAt(i), new int[]{1,i*2+1});
        }

        str = "ZXCVBNM";
        for(int i=0;i<str.length();i++){
            map[2][i*2+2] = str.charAt(i);
            hashMap.put(str.charAt(i), new int[]{2,i*2+2});
        }

//        printMap();

        int T = Integer.parseInt(br.readLine());
        int nowR, nowC;

        for(int t=1;t<=T;t++){
            str = br.readLine();
            result = 0;
            nowR = -1;
            nowC = -1;

            for(int i=0;i<str.length();i++){
                if(i==0){
                    int[] cur = hashMap.get(str.charAt(i));
                    nowR = cur[0];
                    nowC = cur[1];
                    result++;
//                    System.out.println(nowR + " " + nowC + " : " + Arrays.toString(hashMap.get(str.charAt(i))));
                }
                else{
                    int cur[] = hashMap.get(str.charAt(i));
                    int temp = findWay(nowR, nowC, cur[0], cur[1]);
                    result += temp*2;
                    nowR = cur[0];
                    nowC = cur[1];
                    result++;
//                    System.out.println(nowR + " " + nowC + " : " + Arrays.toString(hashMap.get(str.charAt(i))));
                }
            }
//            System.out.println(result);
            sb.append(result).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static int findWay(int nowR, int nowC, int curR, int curC) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{nowR, nowC, 0});

        boolean[][] visited = new boolean[map.length][map[0].length];
        visited[nowR][nowC] = true;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];
            int count = cur[2];

            if(r==curR && c==curC){
                return count;
            }

            for(int i=0;i<6;i++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                if(!check(nr,nc) || visited[nr][nc]) continue;

                visited[nr][nc] = true;
                queue.offer(new int[]{nr,nc,count+1});
            }
        }
        return 0;
    }

    private static boolean check(int r, int c){
        return r>=0 && r<map.length && c>=0 && c<map[0].length;
    }

    private static void printMap() {
        System.out.println("----------------Map----------------");
        for(int i=0;i<map.length;i++){
            for(int j=0;j<map[0].length;j++){
                if (map[i][j] == null) {
                    System.out.print(" ");
                }else {
                    System.out.print(map[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
