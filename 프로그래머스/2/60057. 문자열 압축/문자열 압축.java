import java.util.*;

class Solution {
    public int solution(String s) {
        int k=0;
        int answer=s.length();//개수 최솟값
        int finalAns=0;//개수
        
        int i=0;
        for(int t=1;t<=s.length()/2;t++){//t는 압축 단위
            
            StringBuilder sb=new StringBuilder();
            
            int cnt=1;//연속해서 나오는 개수
            String bf=s.substring(0,t);
            
            for(i=t;i<=s.length()-t;i+=t){
                if(bf.equals(s.substring(i,i+t))){
                    cnt++;
                }else{//이전꺼랑 달라지면
                    if(cnt>=2){
                        sb.append(cnt);
                    }
                    sb.append(bf);
                    cnt=1;//연속 개수 초기화
                }
                bf=s.substring(i,i+t);
            }
            
            if(cnt>=2){
                sb.append(cnt);
            }
            sb.append(bf);
            
            
            if(i<s.length()){
                sb.append(s.substring(i));
            }
            
            finalAns=sb.length();
            
            if(answer>finalAns){
                answer=finalAns;
            }
        }
        
        return answer;
    }
}