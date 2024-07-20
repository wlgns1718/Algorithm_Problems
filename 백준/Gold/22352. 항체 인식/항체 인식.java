import java.io.*;
import java.util.*;

class Main {
    static int N, M;
    static int[][] before, after;
    static boolean[][] visit;
    static class Info{
        int x;
        int y;
        public Info(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};
    public static void main(String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        before = new int[N][M];
        after = new int[N][M];
        visit = new boolean[N][M];

        for(int i = 0; i < N; i++){
            input = br.readLine().split(" ");
            for(int j = 0; j < M; j++){
                before[i][j] = Integer.parseInt(input[j]);
            }
        }

        for(int i = 0; i < N; i++){
            input = br.readLine().split(" ");
            for(int j = 0; j < M; j++){
                after[i][j] = Integer.parseInt(input[j]);
            }
        }

        Loop:
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(before[i][j] != after[i][j]){
                    change(i, j);
                    break Loop;
                }
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(before[i][j] != after[i][j]){
                    System.out.println("NO");
                    return;
                }
            }
        }
        System.out.println("YES");
    }
    private static void change(int x, int y){
        Queue<Info> q = new ArrayDeque<>();
        q.offer(new Info(x, y));
        int be = before[x][y]; //바뀌기전
        int target = after[x][y]; // 바뀐 후
        before[x][y] = target;
        visit[x][y] = true;

        while(!q.isEmpty()){
            Info cur = q.poll();

            for(int idx = 0; idx < 4; idx++){
                int nx = cur.x + dx[idx];
                int ny = cur.y + dy[idx];
                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(visit[nx][ny]) continue;
                if(before[nx][ny] != be) continue;
                visit[nx][ny] = true;
                before[nx][ny] = target;
                q.offer(new Info(nx, ny));
            }
        }
    }
}