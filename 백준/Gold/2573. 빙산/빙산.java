import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M,map[][],cnt,nx,ny;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static boolean tri;
	static Queue<Data> queue = new ArrayDeque<>();
	static class Data{
		int x;
		int y;
		public Data(int x, int y) {
			this.x = x;
			this.y = y;
			
		}
	}
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());
		int answer = 0;
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		while(true) {
			if(bfs()>=2) {
				tri = true;
				break;
			}
			else if(bfs()==0) {
				break;
			}
			melt();
			answer++;
		}
		if(tri) {
			System.out.println(answer);
		}
		else {
			System.out.println(0);
		}
		
	}
	public static int bfs() {//빙산 무리 몇개인지 찾기
		boolean[][] visit = new boolean[N][M];
		cnt = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j]==0) continue;//0이면 패스
				if(visit[i][j]) continue;//이미 처리된 빙산이면 패스
				queue.offer(new Data(i,j));
				visit[i][j] = true;
				cnt++;
				while(!queue.isEmpty()) {
					Data cur = queue.poll();
					for(int idx = 0; idx <4; idx++) {
						nx = cur.x + dx[idx];
						ny = cur.y + dy[idx];
						if(nx < 0 || ny < 0 || nx>=N || ny >= M)continue;//범위체크
						if(map[nx][ny]==0) continue; //바다 체크
						if(visit[nx][ny]) continue; //방문 체크
						//만약 빙산이라면
						visit[nx][ny] = true;
						queue.offer(new Data(nx,ny));
					}
				}
			}
		}
		return cnt;
		
	}
	public static void melt() {//빙산 녹이기
		int[][] temp_map = new int [N][M];
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				temp_map[i][j] = map[i][j];
			}
		}
		
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				if(temp_map[i][j] == 0) continue;
				//빙산이 존재하는 경우
				for(int idx = 0; idx<4; idx++) {
					if(map[i][j]==0)continue;
					nx = i + dx[idx];
					ny = j + dy[idx];
					if(nx < 0 || ny < 0 || nx>=N || ny >= M)continue;//범위체크
					if(temp_map[nx][ny] == 0) {
						map[i][j]--;//주변에 물이 있다면 녹이기
						
					}
				}
			}
		}
//		System.out.println("--------------------------------------");
//		for(int i = 0 ; i< N; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
	}

}