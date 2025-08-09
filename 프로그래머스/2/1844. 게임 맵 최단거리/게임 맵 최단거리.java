import java.util.*;

class Solution {
    static int finishR, finishC;
    static int[] dr = {0,1,0,-1};
    static int[] dc = {1,0,-1,0};
    static boolean[][] visited;
    static int N,M;
    static int result = 1;
    
    public int solution(int[][] maps) {
        N = maps.length;
        M = maps[0].length;
        finishR = maps.length -1;
        finishC = maps[0].length - 1;
        visited = new boolean[maps.length][maps[0].length];
        
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0,0});
        
        int size = queue.size();
        
        while(!queue.isEmpty()){
            if(size == 0){
                result++;
                size = queue.size();
            }
            
            int[] temp = queue.poll();
            int r = temp[0];
            int c = temp[1];
            size--;
            
            if(r==finishR && c==finishC) return result;
            
            for(int i=0;i<4;i++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                
                if(check(nr,nc) == false) continue;
                
                if(visited[nr][nc] == false && maps[nr][nc] == 1){
                    visited[nr][nc] = true;
                    queue.offer(new int[]{nr,nc});
                }
            }
            
        }

        return -1;
    }
    
    
    private boolean check(int r, int c){
        return r>=0 && c>=0 && r<N && c<M;
    }
}