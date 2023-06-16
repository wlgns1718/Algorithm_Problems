import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 가로, 세로 크기 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        if (N == 1 && M == 1) {
            System.out.println(1);
            return;
        }

        char[][] board = new char[N][M];
        boolean[][] visited = new boolean[N][M];
        boolean[][] newVisited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        // 3차원 BFS 구현
        ArrayDeque<int[]> q = new ArrayDeque<>();
        visited[0][0] = true;
        q.add(new int[]{0, 0, 0, 0}); // 행, 열, 거리, 벽 부순 횟수
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];
                if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                if (cur[3] == 0) {
                    if (visited[nr][nc]) continue;
                    visited[nr][nc] = true;
                    if (board[nr][nc] == '0') q.add(new int[]{nr, nc, cur[2]+1, 0});
                    else q.add(new int[]{nr, nc, cur[2]+1, 1});
                } else {
                    if (board[nr][nc] == '1' || newVisited[nr][nc]) continue;
                    newVisited[nr][nc] = true;
                    q.add(new int[]{nr, nc, cur[2]+1, 1});
                }

                if (nr == N-1 && nc == M-1) {
                    System.out.println(cur[2]+2);
                    return;
                }
            }
        }

        // 답 출력
        System.out.println(-1);
    } // end of main
}// end of class