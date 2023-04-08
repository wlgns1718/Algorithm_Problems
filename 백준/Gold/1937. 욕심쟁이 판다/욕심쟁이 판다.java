import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N,nx ,ny;
	static int[][] map, dp;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static int answer = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = null;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		dp = new int[N][N];
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				answer = Math.max(answer,sol(i,j));
			}
		}
		System.out.println(answer);
	}
	public static int sol(int x, int y) {
		if(dp[x][y]!=0) {
			return dp[x][y];
		}
		
		dp[x][y] = 1;
		
		for(int idx = 0; idx<4; idx++) {
			nx = x + dx[idx];
			ny = y + dy[idx];
			if(nx < 0 || ny < 0 || nx >= N || ny>=N)continue;
			if(map[x][y] < map[nx][ny]) {
				dp[x][y] = Math.max(dp[x][y], sol(nx,ny)+1);
			}
		}
		
		
		return dp[x][y];
	}
}