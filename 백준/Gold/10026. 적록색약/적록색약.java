import java.io.*;
import java.util.*;

public class Main {
    static char[][] map;
    static int[] dx = {0,0,1,-1}, dy = {1, -1, 0, 0};
    static class Info{
        int x;
        int y;
        public Info(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int N;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        map = new char[N][N];

        for(int i = 0; i < N; i++){
            String temp = br.readLine();
            for(int j = 0; j < N; j++){
                map[i][j] = temp.charAt(j);
            }
        }
        sb.append(rgb()).append(" ");
        sb.append(rg_b());

        System.out.println(sb);
    }
    static private int rgb(){
        boolean[][] visit = new boolean[N][N];
        int res = 0;

        Queue<Info> q = new ArrayDeque<>();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(visit[i][j]) continue;
                res ++;
                visit[i][j] = true;
                q.offer(new Info(i, j));
                char temp = map[i][j];
                while(!q.isEmpty()){
                    Info cur = q.poll();
                    for(int idx = 0; idx < 4; idx++){
                        int nx = cur.x + dx[idx];
                        int ny = cur.y + dy[idx];
                        if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                        if(visit[nx][ny]) continue;
                        if(map[nx][ny] != temp) continue;

                        visit[nx][ny] = true;
                        q.offer(new Info(nx, ny));
                    }
                }
            }
        }
        return res;
    }
    static private int rg_b(){
        int res = 0;
        Queue<Info> q = new ArrayDeque<>();
        boolean[][] visit = new boolean[N][N];
        boolean flag = false;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(visit[i][j]) continue;
                visit[i][j] = true;
                res++;
                char temp = map[i][j];
                if(temp == 'R' || temp == 'G') flag = true;
                if(temp == 'B') flag = false;
                q.offer(new Info(i, j));

                while(!q.isEmpty()){
                    Info cur = q.poll();
                    for(int idx = 0; idx < 4; idx++){
                        int nx = cur.x + dx[idx];
                        int ny = cur.y + dy[idx];
                        if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                        if(visit[nx][ny]) continue;
                        if(flag && map[nx][ny] == 'B') continue;
                        if(!flag && map[nx][ny] != 'B') continue;

                        visit[nx][ny] = true;
                        q.offer(new Info(nx, ny));
                    }
                }
            }
        }
        return res;
    }
}