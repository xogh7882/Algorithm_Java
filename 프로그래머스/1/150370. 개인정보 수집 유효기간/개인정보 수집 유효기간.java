import java.util.*;
import java.io.*;

class Solution {
    static int year,month,day;
    static HashMap<String, Integer> map = new HashMap();
    
    public int[] solution(String today, String[] terms, String[] privacies) {
        Queue<Integer> queue = new ArrayDeque<>();

        // 오늘 날짜 나누기
        String dates[] = today.split("\\.");
        year = Integer.parseInt(dates[0]);
        month = Integer.parseInt(dates[1]);
        day = Integer.parseInt(dates[2]);

        // 개인정보 기간 나눠서 정리
        for(int i=0;i<terms.length;i++){
            String term = terms[i];
            String[] termSplit = term.split(" ");
            map.put(termSplit[0], Integer.parseInt(termSplit[1]));
        }

        // 각 개인정보 확인
        for(int i=0;i<privacies.length;i++){
            String privacy = privacies[i];
            String[] privacySplit = privacy.split(" ");
            String findDate = privacySplit[0];
            int findTerm = map.get(privacySplit[1]);

            int findYear = Integer.parseInt(findDate.split("\\.")[0]);
            int findMonth = Integer.parseInt(findDate.split("\\.")[1]);
            int findDay = Integer.parseInt(findDate.split("\\.")[2]);

            findMonth += findTerm;

            findDay -= 1;
            if(findDay == 0){
                findDay = 28;
                findMonth -= 1;
            }

            if(findMonth > 12){
                findYear += findMonth/12;
                findMonth %= 12;
            }

            if(findMonth == 0){
                findMonth = 12;
                findYear -= 1;
            }

            // System.out.println(findYear + ":" + findMonth + ":" + findDay);

            if(year > findYear){
                queue.offer(i+1);
            }
            else if(year==findYear){
                if(month > findMonth){
                    queue.offer(i+1);
                }
                else if(month == findMonth){
                    if(day > findDay){
                        queue.offer(i+1);
                    }
                    else continue;
                }
                else continue;
            }
            else continue;
        }

        int[] answer = new int[queue.size()];
        if(queue.isEmpty()) return answer;
        for(int i=0;i<answer.length;i++){
            answer[i] = queue.poll();
        }
        return answer;
    }
}