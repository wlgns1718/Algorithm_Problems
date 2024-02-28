import java.io.*;
import java.util.*;

public class Main {
    static int[][] dp;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());

        dp = new int[10001][3];
        init();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 0; i < TC; i++){
            int n = Integer.parseInt(br.readLine());
            bw.write((dp[n][0] + dp[n][1] + dp[n][2]) + "\n");
        }

        bw.flush();
    }
    private static void init(){

        dp[1][0] = 1;
        dp[1][1] = 0;
        dp[1][2] = 0;

        dp[2][0] = 1;
        dp[2][1] = 1;
        dp[2][2] = 0;

        dp[3][0] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;

        for(int i = 4; i <= 10000; i++){

            dp[i][0] = 1;
            dp[i][1] = dp[i-2][0] + dp[i-2][1];
            dp[i][2] = dp[i-3][0] + dp[i-3][1] + dp[i-3][2];
        }
    }

}