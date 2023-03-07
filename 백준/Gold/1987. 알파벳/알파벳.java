import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Main {
	static int R,C;
	static int MAX = 0;
	static char[][] map;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static boolean[] visit = new boolean[26];
	static String temp;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for(int i = 0; i < R; i++) {
			temp = br.readLine();
			for(int j=0; j<C; j++) {
				map[i][j] = temp.charAt(j);
			}
		}//배열 생성
		dfs(0,0,1);
		System.out.println(MAX);
		
	}
	private static void dfs(int x, int y, int cnt) {
		
		if(cnt > MAX) {
			MAX = cnt;
		}
		visit[map[x][y] - 'A'] = true;
		for(int i = 0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			//범위 확인
			if(nx < 0 || ny < 0 || nx >= R|| ny >= C) continue;
			//방문 확인. 같은 알파벳인지 판단
			if(visit[map[nx][ny] - 'A']) continue;
			dfs(nx,ny,cnt+1);
			visit[map[nx][ny] - 'A'] = false;
		}
		
	}
}