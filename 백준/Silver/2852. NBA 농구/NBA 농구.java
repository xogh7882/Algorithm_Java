import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int team;
	static int teamA;
	static int teamB;
	static int minute;
	static int second;
	static int time;
	static int teamAtime;
	static int teamBtime;
	static int prevtime;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		teamA = 0;
		teamB = 0;
		prevtime = 0;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			team = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(st.nextToken(), ":");
			minute = Integer.parseInt(st.nextToken());
			second = Integer.parseInt(st.nextToken());
			
			time = minute*60+second;
			
			if(teamA > teamB) {
				teamAtime += time - prevtime;
			}
			else if(teamB > teamA) {
				teamBtime += time - prevtime;
			}
			
			if(team == 1) teamA++;
			else teamB++;
			
			prevtime = time;
			
		}
		if(teamA > teamB) {
			teamAtime += 48*60-prevtime;
		}
		else if(teamA < teamB) {
			teamBtime += 48*60-prevtime;
		}
		
		System.out.printf("%02d:%02d\n", teamAtime/60 , teamAtime%60);
		System.out.printf("%02d:%02d", teamBtime/60 , teamBtime%60);
	}
}
