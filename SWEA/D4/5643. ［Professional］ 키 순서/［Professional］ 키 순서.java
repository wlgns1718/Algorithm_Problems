import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int N,M;
	static int[][] map;
	static boolean[][] temp_map;
	static int[] answer;
	static int sol = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());
		int TC = Integer.parseInt(st.nextToken());
		for(int tc =1; tc<=TC; tc++) {
			sol=0;
			N = Integer.parseInt(br.readLine()); //학생들의 수
			M = Integer.parseInt(br.readLine()); //키 비교 횟수
			answer = new int[N+1];
			map = new int[N+1][N+1];
			temp_map = new boolean[N+1][N+1];
			for(int i = 0; i<=N; i++) {
				for(int j = 0; j<=N; j++) {
					map[i][j] = 987654321;
				}
			}
			for(int i = 0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b= Integer.parseInt(st.nextToken());

				map[a][b] = 1;
			}

			for(int i = 1; i<=N; i++) {
				for(int j = 1; j<=N; j++) {
					for(int k = 1; k<=N; k++) {
						map[j][k] = Math.min(map[j][k], map[j][i]+ map[i][k]);
					}
				}
			}
			for(int i =0; i<=N; i++) {
				for(int j=0; j<=N; j++) {
					if(map[i][j]!=987654321) {
						answer[i] ++;
						answer[j] ++;
					}
				}
			}
			for(int i = 1; i<=N; i++) {
				if(answer[i] ==N-1) {
					sol++;
				}
			}
			System.out.printf("#%d %d%n",tc, sol);
		}


	}
}
