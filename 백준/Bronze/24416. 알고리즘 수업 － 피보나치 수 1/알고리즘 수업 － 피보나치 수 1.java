import java.util.*;
import java.io.*;


public class Main {
    static int N, ans1, ans2;
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        code1(N);
        code2(N);
        System.out.println(ans1+" "+ans2);
    }
    private static int code1(int num){
        if(num == 1 || num == 2){
            ans1++;
            return 1;
        }
        else{
            return code1(num-1) + code1(num - 2);
        }
    }
    private static void code2(int num){
        int[] dp = new int[num+1];
        dp[1] = 1;
        dp[2] = 1;
        for(int i = 3; i <= num; i++){
            dp[i] = dp[i-1] + dp[i-2];
            ans2++;
        }
    }
}