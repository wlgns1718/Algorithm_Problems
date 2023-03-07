import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, nx, ny, days;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static Queue<Data> queue = new LinkedList<>();
	static int[][] tomato;

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		tomato = new int[M][N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				tomato[i][j] = Integer.parseInt(st.nextToken());
				if (tomato[i][j] == 1) {
					queue.offer(new Data(i, j));
				}
			}
		}
		if (search() == 1) {
			System.out.println(0);
		}
		else {
			while (!queue.isEmpty()) {
				days++;
				int size = queue.size();
				for (int i = 0, x, y; i < size; i++) {
					Data cur = queue.poll();
					x = cur.x;
					y = cur.y;
					for (int idx = 0; idx < 4; idx++) {
						nx = x + dx[idx];
						ny = y + dy[idx];
						if (nx < 0 || ny < 0 || nx >= M || ny >= N)
							continue;
						if (tomato[nx][ny] == -1)
							continue;
						if (tomato[nx][ny] == 1)
							continue;
						if (tomato[nx][ny] == 0) {
							tomato[nx][ny] = 1;
							queue.offer(new Data(nx,ny));
						}
					}

				}

			}
			if (search() == -1) {
				System.out.println(-1);
			} else {
				System.out.println(days-1);
			}
		}

	}

	public static int search() {
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (tomato[i][j] == 0) {
					return -1;
				} else
					continue;
			}
		}
		return 1;
	}

	public static class Data {
		int x;
		int y;

		public Data(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

}