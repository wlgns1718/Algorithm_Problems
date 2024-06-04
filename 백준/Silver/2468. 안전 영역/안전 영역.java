import java.util.*;
import java.io.*;

public class Main {
    static int N, rain[][], dx[] = {0, 0, 1, -1}, dy[] = {1, -1, 0, 0};
    static boolean[] heights;
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
        N = Integer.parseInt(br.readLine());

        rain = new int[N][N];
        heights = new boolean[101];
        String[] input;
        for(int i = 0; i < N; i++){
            input = br.readLine().split(" ");
            for(int j = 0; j < N; j++){
                rain[i][j] = Integer.parseInt(input[j]);
                heights[rain[i][j]] = true;
            }
        }
        int answer = 1;
        for(int i = 1; i <= 100; i++){
            if(!heights[i]) continue;
            answer = Math.max(answer, sol(i));
        }
        System.out.println(answer);
    }
    private static int sol(int height){
        boolean[][] visit = new boolean[N][N];
        Queue<Info> q = new ArrayDeque<>();
        int res = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(rain[i][j] <= height){
                    visit[i][j] = true;
                    continue;
                }
                if(visit[i][j]) continue;
                visit[i][j] = true;
                q.offer(new Info(i, j));
                res++;
                while(!q.isEmpty()){
                    Info cur = q.poll();
                    for(int idx = 0; idx < 4; idx++){
                        int nx = cur.x + dx[idx];
                        int ny = cur.y + dy[idx];
                        if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                        if(visit[nx][ny]) continue;
                        if(rain[nx][ny] <= height) continue;
                        visit[nx][ny] = true;
                        q.offer(new Info(nx, ny));
                    }
                }
            }
        }
        return res;
    }

}