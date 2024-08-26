import java.io.*;
import java.util.*;

class Main {
    static int N, M, K;
    static int[][] map;
    static final int MOD = 1_000_000_007;
    static int[] even_dx = {-1, -1, 0}, even_dy = {0, -1, -1}, odd_dx = {-1, 0, 1}, odd_dy = {0, -1, -1};
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        map = new int[N][M];

        K = Integer.parseInt(br.readLine());

        for(int i = 0; i < K; i++){
            input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]) - 1;
            int m = Integer.parseInt(input[1]) - 1;
            map[n][m] = -1; //갈 수 없는 벌집
        }
        map[0][0] = 1;
        for(int j = 0; j < M; j++){
            for(int i = 0; i < N; i++){
                if(map[i][j] == -1) continue;
                if(j % 2 == 0){
                    for(int idx = 0; idx < 3; idx++){
                        int ny = j + even_dy[idx];
                        int nx = i + even_dx[idx];
                        if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                        if(map[nx][ny] == -1) continue;
                        map[i][j] = (map[i][j] + map[nx][ny]) % MOD;
                    }
                }
                else{

                    for(int idx = 0; idx < 3; idx++){
                        int ny = j + odd_dy[idx];
                        int nx = i + odd_dx[idx];
                        if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                        if(map[nx][ny] == -1) continue;
                        map[i][j] = (map[i][j] + map[nx][ny]) % MOD;
                    }
                }

            }
        }
        System.out.println(map[N-1][M-1]);
    }
}