import java.util.Scanner;

public class Main {
	static int N;
	static int arr[][];
	static int nowr, nowc;
	static int updownlimited;
	static int leftrightlimited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		if(N==1) {
			System.out.println("*\n");
			return;
		}
		
		arr = new int[3+4*(N-1)][1+4*(N-1)];
		nowr = 0;
		nowc = 4*(N-1);
		arr[nowr][nowc] = 1;
		
		
		updownlimited = 2 + 4*(N-1);
		leftrightlimited = 4*(N-1);
		
		for(int i=0;i<leftrightlimited;i++) {
			nowc--;
			arr[nowr][nowc] = 1;
		}
		
		star();
		
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<arr.length; i++) {
		    int lastStar = -1;
		    for(int j=0; j<arr[i].length; j++) {
		        if(arr[i][j] == 1) lastStar = j;
		    }
            // 별이 있는 칸까지만 출력 ( 그 뒤에 공백을 출력하면 틀렸다고 함)
		    for(int j=0; j<=lastStar; j++) {
		        if(arr[i][j] == 1) sb.append("*");
		        else sb.append(" ");
		    }
		    sb.append("\n");
		}
		System.out.println(sb.toString());

	}
	
	private static void star() {
		while(true) {

			if(updownlimited == 0 && leftrightlimited == 0) break;
			for(int i=0;i<updownlimited;i++) {  //gp down
				nowr++;
				arr[nowr][nowc] = 1;
			}
	
			updownlimited = updownlimited - 2;
			
			if(updownlimited == 0 && leftrightlimited == 0) break;
			for(int i=0;i<leftrightlimited;i++) {  //go right
				nowc++;
				arr[nowr][nowc] = 1;
			}
			leftrightlimited = leftrightlimited - 2;
			
			
			
			if(updownlimited == 0 && leftrightlimited == 0) break;
			for(int i=0;i<updownlimited;i++) {  // go up
				nowr--;
				arr[nowr][nowc] = 1;
			}
			updownlimited = updownlimited - 2;
			
			if(updownlimited == 0 && leftrightlimited == 0) break;
			for(int i=0;i<leftrightlimited;i++) {  //go left
				nowc--;
				arr[nowr][nowc] = 1;
			}
			leftrightlimited = leftrightlimited - 2;
			
		}
		
	}

}
