import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        if(s.length() % 2 == 0){
            int temp = s.length()/2;
            answer += s.charAt(temp-1);
            answer += s.charAt(temp);
        }
        else{
            int temp = (s.length()-1) / 2;
            answer += s.charAt(temp);
        }
        
        return answer;
    }
}