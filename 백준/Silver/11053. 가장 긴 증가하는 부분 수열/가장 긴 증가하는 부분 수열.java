import java.util.*;
import java.io.*;


public class Main {
    static int N, dp[], arr[];
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        dp = new int[N];
        Arrays.fill(dp, 1);
        arr = new int[N];
        String[] input = br.readLine().split(" ");

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(input[i]);
        }
        int answer = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < i; j++){
                if(arr[j] < arr[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            answer = Math.max(answer, dp[i]);
        }
        
        System.out.println(answer);

    }
}