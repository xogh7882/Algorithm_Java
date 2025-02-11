import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// map에서 돌리니깐 시간초과
// 그냥 위치만 따로 저장할까
// 차피 값만 계산하니깐

public class Main {
	static int N,M;
	static ArrayList<int[]> house;
	static ArrayList<int[]> chicken;
	static ArrayList<int[]> selectChicken;
	static int result = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		house = new ArrayList<>();
		chicken = new ArrayList<>();
		selectChicken = new ArrayList<>();
				
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				int temp = Integer.parseInt(st.nextToken());
				if(temp == 1) house.add(new int[] {i,j});
				else if(temp == 2) chicken.add(new int[] {i,j});
			}
		}
		
		findChicken(0,0);
		System.out.print(result);
	}

	// 순서 상관X = Combination
	private static void findChicken(int cnt, int start) {
		if(cnt == M) {
			int distance = chickenDistance();
			if(distance < result) result = distance;
			return;
		}
		for(int i=start;i<chicken.size();i++) {
			selectChicken.add(chicken.get(i));
			findChicken(cnt+1, i+1);
			selectChicken.remove(selectChicken.size()-1);
		}
		
	}

	private static int chickenDistance() {
		int sum = 0;
		for(int i=0;i<house.size();i++) {
			int[] houseRC = house.get(i);
			int r = houseRC[0];
			int c = houseRC[1];
			int k = Integer.MAX_VALUE;
			for(int j=0;j<selectChicken.size();j++) {
				int chickenRC[] = selectChicken.get(j);
				int chickenR = chickenRC[0];
				int chickenC = chickenRC[1];
				k = Math.min(k, chickenCal(r, c, chickenR, chickenC));
			}
			sum += k;
		}
		return sum;
	}

	private static int chickenCal(int r, int c, int chickenR, int chickenC) {
		return Math.abs(r-chickenR) + Math.abs(c - chickenC);
	}

}
