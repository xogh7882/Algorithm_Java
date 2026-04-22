import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i=0;i<clothes.length;i++){
            if(map.containsKey(clothes[i][1])){
                int value = map.get(clothes[i][1]);
                map.put(clothes[i][1], value+1);
            }
            else{
                map.put(clothes[i][1], 1);
            }
        }
        
        for(String str : map.keySet()){
            answer *= (map.get(str)+1);
        }
        
        return answer-1;
    }
}