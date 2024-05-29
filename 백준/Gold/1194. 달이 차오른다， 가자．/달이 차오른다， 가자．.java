import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static char[][] map;
    static boolean[][][] visit;
    static class Info{
        int x;
        int y;
        int cost;
        int key;
        public Info(int x, int y, int cost, int key){
            this.x = x;
            this.y = y;
            this.cost = cost;
            this.key = key;
        }

        @Override
        public String toString() {
            return "Info{" +
                    "x=" + x +
                    ", y=" + y +
                    ", cost=" + cost +
                    ", key=" + Integer.toBinaryString(this.key) +
                    '}';
        }
    }
    static Info start;
    static int[] dx = {0, 0, 1, -1}, dy = {1,-1, 0, 0};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visit = new boolean[N][M][64];

        String input;

        for(int i = 0; i < N; i++){
            input = br.readLine();
            for(int j = 0; j < M; j++){
                map[i][j] = input.charAt(j);
                if(map[i][j] == '0'){
                    start = new Info(i,j,0,0);
                }
            }
        }
        System.out.println(sol());
    }
    private static int sol(){
        Queue<Info> q = new ArrayDeque<>();
        q.offer(start);
        visit[start.x][start.y][start.key] = true;
          while(!q.isEmpty()){
            Info cur = q.poll();

            if(map[cur.x][cur.y] == '1') return cur.cost;
            for(int idx = 0; idx < 4; idx++){
                int nx = cur.x + dx[idx];
                int ny = cur.y + dy[idx];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M)continue;
                if(map[nx][ny] == '#') continue;
                if(visit[nx][ny][cur.key]) continue;

                if(map[nx][ny] >= 'a' && map[nx][ny] <= 'f'){
                    int newkey = cur.key | (1 << map[nx][ny] - 'a');
                    visit[nx][ny][newkey] = true;
                    q.offer(new Info(nx, ny, cur.cost + 1, newkey));
                }
                else if(map[nx][ny] >= 'A' && map[nx][ny] <= 'F'){
                    if((cur.key & (1 << map[nx][ny] - 'A')) != 0){
                        visit[nx][ny][cur.key] = true;
                        q.offer(new Info(nx, ny, cur.cost + 1, cur.key));
                    }
                }
                else{
                    visit[nx][ny][cur.key] = true;
                    q.offer(new Info(nx, ny, cur.cost + 1, cur.key));
                }

            }
        }
        return -1;
    }
}