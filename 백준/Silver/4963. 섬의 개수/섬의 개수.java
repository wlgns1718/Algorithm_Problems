import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class Main {
	static int w, h;
	static int[][] map;
	static boolean[][] visit;
	static int cnt, nx, ny;
	static int[] dx = {0,0,1,-1,-1,-1,1,1};
	static int[] dy = {1,-1,0,0,-1,1,-1,1};
	static Queue<Data> stack = new LinkedList<Data>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		while (true) {
			cnt = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			if(w==0 && h==0) break;
			visit = new boolean[h][w];
			map = new int[h][w];
			for(int i = 0; i<h; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j<w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}//섬 생성
			
			for(int i = 0; i<h; i++) {
				for(int j =0; j<w; j++) {
					if (map[i][j] == 0 ) continue;
					if (visit[i][j]) continue;
					cnt += 1;
					stack.offer(new Data(i,j));
					visit[i][j] = true;
					while(!stack.isEmpty()) {
						Data cur = stack.poll();
						for(int idx = 0; idx<8; idx++) {
							nx = cur.x + dx[idx];
							ny = cur.y + dy[idx];
							if(nx <0 || nx>=h || ny <0 || ny>=w) continue; //범위를 벗어난 경우
							if(visit[nx][ny]) continue; //방문여부체크
							if(map[nx][ny] == 0) continue; //바다인지 체크
							stack.offer(new Data(nx,ny));
							visit[nx][ny] = true;
							
						}
					}
				}
			}
			System.out.println(cnt);
			stack.clear();
			
			
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