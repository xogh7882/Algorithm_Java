import java.util.*;

class Solution {
    public int solution(int sticker[]) {
        int answer = 0;
        
        int N = sticker.length;
        
        if(N==1) answer = sticker[0];
        
        else if(N==2){
            answer = Math.max(sticker[0], sticker[1]);
        }
        
        else{
            // 0번 스티커 가져가기
            int[] dp = new int[N];
            dp[0] = sticker[0];
            dp[1] = sticker[0];
            
            for(int i=2;i<N-1;i++){  // 마지막꺼 못가져감 (0번이랑 붙어있어서)
                dp[i] = Math.max(dp[i-1], dp[i-2] + sticker[i]);
            }
            
            
            // 0번 스티커 안가져가기
            int[] dp2 = new int[N];
            dp2[0] = 0;
            dp2[1] = sticker[1];
            
            for(int i=2;i<N;i++){ // 마지막꺼 가능
                dp2[i] = Math.max(dp2[i-1], dp2[i-2] + sticker[i]);
            }
            
            answer = Math.max(dp[N-2], dp2[N-1]);
        }
        
        

        return answer;
    }
}