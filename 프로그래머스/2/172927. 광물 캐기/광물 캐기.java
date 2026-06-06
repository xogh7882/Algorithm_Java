import java.util.*;

class Solution {
    
    static int mineral[];
    static int[][] change = {{1,1,1},{5,1,1},{25,5,1}};
    
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        
        mineral = new int[minerals.length];
        
        for(int i=0;i<mineral.length;i++){
            if(minerals[i].equals("diamond")) mineral[i] = 0;
            else if(minerals[i].equals("iron")) mineral[i] = 1;
            else if(minerals[i].equals("stone")) mineral[i] = 2;
        }
        
        int number = 0;
        for(int i=0;i<3;i++){
            number += picks[i];
        }
        
        int a = mineral.length / 5;
        int b = mineral.length % 5;
        
        int size = (b==0) ? a : a + 1;
        
        int temp[] = new int[size];
        
        for(int i=0;i<mineral.length;i++){
            temp[i/5] += change[2][mineral[i]];
        }
        
        // System.out.println(Arrays.toString(mineral));
        // System.out.println(Arrays.toString(temp));
        
        ArrayList<int[]> list = new ArrayList<int[]>();
        for(int i=0;i<Math.min(number, temp.length);i++){
            list.add(new int[] {i*5, temp[i]});
        }
        
        Collections.sort(list, (o1,o2) -> Integer.compare(o2[1], o1[1]));
        
        for(int i=0;i<list.size();i++){
            int[] cur = list.get(i);
            
            for(int k=0;k<3;k++){
                if(picks[k] == 0) continue;
                
                else{
                    picks[k]--;
                    for(int j=cur[0];j<cur[0]+5;j++){
                        if(j == mineral.length) break;
                        answer += change[k][mineral[j]];
                    }
                    break;
                }
            }
        }
        
        return answer;
    }
}