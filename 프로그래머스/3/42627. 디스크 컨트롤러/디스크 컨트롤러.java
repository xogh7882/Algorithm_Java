import java.util.*;

class Solution {
    static class Work{
        int n;
        int s;
        int p;
        public Work(int n,int s,int p){
            this.n=n;//작업 번호
            this.s=s;//작업 요청 시각
            this.p=p;//작업 소요 시간
        }
    }
    public int solution(int[][] jobs) {
        
        Comparator<Work>comp=new Comparator<>(){
            public int compare(Work w1,Work w2){
                if(w1.p!=w2.p) return Integer.compare(w1.p,w2.p);
                if(w1.s!=w2.s) return Integer.compare(w1.s,w2.s);
                return Integer.compare(w1.n,w2.n);
            }
        };
        
        PriorityQueue<Work>pq=new PriorityQueue<>(comp);
            
        int curT=0;
        int banhwan=0;//반환 시간 누적
        
        int cnt=0;//처리 완료한 작업 수
        boolean[] done=new boolean[jobs.length];
        
        while(cnt<jobs.length){
            //전체 jobs 훑으면서 현재 초보다 요청 시각이 작거나(먼저) 같으면 대기큐로
            for(int i=0;i<jobs.length;i++){
                Work w=new Work(i,jobs[i][0],jobs[i][1]);
                
                if(!done[i] && w.s<=curT){
                    pq.offer(w);
                    done[i]=true;
                }
            }

            if(!pq.isEmpty()){//대기 큐가 비어있지 않으면 뽑고 그 시간만큼 실행
                Work cur=pq.poll();

                curT+=cur.p;
                banhwan+=(curT-cur.s); 
                
                cnt++;
            }else{//대기큐가 비어있으면 
                curT++;//아직 요청도 없고 대기큐도 비어있으면 시간 1초 흘려보내기 
            }
        }
        
        return banhwan/(jobs.length);
    }
}