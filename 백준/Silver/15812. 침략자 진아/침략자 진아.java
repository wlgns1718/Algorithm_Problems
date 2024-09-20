import java.io.*;
import java.util.*;

class Main {
    static int N, M, target = 0, answer = Integer.MAX_VALUE;
    static char[][] map;
    static int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
    static class Info{
        int x;
        int y;
        public Info(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        map = new char[N][M];
        String maps;
        for (int i = 0; i < N; i++) {
            maps = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = maps.charAt(j);
                if (map[i][j] == '1') target++;
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] == '1') continue;
                for(int p = i; p < N; p++){
                    for(int q = j+1; q < M; q++){
                        if(map[p][q] == '1') continue;
                        sol(i, j, p ,q);
                    }
                }
            }
        }
        System.out.println(answer);

    }
    private static void sol(int x, int y, int p, int q){
        Queue<Info> queue = new ArrayDeque<>();
        queue.offer(new Info(x, y));
        queue.offer(new Info(p, q));
        boolean[][] visit = new boolean[N][M];
        visit[x][y] = true;
        visit[p][q] = true;
        int temp = 0;
        int time = 0;
        while(!queue.isEmpty()){
            time ++;
            int len = queue.size();
            for(int i = 0; i < len; i++){
                Info info = queue.poll();
                for(int idx = 0; idx < 4; idx++){
                    int nx = info.x + dx[idx];
                    int ny = info.y + dy[idx];
                    if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                    if(visit[nx][ny]) continue;
                    visit[nx][ny] = true;
                    if(map[nx][ny] == '1') temp ++;
                    if(temp == target){
                        answer = Math.min(answer, time);
                        return;
                    }
                    queue.offer(new Info(nx, ny));
                }
            }
        }
    }
}