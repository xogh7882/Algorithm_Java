import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        //| 숫자: 큐에 주어진 숫자 삽입
        //D 1: 큐에서 최댓값 삭제
        //D -1: 큐에서 최솟값 삭제
        
        //최댓값, 최솟값 동시에 삭제해야 하면 TreeSet
        //Comparator 오름차순
        //젤 앞에꺼가 |면 operations[i].charAt(operations[i].length()-1) 숫자 삽입
        //젤 앞에꺼가 D면 operations[i].charAt(operations[i].length()-1)가 -1이면 set.first()/ 1이면 set.last();
        
        Comparator<Integer>comp=new Comparator<Integer>(){
            public int compare(Integer i1,Integer i2){
                return Integer.compare(i1,i2);
            }
        };
        
        TreeSet<Integer>set=new TreeSet<>(comp);
        
        for(int i=0;i<operations.length;i++){
            String[]str=operations[i].split(" ");
            if(str[0].equals("I")){
                set.add(Integer.parseInt(str[1]));
            }else{
                if(str[1].equals("-1")){
                    if(set.isEmpty()) continue;
                    else{
                        set.pollFirst();
                    } 
                    
                }else{
                    if(set.isEmpty()) continue;
                    else{
                        set.pollLast();
                    } 
                }
            }
        }
        
        int[] answer = new int[2];
        if(set.isEmpty()){
            answer[0]=0;
            answer[1]=0;
        }else{
            answer[0]=set.last();
            answer[1]=set.first();
        }
        return answer;
    }
}