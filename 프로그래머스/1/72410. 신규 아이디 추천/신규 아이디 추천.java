import java.util.*;

class Solution {
    public String solution(String new_id) {
        //1단계
        String new_id2=new_id.toLowerCase();
        
        //2단계
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<new_id2.length();i++){
            if(('a'<=new_id2.charAt(i)&&new_id2.charAt(i)<='z')||('0'<=new_id2.charAt(i)&&new_id2.charAt(i)<='9')||new_id2.charAt(i)=='-'||new_id2.charAt(i)=='_'||new_id2.charAt(i)=='.'){
                sb.append(new_id2.charAt(i));
            }
        }
        
        //3단계
        String new_id3=sb.toString();
        
        StringBuilder sb2=new StringBuilder();
        
        for(int i=0;i<new_id3.length();i++){
             if(new_id3.charAt(i)=='.'&&i>0&&new_id3.charAt(i-1)=='.'){
                 continue;
             }
            sb2.append(new_id3.charAt(i));
        }
        
        //4단계
        String new_id4=sb2.toString();
        
        StringBuilder sb3=new StringBuilder();
        
        if(new_id4.charAt(0)=='.'){
            //끝 O
            if(new_id4.charAt(new_id4.length()-1)=='.'){
                for(int i=1;i<new_id4.length()-1;i++){
                    sb3.append(new_id4.charAt(i));
                }
            }else{ //끝 X
                for(int i=1;i<new_id4.length();i++){
                    sb3.append(new_id4.charAt(i));
                }
            }
           
        }else{
            //끝 O
            if(new_id4.charAt(new_id4.length()-1)=='.'){
                for(int i=0;i<new_id4.length()-1;i++){
                    sb3.append(new_id4.charAt(i));
                }
            }else{ //끝 X
                for(int i=0;i<new_id4.length();i++){
                    sb3.append(new_id4.charAt(i));
                }
            }
        }
        
        //5단계
        if(sb3.toString().length()==0){
            sb3.append('a');
        }
        
        //6단계
        int length=sb3.toString().length();
        if(sb3.toString().length()>=16){
            sb3.delete(15,length);//.delete(시작 인덱스,끝 인덱스)-끝 인덱스 포함 X
            length=sb3.toString().length();
            if(sb3.toString().charAt(length-1)=='.'){
                sb3.deleteCharAt(length-1);
            }
        }
        
        //7단계
        int length2=sb3.toString().length();
        int newLength=length2;
        if(length2<=2){
            while(newLength<3){
                sb3.append(sb3.toString().charAt(length2-1));
                newLength++;
            }
        }
        
        String answer = sb3.toString();
        return answer;
    }
}