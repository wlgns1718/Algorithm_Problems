import java.util.*;
import java.io.*;


public class Main {
    static int N,M,dp[][],sum[],arr[];
    static boolean[][] visit;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N+1];
        sum = new int[N+1];
        dp = new int[N+1][M+1];
        visit = new boolean[N+1][M+1];

        for(int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(br.readLine());

            sum[i] = sum[i-1] + arr[i];
        }
        System.out.println(sol(N,M));



    }
    private static int sol(int n, int m){
        if(m == 0) return 0;
        if(n < 2 * m - 1) return -32768 * 100;
        if(visit[n][m]) return  dp[n][m];

        visit[n][m] = true;
        dp[n][m] = sol(n - 1, m);

        for(int i = n; i >= 1; i--){
            dp[n][m] = Math.max(dp[n][m], sum[n] - sum[i-1] + sol(i-2,m-1));
        }

        return dp[n][m];
    }


}