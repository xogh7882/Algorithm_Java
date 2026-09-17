import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer>pq=new PriorityQueue<>();
        
        for(int s:scoville){
            pq.offer(s);
        }
        
        int answer = 0;
        int n=0;
        
        while(pq.size()>=2){
            int c1=pq.poll();
            
            if(c1>=K) break;
            
            int c2=pq.poll();

            n=c1+(c2*2);
            
            pq.offer(n);
            answer++;
        }
        
        if(pq.peek()<K) return -1;
        
        return answer;
    }
}