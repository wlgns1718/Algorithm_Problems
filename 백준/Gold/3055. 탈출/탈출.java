import java.util.*;
import java.io.*;

public class Main {
    static int R, C, dx[] = {0, 0, 1, -1}, dy[] = {1, -1, 0, 0};
    static boolean[][] visit;
    static char[][] map;
    static class Info{
        int x;
        int y;
        public Info(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int sx,sy, ex, ey;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] input;
        input = br.readLine().split(" ");
        R = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);
        map = new char[R][C];
        visit = new boolean[R][C];

        for(int i = 0; i < R; i++){
            String temp = br.readLine();
            for(int j = 0; j < C; j++){
                map[i][j] = temp.charAt(j);
                if(map[i][j] == 'S'){
                    sx = i;
                    sy = j;
                }
                if(map[i][j] == 'D'){
                    ex = i;
                    ey = j;
                }
            }
        }

        int answer = sol();
        if(answer == -1) sb.append("KAKTUS");
        else sb.append(answer);
        System.out.println(sb);
    }
    private static int sol(){
        Queue<Info> q = new ArrayDeque<>();
        q.offer(new Info(sx, sy));
        visit[sx][sy] = true;
        int time = 0;
        while(!q.isEmpty()){
            int len = q.size();
            fill_water();

            for(int i = 0; i < len; i++){
                Info cur = q.poll();
                if(cur.x == ex && cur.y == ey) return time;
                for(int idx = 0; idx < 4; idx++){
                    int nx = cur.x + dx[idx];
                    int ny = cur.y + dy[idx];

                    if(nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                    if(visit[nx][ny]) continue;
                    if(map[nx][ny] == 'X' || map[nx][ny] == '*') continue;
                    visit[nx][ny] = true;
                    map[nx][ny] = 'S';
                    q.offer(new Info(nx, ny));
                }
            }
            time ++;
        }
        return -1;
    }
    private static void fill_water(){
        Queue<Info> q = new ArrayDeque<>();

        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(visit[i][j]) continue;
                if(map[i][j] == '*') {
                    q.offer(new Info(i, j));
                    visit[i][j] = true;
                }
            }
        }
        while(!q.isEmpty()){
            Info info = q.poll();
            for(int idx = 0; idx < 4; idx++){
                int nx = info.x + dx[idx];
                int ny = info.y + dy[idx];
                if(nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                if(map[nx][ny] == 'X' || map[nx][ny] == 'D') continue;
                map[nx][ny] = '*';
            }
        }
//        print();
    }
    private static void print(){

        for(int i = 0; i < R; i++){
            System.out.println(Arrays.toString(map[i]));
        }
        System.out.println();
    }
}