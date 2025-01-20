class Solution {
    public long solution(int[] sequence) {
        long answer = Long.MIN_VALUE;
        long[][] dp = new long[sequence.length][2];
        dp[0][0] = -sequence[0]; //0은 음수
        dp[0][1] = sequence[0];
        answer = Math.max(answer, dp[0][0]);
        answer = Math.max(answer, dp[0][1]);
        for(int i = 1; i < sequence.length; i++){
            //현재 i 값을 +로 하는 경우
            dp[i][1] = Math.max(dp[i-1][0] + sequence[i], sequence[i]);
            //현재 i 값을 -로 하는 경우
            dp[i][0] = Math.max(dp[i-1][1] - sequence[i], -sequence[i]);
            
            answer = Math.max(answer, dp[i][0]);
            answer = Math.max(answer, dp[i][1]);
        }
        
        return answer;
    }
}