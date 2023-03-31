import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] map;
    static int[] dx = { 0, 0, 1, -1 };
    static int[] dy = { 1, -1, 0, 0 };
    static int time;
    static int cheezeCnt;
    static Queue<int[]> q;
    static boolean[][] v;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    cheezeCnt++;
                }
            }
        }

        q = new ArrayDeque<>();
        v = new boolean[N][M];

        // 겉 채우기
        int lastCheezeCnt = 0;
        while (cheezeCnt != 0) {
            lastCheezeCnt = cheezeCnt;
            bfs();
        }

        System.out.println(time);
        System.out.println(lastCheezeCnt);
    }

    private static void bfs() {

        // init
        q = new ArrayDeque<>();
        v = new boolean[N][M];
        time += 1;

        // logic
        q.offer(new int[] { 0, 0 });
        v[0][0] = true;
        int[] cur;
        int nx, ny;
        while (!q.isEmpty()) {
            cur = q.poll();

            for (int d = 0; d < 4; d++) {
                nx = cur[0] + dx[d];
                ny = cur[1] + dy[d];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M)
                    continue;

                if (v[nx][ny])
                    continue;
                if (map[nx][ny] == 1) {
                    map[nx][ny] = 0; // 녹일 부분 없애기
                    v[nx][ny] = true;
                    cheezeCnt--;
                } else if (map[nx][ny] == 0) {
                    q.offer(new int[] { nx, ny });
                    v[nx][ny] = true;
                }

            }
        }
    }
}