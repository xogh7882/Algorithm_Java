import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        
        int L = 0;
        int std = (2*w)+1;
        
        for(int i=0;i<stations.length;i++){
            int temp = stations[i];
            
            int left = temp - w;
            int right = temp + w;
           
            if(left - L <= 1){
                L = right;
            }
            else{
                int k = left - L - 1;
                int a = k / std;
                int b = k % std;
                
                // System.out.println("k : " + k + " | a : " + a + " | b : " + b);
                
                answer += a;
                if(b!=0) answer++;
                
                L = right;
            }
            
            
            
            if(i==stations.length-1){
                left = n+1;
                
                if(left - L <= 1) continue;
                else{
                    int k = left - L - 1;
                    int a = k / std;
                    int b = k % std;

                    // System.out.println("k : " + k + " | a : " + a + " | b : " + b);

                    answer += a;
                    if(b!=0) answer++;
                }
                
            }
            
            // System.out.println("temp : " + temp + " | " + "answer : " + answer);

        }
        
        return answer;
    }
}