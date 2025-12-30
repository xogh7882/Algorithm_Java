import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int T,N;
    static int A,B;

    static class Node{
        int data;
        Node parent;

        Node(int d){
            data = d;
        }

        private int getData(){
            return data;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            Node[] nodes = new Node[N+1];
            for(int i = 1; i <= N; i++) {
                nodes[i] = new Node(i);
            }

            for(int i=0;i<N-1;i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                nodes[b].parent = nodes[a];
            }

            st = new StringTokenizer(br.readLine());

            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            Stack<Integer> stackA = new Stack<>();
            Stack<Integer> stackB = new Stack<>();

            int temp;

            stackA.push(A);
            stackB.push(B);

            while (nodes[A].parent != null) {
                temp = nodes[A].parent.getData();
                stackA.push(temp);
                A = temp;
            }

            while(nodes[B].parent != null) {
                temp = nodes[B].parent.getData();
                stackB.push(temp);
                B = temp;
            }

            int result = 0;
            int tempA;
            int tempB;

            while(true){
                if(stackA.isEmpty() || stackB.isEmpty()){
                    break;
                }

                tempA = stackA.pop();
                tempB = stackB.pop();
                if(tempA == tempB){
                    result = tempA;
                }
                else{
                    break;
                }
            }

            sb.append(result).append("\n");

        }
        System.out.println(sb.toString());
    }
}
