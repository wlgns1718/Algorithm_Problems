import java.util.*;
import java.io.*;

public class Main {
    static int N, chess[][], dx[] = {-2, -2, -1, 1, 2, 2, 1, -1}, dy[] = {-1, 1, 2, 2, 1, -1, -2, -2};
    static boolean[][] visit;
    static class Info{
        int x;
        int y;
        int cnt;
        public Info(int x, int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    static int sx,sy, ex, ey;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        String[] input;
        for(int tc = 0; tc < TC; tc++){
            N = Integer.parseInt(br.readLine());
            chess = new int[N][N];
            visit = new boolean[N][N];
            input = br.readLine().split(" ");
            sx = Integer.parseInt(input[0]);
            sy = Integer.parseInt(input[1]);
            input = br.readLine().split(" ");
            ex = Integer.parseInt(input[0]);
            ey = Integer.parseInt(input[1]);
            sb.append(sol()).append("\n");
        }
        System.out.println(sb);
    }
    private static int sol(){
        Queue<Info> q = new ArrayDeque<>();
        q.offer(new Info(sx, sy, 0));
        visit[sx][sy] = true;

        while(!q.isEmpty()){
            Info cur = q.poll();
            if(cur.x == ex && cur.y == ey) return cur.cnt;
            for(int idx = 0; idx < 8; idx++){
                int nx = cur.x + dx[idx];
                int ny = cur.y + dy[idx];
                if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if(visit[nx][ny])continue;
                visit[nx][ny] = true;
                q.offer(new Info(nx, ny, cur.cnt + 1));
            }
        }
        return -1;
    }
}