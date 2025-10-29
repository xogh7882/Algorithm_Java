import java.util.*;
import java.io.*;

class Solution {
    
    static int DIV = 1_000_000_007;
        
    public int solution(int m, int n, int[][] puddles) {
        int[][] map = new int[n][m];
        
        for(int i=0;i<puddles.length;i++){
            int r = puddles[i][0];
            int c = puddles[i][1];
            
            map[c-1][r-1] = -1;
        }
        
        map[0][0] = 1;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if((i==0 && j==0 ) || map[i][j] == -1) continue;
                else if(i==0){
                    if(map[i][j-1] != -1)
                        map[i][j] = map[i][j-1]%DIV;
                }
                else if(j==0){
                    if(map[i-1][j] != -1)
                        map[i][j] = map[i-1][j]%DIV;
                }
                else{
                    if(map[i][j-1] != -1 && map[i-1][j] != -1)
                        map[i][j] = ((map[i][j-1]%DIV) + (map[i-1][j]%DIV))%DIV;
                    else if(map[i][j-1] != -1)
                        map[i][j] = map[i][j-1]%DIV;
                    else if(map[i-1][j] != -1)
                        map[i][j] = map[i-1][j]%DIV;
                    else
                        continue;

                }
            }
        }
        return map[n-1][m-1];
        
    }
}