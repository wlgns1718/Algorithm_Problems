import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {1, -1, 0, 0}, dy = {0, 0, -1 ,1};
    static int N, M, arr[][], dp[][];
    static class Node{
        int x;
        int y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        arr = new int[N][M];
        dp = new int[N][M];
        for(int i = 0; i < N; i++){
            Arrays.fill(dp[i], -1);
            input = br.readLine().split(" ");
            for(int j = 0; j < M; j++){
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }

        System.out.println(sol(N-1, M-1));
    }
    private static void print(int[][] ls){
        for(int i = 0; i < ls.length; i++){
            System.out.println(Arrays.toString(ls[i]));
        }
    }
    private static int sol(int n, int m){
        if(n == 0 && m == 0) return 1;

        if(dp[n][m] != -1) return dp[n][m];

        dp[n][m] = 0;

        for(int idx = 0; idx < 4; idx++){
            int nx = n + dx[idx];
            int ny = m + dy[idx];
            if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
            if(arr[n][m] >= arr[nx][ny]) continue;
            dp[n][m] += sol(nx, ny);
        }
        return dp[n][m];
    }
}