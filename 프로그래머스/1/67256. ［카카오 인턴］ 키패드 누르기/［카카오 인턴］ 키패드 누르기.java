import java.util.*;

class Solution {
    static int location[][] = {{3,1},{0,0},{0,1},{0,2},{1,0},{1,1},{1,2},{2,0},{2,1},{2,2}};
                                            
    public String solution(int[] numbers, String hand) {
        String answer = "";
        
        int left[] = new int[2];
        int right[] = new int[2];
        
        left[0] = 3;
        left[1] = 0;
        
        right[0] = 3;
        right[1] = 2;
        
        for(int i=0;i<numbers.length;i++){
            
            int now = numbers[i];
            
            if(now == 1 || now == 4 || now == 7){
                answer += "L";
                left[0] = location[now][0];
                left[1] = location[now][1];
            }
            
            else if(now ==3 || now == 6 || now == 9){
                answer += "R";
                right[0] = location[now][0];
                right[1] = location[now][1];
                
            }
            
            else{
                int leftCnt = Math.abs(left[0] - location[now][0]) + Math.abs(left[1] - location[now][1]);
                int rightCnt = Math.abs(right[0] - location[now][0]) + Math.abs(right[1] - location[now][1]);
                
                if(leftCnt < rightCnt){
                    answer += "L";
                    left[0] = location[now][0];
                    left[1] = location[now][1];
                }
                else if(leftCnt > rightCnt){
                    answer += "R";
                    right[0] = location[now][0];
                    right[1] = location[now][1];
                }
                else{
                    if(hand.equals("right")){
                        answer += "R";
                        right[0] = location[now][0];
                        right[1] = location[now][1];
                    }
                    else{
                        answer += "L";
                        left[0] = location[now][0];
                        left[1] = location[now][1];
                    }
                }
            }
            
            
        }
        
        
        return answer;
    }
}