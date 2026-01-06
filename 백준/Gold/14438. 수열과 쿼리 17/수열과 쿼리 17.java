import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static int N, M;
    static int[] map;
    static int k,a,b;

    static int[] bucket;
    static int bucketNum = 100;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N+1];  // 원본

        int bucketSize = (N/bucketNum)+1;
        bucket = new int[(bucketSize+1)];  // 버킷 ( 나눠서 min만 저장하기 ) 1부터 쓰자

        int min = Integer.MAX_VALUE;
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++){
            map[i] = Integer.parseInt(st.nextToken());

            int idx = ((i-1) / bucketNum) + 1;

            if((i-1)%bucketNum == 0){  // 버킷 처음 들어갈때
                bucket[idx] = Integer.MAX_VALUE;
            }
            bucket[idx] = Math.min(map[i], bucket[idx]);

        }


        M = Integer.parseInt(br.readLine());
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            if(k==1){
                // a번째 b로 바꾸기
                map[a] = b;

                // 다시 계산 ( 최소가 없어질 수 있잖아? )
                int idx = ((a-1)/bucketNum) + 1;  // 버킷 idx

                bucket[idx] = Integer.MAX_VALUE;

                int start = ((idx-1)*bucketNum)+1;
                int end = Math.min(N, idx*bucketNum);  // 끝이 N일수도 있으니깐
                for(int t=start;t<=end;t++){
                    bucket[idx] = Math.min(bucket[idx], map[t]);
                }

            }
            else{
                int result = Integer.MAX_VALUE;

                // a-b 사이에 최솟값 구하기
                int aBlock = (a-1)/bucketNum + 1;
                int bBlock = (b-1)/bucketNum + 1;

                if(aBlock == bBlock){  // 하나에 다 들어있으면
                    for(int t=a;t<=b;t++){
                        result = Math.min(result, map[t]);
                    }
                }

                else{  // 같은 블럭이 아니면 ( 최소 블럭 2개 )

                    // a 블록 확인
                    for(int t=a;t<=aBlock*bucketNum;t++){
                        result = Math.min(result, map[t]);
                    }

                    // a-b 사이 블럭
                    for(int t=aBlock+1;t<=bBlock-1;t++){
                        result = Math.min(result, bucket[t]);
                    }

                    // b블록 - b 까지
                    for(int t=(bBlock-1)*bucketNum+1;t<=b;t++){
                        result = Math.min(result, map[t]);
                    }
                }

                sb.append(result).append("\n");
            }
        }

        System.out.println(sb.toString());
    }

}
