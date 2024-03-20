import java.io.*;
import java.util.*;

public class Main {
    static int[] dp = {1, 2, 4, 7, 13, 24, 44, 81, 149, 274, 504};

    public static void main (String[] operations) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int a;
        for(int i = 0; i < N; i++){
            a = Integer.parseInt(br.readLine()) - 1;
            sb.append(dp[a]).append("\n");
        }
        System.out.println(sb);
    }

}