import java.util.*;
import java.io.*;

public class Main {
    static int N, M, T;
    static char[][] map;
    static int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};
    static boolean[][] boom;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        if(T == 1){
            for(int i = 0; i < N; i++){
                String input = br.readLine();
                sb.append(input).append("\n");
            }
        }
        else if(T % 2 == 0){
            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    sb.append('O');
                }
                sb.append("\n");
            }
        }
        else if(T % 4 == 1){
            map = new char[N][M];
            boom = new boolean[N][M];
            for(int i = 0; i < N; i++){
                String input = br.readLine();
                for(int j = 0; j < M; j++){
                    map[i][j] = input.charAt(j);
                    if(map[i][j] == 'O'){
                        boom[i][j] = true;
                    }
                }
            }
            sol();
            sol2();
            sol();
            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    sb.append(map[i][j]);
                }
                sb.append("\n");
            }
        }
        else{
            map = new char[N][M];
            boom = new boolean[N][M];
            for(int i = 0; i < N; i++){
                String input = br.readLine();
                for(int j = 0; j < M; j++){
                    map[i][j] = input.charAt(j);
                    if(map[i][j] == 'O'){
                        boom[i][j] = true;
                    }
                }
            }
            sol();
            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    sb.append(map[i][j]);
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }

    private static void sol2() {
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] == 'O') boom[i][j] = true;
            }
        }
    }

    private static void fill_boom(){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] == '.'){
                    map[i][j] = 'O';
                }
            }
        }
    }
    private static void sol(){
        fill_boom();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(!boom[i][j]) continue;
                boom[i][j] = false;
                map[i][j] = '.';
                for(int idx = 0; idx < 4; idx ++){
                    int nx = i + dx[idx];
                    int ny = j + dy[idx];
                    if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                    map[nx][ny] = '.';
                }
            }
        }
    }
}