import java.util.*;

class Solution {
    static class Node{
        Character c;
        String s;
        
        Node(Character c, String s){
            this.c=c;
            this.s=s;
        }
    }
    
    public String[] solution(String[] strings, int n) {
        
        
        Comparator<Node> comp = new Comparator<Node>() {
            public int compare(Node n1, Node n2) {
                if(n1.c==n2.c) return n1.s.compareTo(n2.s);
                return n1.c.compareTo(n2.c);
            }
        };//오름차순
        
        ArrayList<Node>list=new ArrayList<Node>();
        
        for(int i=0;i<strings.length;i++){
            list.add(new Node(strings[i].charAt(n),strings[i]));
        }
        
        list.sort(comp);
        
        String[] answer = new String[strings.length];
        
        for(int i=0;i<list.size();i++){
            answer[i] = list.get(i).s;
        }
        
        return answer;
    }
}