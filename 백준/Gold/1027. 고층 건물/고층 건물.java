import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int arr[];
	static int result = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		// 입력 받기
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 한바퀴 돌면서 체크해보자
		for(int i=0;i<N;i++) {
			check(i);
		}
		
		System.out.println(result);
	}

	private static void check(int idx) {
		int count = 0;
		double before = 0;
		double now = 0;
		
		// 왼쪽 확인하기 ( 갈수록 기울기가 작아져야 볼수있다 )
		for(int i=idx-1;i>=0;i--) {
			if(i==idx-1) {
				before = (arr[i]-arr[idx]) / (double)(i-idx) ;
				count++;
			}
			else {
				now =(arr[i]-arr[idx]) / (double)(i-idx) ;
				if(now < before) {
					before = now;
					count++;
				}
				else {
					continue;      // 여기서 break 했었는데, 그 이후에도 높은 건물이 있으면 가능하니깐 continue 해야하네!
				}
			}
			
		}
		
		
		// 오른쪽 확인하기 ( 갈수록 기울기가 커져야 볼수있다 )
		for(int i=idx+1;i<N;i++) {
			if(i==idx+1) {
				before = (arr[i]-arr[idx]) / (double)(i-idx) ;
				count++;
			}
			else {
				now = (arr[i]-arr[idx]) / (double)(i-idx) ;
				if(now > before) {
					before = now;
					count++;
				}
				else {
					continue;
				}
			}
			
		}
		
		result = Math.max(result, count);
		
	}

}
