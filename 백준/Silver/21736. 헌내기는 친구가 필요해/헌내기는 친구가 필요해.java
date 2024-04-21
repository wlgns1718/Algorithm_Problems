import java.io.*;
import java.util.*;

public class Main {

    static class Info{
        int x;
        int y;
        public Info(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int[] dx = {1,-1,0,0}, dy = {0,0,-1,1};
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] map = new char[N][M];
        Queue<Info> q = new ArrayDeque<>();
        boolean[][] visit = new boolean[N][M];

        for(int i = 0; i < N; i++){
            String input = br.readLine();
            for(int j = 0; j < M; j++){
                map[i][j] = input.charAt(j);
                if(map[i][j] == 'I'){
                    q.offer(new Info(i, j));
                    visit[i][j] = true;
                }
            }
        }
        int answer = 0;

        while(!q.isEmpty()){
            Info cur = q.poll();
            for(int idx = 0; idx < 4; idx ++){
                int nx = cur.x + dx[idx];
                int ny = cur.y + dy[idx];
                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(visit[nx][ny]) continue;
                if(map[nx][ny] == 'X') continue;

                visit[nx][ny] = true;
                q.offer(new Info(nx, ny));
                if(map[nx][ny] == 'P') answer++;
            }
        }
        if(answer == 0) System.out.println("TT");
        else System.out.println(answer);
    }
}