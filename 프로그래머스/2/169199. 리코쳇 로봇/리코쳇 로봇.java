import java.util.*;

class Solution {
    
    static int dr[] = {0,0,1,-1};
    static int dc[] = {1,-1,0,0};
    static int map[][];
    static boolean visited[][];
    static int N,M;
    
    public int solution(String[] board) {
        
        N = board.length;
        M = board[0].length();
        
        map = new int[N][M];
        visited = new boolean[N][M];
        
        int startR = -1;
        int startC = -1;
        
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                char ch = board[i].charAt(j);
                if(ch == 'R'){
                    startR = i;
                    startC = j;
                }
                else if(ch == 'D'){
                    map[i][j] = 1;
                }
                else if(ch == 'G'){
                    map[i][j] = 2;
                }
                else continue;
            }
        }
        
        // printMap();
        
        Queue<int[]> queue = new ArrayDeque<int[]>();
        queue.offer(new int[]{startR, startC, 0});
        visited[startR][startC] = true;
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int nowR = cur[0];
            int nowC = cur[1];
            int nowCnt = cur[2];
            
            for(int i=0;i<4;i++){
                int nr = nowR;
                int nc = nowC;
                while(true){
                    int tempR = nr + dr[i];
                    int tempC = nc + dc[i];
                    if(!check(tempR, tempC) || map[tempR][tempC] == 1) break;
                    
                    nr = tempR;
                    nc = tempC;
                }
                
                if(visited[nr][nc]) continue;
                
                if(map[nr][nc] == 2) return nowCnt+1;
                
                visited[nr][nc] = true;
                queue.offer(new int[]{nr,nc,nowCnt+1});
            }
        }
        
        return -1;
    }
    
    private static boolean check(int r, int c){
        return r>=0 && r<N && c>=0 && c<M;
    }
    
    private static void printMap(){
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
    
}