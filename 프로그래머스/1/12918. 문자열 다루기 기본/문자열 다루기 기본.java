class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        
        if(s.length()==4||s.length()==6){
            for(int i=0;i<s.length();i++){
                if(Character.isDigit(s.charAt(i))){
                    continue;
                }else{
                    answer=false;
                    return answer;
                }
            }
        }else{
            answer=false;
            return answer;
        }
        
        return answer;
        
    }
}