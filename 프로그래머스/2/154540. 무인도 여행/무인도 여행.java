import java.util.*;

class Solution {
    static int N,M;
    public int[] solution(String[] maps) {

        
        N = maps.length;
        M = maps[0].length();
        
        int map[][] = new int[N][M];
        
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(maps[i].charAt(j) == 'X') continue;
                else{
                    map[i][j] = maps[i].charAt(j) - '0';
                }
            }
        }
        
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        boolean visited[][] = new boolean[N][M];
        int dr[] = {0,0,1,-1};
        int dc[] = {1,-1,0,0};
        
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(!visited[i][j] && map[i][j] != 0){
                    Queue<int[]> queue = new ArrayDeque<int[]>();
                    queue.offer(new int[]{i,j});
                    visited[i][j] = true;
                    int sum = 0;
                    while(!queue.isEmpty()){
                        int[] cur = queue.poll();
                        int r = cur[0];
                        int c = cur[1];
                        
                        sum += map[r][c];
                        
                        for(int d=0;d<4;d++){
                            int nr = r + dr[d];
                            int nc = c + dc[d];
                            
                            if(!check(nr,nc) || visited[nr][nc] || map[nr][nc] == 0) continue;
                            
                            visited[nr][nc] = true;
                            queue.offer(new int[]{nr,nc});
                        }
                    }
                    list.add(sum);
                }
            }
        }
        
        Collections.sort(list);
        
        if(list.size() == 0) {
            int[] answer = {-1};
            return answer;
        }
        else{
            int[] answer = new int[list.size()];
            for(int i=0;i<list.size();i++){
                answer[i] = list.get(i);
            }
            return answer;
        }
    }
        
    
    private static boolean check(int r, int c){
        return r>=0 && r<N && c>=0 && c<M;
    }

}