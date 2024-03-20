import java.io.*;
import java.util.*;

public class Main {
    static int[] dp = new int[12];

    public static void main (String[] operations) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for(int i = 4; i <= 11; i++){
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++){
            sb.append(dp[Integer.parseInt(br.readLine())]).append("\n");
        }
        System.out.println(sb);
    }

}