import java.util.*;
import java.io.*;


public class Main {
    static int N;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        int[] dp = new int[N];

        dp[0] = Integer.parseInt(input[0]);
        int answer = dp[0];
        for(int i = 1; i < N; i++){
            dp[i] = Math.max(dp[i-1] + Integer.parseInt(input[i]), Integer.parseInt(input[i]));
            answer = Math.max(answer, dp[i]);
        }
        System.out.println(answer);


    }
}