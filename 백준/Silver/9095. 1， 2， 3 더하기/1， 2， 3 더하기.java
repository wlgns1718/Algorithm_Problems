import java.io.*;
import java.util.*;

public class Main {
    static int[] dp = {0, 1, 2, 4, 7, 13, 24, 44, 81, 149, 274, 504};

    public static void main (String[] operations) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            sb.append(dp[Integer.parseInt(br.readLine())]).append("\n");
        }
        System.out.println(sb);
    }

}