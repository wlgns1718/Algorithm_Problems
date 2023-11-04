import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static String word1, word2;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        word1 = br.readLine();
        word2 = br.readLine();

        int len1 = word1.length();
        int len2 = word2.length();
        int answer = 0;
        int[][] dp = new int[len1 + 1][len2 + 1];

        for(int i = 1; i <= len1; i++){
            for(int j = 1; j <= len2; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                    answer = Math.max(answer, dp[i][j]);
                }
            }
        }

        System.out.println(answer);
    }
}