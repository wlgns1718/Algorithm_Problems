import java.io.*;

class Main {
    static int T, N, dp[] = new int[191230];
    static final int MOD = 1_000_000_007;
    public static void main(String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        for(int i = 4; i <= 191229; i++){
            dp[i] = (dp[i-1] + dp[i-2]) % MOD;
        }
        for(int i = 0; i < T; i++){
            N = Integer.parseInt(br.readLine());
            sb.append(dp[N]).append("\n");
        }
        System.out.println(sb);
    }
}