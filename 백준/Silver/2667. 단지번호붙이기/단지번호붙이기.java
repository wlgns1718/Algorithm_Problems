import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	static int[][] map;
	static int N,home_number,home_cnt, nx, ny;
	static String temp;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static boolean[][] visit;
	static ArrayList<Integer> homes = new ArrayList<Integer>();
	static Queue<Data> stack = new LinkedList<Data>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		home_number = 0;
		map = new int[N][N];
		visit = new boolean[N][N];
		for(int i = 0; i<N; i++) {
			temp = br.readLine();
			for(int j = 0; j<N; j++) {
				map[i][j] = temp.charAt(j) == '0' ? 0 : 1;
			}
		}//집 생성
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				if(map[i][j] == 0) continue;
				if(visit[i][j]) continue;
				stack.offer(new Data(i,j));
				visit[i][j] = true;
				home_cnt = 0;
				while(!stack.isEmpty()) {
					Data cur = stack.poll();
					home_cnt += 1;
					for(int idx = 0; idx<4; idx++) {
						nx = cur.x + dx[idx];
						ny = cur.y + dy[idx];
						if(nx <0 || ny < 0 || nx >= N || ny >= N) continue; //범위 체크
						if(visit[nx][ny]) continue;//방문체크
						if(map[nx][ny]==0) continue; // 집 여부 체크
						stack.offer(new Data(nx,ny));
						visit[nx][ny] = true;
					}
				}
				homes.add(home_cnt);
				home_number++;
			}
		}
		System.out.println(home_number);
		Collections.sort(homes);
		for(int p = 0; p<homes.size(); p ++) {
			System.out.println(homes.get(p));
		}
	}
	static class Data{
		int x;
		int y;
		public Data(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	
}