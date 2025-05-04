import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main{
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), ":");
		int timeA = 0;
		timeA += (Integer.parseInt(st.nextToken())*3600);
		timeA += (Integer.parseInt(st.nextToken())*60);
		timeA += (Integer.parseInt(st.nextToken())*1);
		
		
		st = new StringTokenizer(br.readLine(), ":");
		int timeB = 0;
		timeB += (Integer.parseInt(st.nextToken())*3600);
		timeB += (Integer.parseInt(st.nextToken())*60);
		timeB += (Integer.parseInt(st.nextToken())*1);
		
		int time = 0;
		int hour;
		int min;
		int sec;
		
		if(timeA > timeB) {
			int temp = 3600*24;
			time += temp-timeA;
			timeA = 0;
		}
		
		time += (timeB - timeA);
		hour = time / 3600;
		time %= 3600;
		min = time / 60;
		time %= 60;
		sec = time;
		System.out.printf("%02d:%02d:%02d", hour, min, sec);
		
		
		
		
	}
}
