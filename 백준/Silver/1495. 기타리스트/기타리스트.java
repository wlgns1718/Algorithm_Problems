import java.io.*;
import java.util.*;

class Main {
    static int N, S, M;
    static int[] V;
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        S = Integer.parseInt(input[1]);
        M = Integer.parseInt(input[2]);

        V = new int[N];
        boolean[][] dp = new boolean[N+1][M+1];

        input = br.readLine().split(" ");
        for(int i = 0; i < N; i++){
            V[i] = Integer.parseInt(input[i]);
        }
        dp[0][S] = true;
        int answer = -1;
        boolean flag = false;

        Loop:
        for(int i = 1; i <= N; i++){
            int v = V[i-1];
            flag = false;
            for(int j = 0; j <= M; j++){
                if(dp[i-1][j]){
                    if(j + v <= M){
                        flag = true;
                        dp[i][j + v] = true;
                    }
                    if(j - v >= 0){
                        flag = true;
                        dp[i][j - v] = true;
                    }
                }
            }
            if(!flag) break Loop;
        }

        if(flag){
            for(int i = M; i >= 0; i--){

                if(dp[N][i]){
                    answer = i;
                    break;
                }

            }
        }
        System.out.println(answer);
    }
}