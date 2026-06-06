import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {

        int N = sequence.length;
        
        int left = 0;
        int right = 0;
        
        int resultL = 0;
        int resultR = N-1;
        
        
        int sum = sequence[0];
        
        while(left < N && right < N){
            int temp = sum;
            
            if(temp == k){
                if(right - left < resultR - resultL){
                    resultL = left;
                    resultR = right;
                }
                
                sum -= sequence[left];
                left++;
            }
            
            else if(temp > k){
                sum -= sequence[left];
                left++;
            }
            
            else{
                right++;
                
                if(right < N){
                    sum += sequence[right];
                }
            }
            
        }
        
        int[] answer = {resultL, resultR};
       
        return answer;
    }
}