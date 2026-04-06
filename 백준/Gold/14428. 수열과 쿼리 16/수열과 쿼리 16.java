import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        int bucketSize = (int) (Math.sqrt(N));    // 하나의 버킷에 bucketSize만큼 들어간다
        int bucketNum = (N + bucketSize -1) / bucketSize;     // 총 버킷은 bucketNum개 있다.

        int bucket[] = new int[bucketNum];
        Arrays.fill(bucket, -1);

        int[] arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

            int idx = (i-1)/bucketSize;
            if(bucket[idx] == -1 || arr[i] < arr[bucket[idx]]){
                bucket[idx] = i;
            }
        }

//        System.out.println("bucketSize : " + bucketSize);
//        System.out.println("bucketNum : " + bucketNum);
//        System.out.println(Arrays.toString(arr));
//        System.out.println(Arrays.toString(bucket));


        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == 1) {
                arr[b] = c;

                int idx = (b-1)/bucketSize;

                int result = -1;

                for(int j=(idx*bucketSize)+1;j<=Math.min((idx+1) * bucketSize, N);j++){
                    if(result == -1 || arr[j] < arr[result]){
                        result = j;
                    }
                }
                bucket[idx] = result;

            } else {
                int idx = -1;

                int leftBucket = (b-1) / bucketSize;
                int rightBucket = (c-1) / bucketSize;

                if (leftBucket == rightBucket) {      // 같은 버킷
                    for (int k = b; k <= c; k++) {
                        if (idx == -1 || arr[idx] > arr[k]) idx = k;
                    }

                } else {                              // 다른 버킷
                    for (int k = b; k <= (leftBucket + 1 )*bucketSize; k++) {
                        if (idx == -1 || arr[idx] > arr[k]) idx = k;
                    }
                    for (int k = leftBucket + 1; k <= rightBucket - 1; k++) {
                        if (idx == -1 || arr[idx] > arr[bucket[k]]) idx = bucket[k];
                    }
                    for (int k = (rightBucket * bucketSize) + 1; k <= c; k++) {
                        if (idx == -1 || arr[idx] > arr[k]) idx = k;
                    }
                }


                sb.append(idx).append("\n");
            }

//            System.out.println("------------------------------------------------");
//            System.out.println(Arrays.toString(arr));
//            System.out.println(Arrays.toString(bucket));

        }

        System.out.println(sb.toString());

    }

}
