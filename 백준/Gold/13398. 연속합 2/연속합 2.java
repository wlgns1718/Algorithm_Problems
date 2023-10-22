import java.util.*;
import java.io.*;


public class Main {

    public static void main(String[] args) throws Exception {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] num = new int[N];
        for(int i =0; i < N; i++ ){
            num[i] = Integer.parseInt(st.nextToken());
        }
        int[][] dp = new int[N][2];
        int answer = num[0];
        dp[0][0] = num[0];
        dp[0][1] = 0;
        for(int i = 1; i < N; i++){
            dp[i][0] = Math.max(dp[i-1][0] + num[i], num[i]);
            dp[i][1] = Math.max(dp[i-1][0],dp[i-1][1] + num[i]);
            answer = Math.max(answer,Math.max(dp[i][0],dp[i][1]));
        }
        System.out.println(answer);
    }

}