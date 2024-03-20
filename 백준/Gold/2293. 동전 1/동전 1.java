import java.io.*;
import java.util.*;

public class Main {

    static int n, k, dp[], arr[];
    public static void main (String[] operations) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        dp = new int[k+1];
        arr = new int[n];

        for(int i = 0; i < n; i++){
            int a = Integer.parseInt(br.readLine());
            arr[i] = a;
        }

        for(int a : arr){
            if(a <= k){
                dp[a] += 1;
            }
            for(int i = a + 1; i <= k; i++){
                dp[i] += dp[i-a];
            }
//            System.out.println(Arrays.toString(dp));
        }
        System.out.println(dp[k]);
    }

}