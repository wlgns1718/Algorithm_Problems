import java.io.*;
import java.util.*;

class Main {
    static int N;
    static boolean[] vip;
    static int[] dp = new int[41];
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 1;

        N = Integer.parseInt(br.readLine());
        int T = Integer.parseInt(br.readLine());
        vip = new boolean[N];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= 40; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        
        for(int i = 0; i < T; i++){
            int n = Integer.parseInt(br.readLine()) - 1;
            vip[n] = true;
        }
        int temp = 0;
        for(boolean b : vip){
            if(b){
                answer *= dp[temp];
                temp = 0;
            }
            else{
                temp++;
            }
        }
        if(temp != 0) answer *= dp[temp];
        System.out.println(answer);
    }
}