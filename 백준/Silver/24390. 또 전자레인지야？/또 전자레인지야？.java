import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), ":");
		int cnt = 0;
		int sec = Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken());
		cnt += sec / 600;
		sec %= 600;
		cnt += sec / 60;
		sec %= 60;
		cnt += Math.max(sec / 30, 1);
		sec %= 30;
		cnt += sec / 10;
		sec %= 10;
		System.out.println(cnt);
		
	}
}