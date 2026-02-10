import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int result = -1;

        int n = Integer.parseInt(br.readLine());
        int nums[] = new int[n];

        int dp1[] = new int[n];
        int dp2[] = new int[n];

        for(int i=0;i<n;i++){
            nums[i] = Integer.parseInt(br.readLine());

            if(i==0){
                dp1[i] = nums[i];
                dp2[i] = nums[i];
            }

            else if(i==1){
                dp1[i] = nums[i];
                dp2[i] = nums[i] + nums[i-1];
            }

            else{
                dp1[i] = Math.max(nums[i] + dp2[i-2], nums[i] + dp1[i-2]);
                dp2[i] = Math.max(nums[i] + dp1[i-1], dp2[i-1]);
            }
            result = Math.max(result, dp1[i]);
            result = Math.max(result, dp2[i]);
        }

//        System.out.println(Arrays.toString(dp1));
//        System.out.println(Arrays.toString(dp2));

        System.out.println(result);

    }
}
