import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static long[][][] dp;
    static final int MOD = 1_000_000_000;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        dp = new long[N][10][1 << 10];
        //맨 앞자리 1 부터 9 까지 넣어주기
        for(int i = 1; i < 10; i++){
            dp[0][i][1 << i] = 1;
        }

        for(int i = 1; i < N; i++){
            for(int j = 0; j < 10; j++){
                int bit = 1 << j;
                for(int b = 0; b < 1024; b++){
                    if(j > 0){
                        dp[i][j][b | bit] = (dp[i][j][b | bit] + dp[i-1][j-1][b]) % MOD;
                    }
                    if(j < 9){
                        dp[i][j][b | bit] = (dp[i][j][b | bit] + dp[i-1][j + 1][b]) % MOD;
                    }
                }

            }
        }
        long answer = 0;
        for(int i = 0; i < 10; i++){
            answer = (answer + dp[N-1][i][1023]) % MOD;
        }
        System.out.println(answer);
    }
}