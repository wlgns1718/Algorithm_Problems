import java.util.*;

class Solution {
    static int[][] dp;
    public int solution(int[][] matrix_sizes) {
        int answer = 0;
        int n = matrix_sizes.length;
        dp = new int[n][n];
        
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            dp[i][i] = 0;
        }
        //dp[x][y] = x 부터 y까지의 곱 연산 최소값
        //범위가 1부터 n까지 값을 설정
        for(int i = 1; i < n; i++){
            for(int j = 0; j < n - i; j++){
                int ny = i + j; //확인할 범위(1 부터 n 까지)
                for(int t = j; t < ny; t++){
                    //j 부터 j + 범위 확인
                    //(A,B,C,D)에서 (A,B)*(C,D) 와 (A,B,C) * D는 다를 수 있다.
                    dp[j][ny] = Math.min(dp[j][ny],
                                        dp[j][t] + dp[t+1][ny] + 
                                         matrix_sizes[j][0] * matrix_sizes[t][1] * matrix_sizes[ny][1]);
                    
                }
            }
        }
        answer = dp[0][n-1];
        return answer;
    }
}