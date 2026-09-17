import java.util.*;

class Solution {
    public int solution(String s) {
        int same=0;
        int diff=0;

        int cnt=0;
        
        Character c=s.charAt(0);
        
        for(int i=0;i<s.length();i++){
            if(c==s.charAt(i)){
                same++;
            }else{
                diff++;
            }

            if(same==diff){
                cnt++;
                
                same=0;
                diff=0;
                
                if(i<s.length()-1){
                    c=s.charAt(i+1);
                }
            }
        }
        
        if (same != 0 || diff != 0) {
            cnt++;
        }

        return cnt;
    }
}