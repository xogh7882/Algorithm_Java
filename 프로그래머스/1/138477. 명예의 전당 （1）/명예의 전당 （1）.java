import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int answer[] = new int[score.length];
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        
        for(int i=0;i<score.length;i++){
            if(pq.size() < k){
                pq.offer(score[i]);
            }
            else{
                if(pq.peek() < score[i]){
                    pq.poll();
                    pq.offer(score[i]);
                }
            }
            
            answer[i] = pq.peek();
        }
        
        
        
        
        return answer;
    }
}