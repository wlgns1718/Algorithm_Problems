import java.util.*;
import java.io.*;

public class Main {
    static int R, C, dx[] = {0, 0, 1, -1}, dy[] = {1, -1, 0, 0}, arr[][], brr[][];
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
        arr = new int[R][C];
        brr = new int[R][C];

        Queue<Info> water = new ArrayDeque<>();
        for(int i = 0; i < R; i++){
            String temp = br.readLine();
            Arrays.fill(arr[i], Integer.MAX_VALUE);
            Arrays.fill(brr[i], Integer.MAX_VALUE);
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
                if(map[i][j] == '*'){
                    water.offer(new Info(i, j));
                    brr[i][j] = 0;
                }
            }
        }
        while(!water.isEmpty()){
            Info cur = water.poll();
            for(int idx = 0; idx < 4; idx++){
                int nx = cur.x + dx[idx];
                int ny = cur.y + dy[idx];
                if(nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                if(map[nx][ny] == 'X' || map[nx][ny] == 'D') continue;
                if(brr[nx][ny] <= brr[cur.x][cur.y] + 1) continue;
                brr[nx][ny] = brr[cur.x][cur.y] + 1;
                water.offer(new Info(nx, ny));
            }
        }
        water.offer(new Info(sx, sy));
        arr[sx][sy] = 0;
        while(!water.isEmpty()){
            Info cur = water.poll();
            for(int idx = 0; idx < 4; idx++){
                int nx = cur.x + dx[idx];
                int ny = cur.y + dy[idx];
                if(nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                if(map[nx][ny] == 'X' || map[nx][ny] == 'D') continue;
                if(arr[nx][ny] <= arr[cur.x][cur.y] + 1) continue;
                arr[nx][ny] = arr[cur.x][cur.y] + 1;
                water.offer(new Info(nx, ny));
            }
        }

        int answer = Integer.MAX_VALUE;

        for(int idx = 0; idx < 4; idx++){
            int nx = ex + dx[idx];
            int ny = ey + dy[idx];
            if(nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
            if(arr[nx][ny] >= brr[nx][ny]) continue;
            answer = Math.min(answer, arr[nx][ny] + 1);
        }
        if(answer == Integer.MAX_VALUE) sb.append("KAKTUS");
        else sb.append(answer);
        System.out.println(sb);
    }
}