import java.util.*;

class Solution {
    static int DIV = 1234567;
    
    public long solution(int n) {
        long answer = 0;
        
        int sum[] = new int[n+1];
        sum[0] = 1;
        sum[1] = 1;
        
        if(n==1) return 1;
        
        for(int i=2;i<=n;i++){
            sum[i] = ((sum[i-2]%DIV) + (sum[i-1]%DIV))%DIV;
        }
        
        return sum[n];
    }
}