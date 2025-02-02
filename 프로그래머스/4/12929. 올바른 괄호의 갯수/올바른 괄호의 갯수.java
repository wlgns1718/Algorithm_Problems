class Solution {
    public int solution(int n) {
        int answer = 0;
        int[] dp = new int[15];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;
        for(int i = 4; i <= 14; i++){
            for(int j = 0; j < i; j++){
                dp[i] += dp[j] * dp[i-j-1];
            }
        }
        answer = dp[n];
        return answer;
    }
}