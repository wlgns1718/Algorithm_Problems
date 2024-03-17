import java.util.*;
import java.io.*;

/* Online Java Compiler and Editor */
public class Main {

    static int N, M, memory[], cost[], dp[][];
    public static void main(String []args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        memory = new int[N];
        cost = new int[N];

        input = br.readLine().split(" ");
        for(int i = 0; i < N; i++){
            memory[i] = Integer.parseInt(input[i]);
        }

        input = br.readLine().split(" ");
        int temp = 0;
        for(int i = 0; i < N; i++){
            cost[i] = Integer.parseInt(input[i]);
            temp += cost[i];
        }
        dp = new int[N][temp+1];

        int c0 = cost[0];
        for(int j = 0; j <= temp; j++){
            if(j - c0 < 0) continue;
            dp[0][j] = memory[0];
        }

        int answer = 0;
        for(int i = 1; i < N; i++){
            int c = cost[i];
            for(int j = 0; j <= temp; j++){
                if(j - c < 0){
                    dp[i][j] = dp[i-1][j];
                    continue;
                }
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - c] + memory[i]);
            }
        }

        for(int i = 0; i <= temp; i++){
            if(dp[N-1][i] >= M){
                System.out.println(i);
                break;
            }
//            System.out.println(Arrays.toString(dp[i]));
        }

    }
}