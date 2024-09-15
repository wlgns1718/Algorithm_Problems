import java.io.*;
import java.util.*;

class Main {
    static int N;
    static char[] arr;
    static int[] dp;
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new char[N];
        dp = new int[N];
        Arrays.fill(dp, 123456789);
        dp[0] = 0;
        String street = br.readLine();
        for(int i = 0; i < N; i++){
            arr[i] = street.charAt(i);
        }
        for(int i = 0; i < N-1; i++){
            sol(arr[i], i);
        }
        if(dp[N-1] == 123456789) System.out.println(-1);
        else System.out.println(dp[N-1]);
    }
    private static void sol(char c, int idx){
        if(c == 'B'){
            for(int i = idx + 1; i < N; i++){
                if(arr[i] != 'O') continue;
                dp[i] = Math.min(dp[i], dp[idx] + ((i - idx) * (i - idx)));
            }
        }
        else if(c == 'O'){
            for(int i = idx + 1; i < N; i++){
                if(arr[i] != 'J') continue;
                dp[i] = Math.min(dp[i], dp[idx] + ((i - idx) * (i - idx)));
            }

        }else{
            for(int i = idx + 1; i < N; i++){
                if(arr[i] != 'B') continue;
                dp[i] = Math.min(dp[i], dp[idx] + ((i - idx) * (i - idx)));
            }

        }
    }


}