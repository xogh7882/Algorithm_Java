import java.util.*;

class Solution {
    static Character[] ch = {'A','E','I','O','U'};
    static int answer = 0;
    static int cnt = -1;
    
    public int solution(String word) {
        DFS("", word);
        return answer;
    }
    
    private static void DFS(String now, String word) {
        if(answer != 0) return;

        cnt++;

        if(now.equals(word)){
            answer = cnt;
            return;
        }

        if(now.length() >= 5) return;
        for(int i=0;i<5;i++){
            DFS(now+ch[i], word);

        }
    }
}