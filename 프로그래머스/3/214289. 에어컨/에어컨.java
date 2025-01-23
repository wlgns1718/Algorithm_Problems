import java.util.*;

class Solution {
    static int[][] dp;
    static final int K = 30;
    
    public int solution(int temperature, int t1, int t2, int a, int b, int[] onboard) {
        int answer = Integer.MAX_VALUE;
        
        dp = new int[onboard.length][101];
        for(int i = 0; i < onboard.length; i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][temperature + K] = 0;
        for(int i = 0; i < onboard.length - 1; i++){
            if(onboard[i] == 1){
                isBoard(i, t1, t2, a, b, temperature);
            }else{
                notBoard(i, temperature, a, b);
            }

        }
        if(onboard[onboard.length-1] == 1){
             for(int i = t1+K; i <= t2+K; i++){
                answer = Math.min(answer, dp[onboard.length-1][i]);
            }
        }
        else{
             for(int i = 0; i <= 100; i++){
                answer = Math.min(answer, dp[onboard.length-1][i]);
            }
        }
       
        return answer;
    }
     private static void isBoard(int i, int t1, int t2, int a, int b, int temp){
        for(int j = t1 + K; j <= t2 + K; j++){
            if(dp[i][j] != Integer.MAX_VALUE) {
                if (j < temp + K) {
                    dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + b);
                    dp[i+1][j+1] = Math.min(dp[i+1][j+1], dp[i][j]);
                    if(j-1 >= 0) dp[i+1][j-1] = Math.min(dp[i+1][j-1], dp[i][j] + a);
                    
                } else if (j > temp + K) {
                    dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + b);
                    if(j+1 <= 100)dp[i+1][j+1] = Math.min(dp[i+1][j+1], dp[i][j] + a);
                    dp[i+1][j-1] = Math.min(dp[i+1][j-1], dp[i][j]);
                } else {
                    dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j]);
                    dp[i + 1][j + 1] = Math.min(dp[i + 1][j + 1], dp[i][j] + a);
                    dp[i + 1][j - 1] = Math.min(dp[i + 1][j - 1], dp[i][j] + a);
                }
            }
        }
    }
    
    private static void notBoard(int i, int temp, int a, int b){
        for(int j = 0; j <= 100; j++){
            if(dp[i][j] != Integer.MAX_VALUE){
                if(j == temp + K){
                    dp[i+1][j] = Math.min(dp[i][j], dp[i+1][j]);
                    dp[i+1][j+1] = Math.min(dp[i+1][j+1], dp[i][j] + a);
                    dp[i+1][j-1] = Math.min(dp[i+1][j-1], dp[i][j] + a);
                }
                else{
                    dp[i+1][j] = Math.min(dp[i+1][j], dp[i][j] + b);
                    if(j > temp + K){
                        dp[i+1][j-1] = Math.min(dp[i+1][j-1], dp[i][j]);
                        if(j+1 <= 100) dp[i+1][j+1] = Math.min(dp[i+1][j+1], dp[i][j] + a);
                    }

                    else if(j < temp + K){
                        if(j - 1 >= 0)dp[i+1][j-1] = Math.min(dp[i+1][j-1], dp[i][j] + a);
                        dp[i+1][j+1] = Math.min(dp[i+1][j+1], dp[i][j]);
                    }
                }
            }

        }
    }
}