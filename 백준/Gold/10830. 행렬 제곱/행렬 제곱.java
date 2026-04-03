
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

    static int N;
    static Long B;
    static int matrix[][];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        B = Long.parseLong(st.nextToken());

        // B가 천억?

        matrix = new int[N][N];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                matrix[i][j] = Integer.parseInt(st.nextToken());
                matrix[i][j] %= 1000;
            }
        }

        int[][] result = calc(matrix, B);

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());

    }


    private static int[][] calc(int[][] matrix, long B){
        if(B==1) return matrix;

        int[][] result = calc(matrix, B/2);

        result = matrixCalc(result, result);

        if(B%2==1){
            result = matrixCalc(result, matrix);
        }

        return result;
    }

    public static int[][] matrixCalc(int[][] A, int[][] B) {

        int[][] result = new int[N][N];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                for(int k = 0; k < N; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                    result[i][j] %= 1000;
                }
            }
        }
        return result;
    }

}