import java.util.*;

class Solution {
    
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for(String str : participant){
            if(map.containsKey(str)){
                int value = map.get(str);
                value++;
                map.put(str, value);
                
            }
            else{
                map.put(str, 1);
            }
        }
        

        
        for(String str : completion){
            int value = map.get(str);
            value--;
            if(value==0) map.remove(str);
            else{
                map.put(str, value);
            }
        }
        

        for(String str : map.keySet()){
            if(map.get(str) != 0){
                answer = str;
                break;
            }
        }

        return answer;
    }
    
    
}