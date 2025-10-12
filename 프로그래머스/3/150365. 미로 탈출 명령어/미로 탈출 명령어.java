import java.util.*;
import java.io.*;

class Solution {
    static String answer = "NONE";
    static int N,M,R,C,K;
    static int dr[] = {1,0,0,-1};
    static int dc[] = {0,-1,1,0};
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        N = n;
        M = m;
        R = r;
        C = c;
        K = k;
        
        int fast = Math.abs(x-r) + Math.abs(y-c);
        
        if((K-fast)%2==1){
            answer = "impossible";
            return answer;
        }
    
        DFS(x,y,"",0);
        
        if(answer.equals("NONE")) answer = "impossible";
        return answer;
    }
    
    private static void DFS(int x, int y, String ans, int step){
        
        int fastWay = Math.abs(x-R) + Math.abs(y-C);
        
        if(fastWay + step > K || !answer.equals("NONE")) return;
        
        if(x==R && y==C && step==K && answer.equals("NONE")){
            answer = ans;
            return;
        }
        
        for(int i=0;i<4;i++){
            int nr = x + dr[i];
            int nc = y + dc[i];
            
            if(!check(nr,nc)) continue;
            
            if(i==0) DFS(nr,nc,ans+"d", step+1);
            else if(i==1) DFS(nr,nc,ans+"l", step+1);
            else if(i==2) DFS(nr,nc,ans+"r", step+1);
            else if(i==3) DFS(nr,nc,ans+"u", step+1);
        }
        
        
    }
    
    private static boolean check(int r, int c){
        return r>=1 && r<=N && c>=1 && c<=M;
    }
}