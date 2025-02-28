class Solution {
    static final int MOD = 1_000_000_007;
    public int solution(int n) {
        int answer = 0;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for(int i = 4; i <= n; i++){
            dp[i] = (dp[i-1] + dp[i-2]) % MOD;
        }
        return dp[n];
    }
}