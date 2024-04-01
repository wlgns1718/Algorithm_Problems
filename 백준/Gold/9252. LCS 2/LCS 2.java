import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String word1 = br.readLine();
        String word2 = br.readLine();

        int N = word1.length();
        int M = word2.length();
        int[][] dp = new int[N][M];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(word1.charAt(i) == word2.charAt(j)){
                    if(i == 0 || j == 0){
                        dp[i][j] = 1;
                    }
                    else{
                        dp[i][j] = dp[i-1][j-1] + 1;
                    }
                }
                else{
                    if(i == 0 && j == 0){
                        dp[i][j] = 0;
                    }
                    else if(i == 0){
                        dp[i][j] = dp[i][j-1];
                    }
                    else if(j == 0){
                        dp[i][j] = dp[i-1][j];
                    }
                    else{
                        dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                    }
                }
            }
        }

        int i = N-1;
        int j = M-1;
        
        while(i >= 0 && j >= 0){
            if(word1.charAt(i) == word2.charAt(j)){
                sb.append(word1.charAt(i));
                i--;
                j--;
            }
            else{
                if(i == 0 && j == 0) break;
                
                else if(i == 0){
                    j--;
                }
                else if(j == 0){
                    i --;
                }
                else{
                    if(dp[i-1][j] > dp[i][j-1]){
                        i--;
                    }
                    else{
                        j--;
                    }
                }

            }
        }
        System.out.println(dp[N-1][M-1]);
        sb.reverse();
        System.out.println(sb);
    }
}