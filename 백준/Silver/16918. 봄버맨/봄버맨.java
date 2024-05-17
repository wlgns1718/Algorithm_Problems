import java.util.*;
import java.io.*;

public class Main {
    static int N, M, T;
    static char[][] map;
    static int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};
    static class Boom{
        int x;
        int y;
        public Boom(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static Queue<Boom> boom = new ArrayDeque<>();
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new char[N][M];

        for(int i = 0; i < N; i++){
            String input = br.readLine();
            for(int j = 0; j < M; j++){
                map[i][j] = input.charAt(j);
                if(map[i][j] == 'O'){
                    boom.offer(new Boom(i, j));
                }
            }
        }
        int time = 1;
        boolean flag = true;
        int boom_size = 0;
        while(time < T){
            if(flag){
                boom_size = boom.size();
                for(int i = 0; i < N; i++){
                    for(int j = 0; j < M; j++){
                        if(map[i][j] == '.'){
                            map[i][j] = 'O';
                        }
                    }
                }
                flag = false;
            }
            else{
                for(int i = 0; i < boom_size; i++){
                    Boom cur = boom.poll();
                    map[cur.x][cur.y] = '.';
                    for(int idx = 0; idx < 4; idx++){
                        int nx = cur.x + dx[idx];
                        int ny = cur.y + dy[idx];
                        if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                        map[nx][ny] = '.';
                    }
                }
                for(int i = 0; i < N; i++){
                    for(int j = 0; j < M; j++){
                        if(map[i][j] == 'O')boom.offer(new Boom(i, j));
                    }
                }
                flag = true;
            }
            time ++;
        }
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}