import java.io.*;
import java.util.*;

public class Main {
    static int[] dp;
    static int mod = 1000000;
    static boolean tri = true;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String password = st.nextToken();

        int n = password.length();
        dp = new int[n + 1];
        dp[0] = 1;
        sol(password);
        if(!tri){
            System.out.println(0);
        }
        else{
            System.out.println(dp[n]);
        }


//        System.out.println(Arrays.toString(dp));
    }
    private static void sol(String word){

        for(int i = 0; i < word.length(); i++){

            if(i == 0){
                if(word.charAt(i) == '0'){
                    tri = false;
                    return;
                }
                dp[i + 1] = 1;
                continue;
            }
            // 현재 수가 0인지 아닌지 판단
            if(word.charAt(i) != '0'){
                dp[i + 1] += dp[i];
            }
            //이전 수와 합쳐서 26 이하인지 확인(단, 이전수가 0일 경우에는 continue)
            if(word.charAt(i-1) != '0'){
                int temp = Integer.parseInt(word.substring(i-1, i+1));

                if(temp < 27){
                    dp[i + 1] += dp[i-1];
                }
            }
            dp[i+1] %= mod;
        }
    }
}