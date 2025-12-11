import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int A,B,C;
    static int AB,BC,CA;
    static int result;
    static int answer;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= t; test_case++) {
            result = 0;
            answer = 0;

            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            AB = Integer.parseInt(st.nextToken());
            BC = Integer.parseInt(st.nextToken());
            CA = Integer.parseInt(st.nextToken());

            // A,B 중 개수 작은 만큼만 ( 최대로 AB 만들기 )
            for(int i=0;i<=Math.min(A,B);i++){
                result += (AB * i);
                makeBC(A-i,B-i,C);
                result -= (AB * i);
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void makeBC(int a, int b, int c){
        for(int i=0;i<=Math.min(b,c);i++){
            result += (BC * i);
            makeCA(a, b-i, c-i);
            result -= (BC * i);
        }
    }
    private static void makeCA(int a, int b, int c){
        result += (CA * Math.min(c,a));
        answer = Math.max(result,answer);
        result -= (CA * Math.min(c,a));
    }
}
