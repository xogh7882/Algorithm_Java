
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{

    static int N, M;
    static class Info implements Comparable<Info>{
        int weight;
        int price;

        public Info(int weight, int price){
            this.weight = weight;
            this.price = price;
        }

        @Override
        public int compareTo(Info o) {
            if(this.price == o.price){
                return Integer.compare(o.weight, this.weight);
            }
            else return Integer.compare(this.price, o.price);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        PriorityQueue<Info> pq = new PriorityQueue<Info>(
                (o1,o2) ->{
                    if(o1.price == o2.price) return Integer.compare(o2.weight, o1.weight);
                    else return Integer.compare(o1.price, o2.price);
                }
        );

        ArrayList<Info> list = new ArrayList<>();

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            list.add(new Info(weight,price));
        }

        Collections.sort(list);

        long totalWeight = 0;
        long resultPrice = 0;
        long result = Long.MAX_VALUE;

        for(int i=0;i<N;i++){
            Info info = list.get(i);

            totalWeight += info.weight;

            if(i>=1 && info.price == list.get(i-1).price){
                resultPrice += info.price;
            }
            else{
                resultPrice = info.price;
            }

            if(totalWeight >= M){
                result = Math.min(result, resultPrice);
            }

        }

        if(totalWeight < M) result = -1;

        System.out.println(result);

    }

}