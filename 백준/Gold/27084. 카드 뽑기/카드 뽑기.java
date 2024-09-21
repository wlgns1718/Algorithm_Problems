import java.io.*;
import java.util.*;

class Main {
    static long answer = 1L;
    static int N, arr[];
    static final int MOD = 1_000_000_007;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];

        String[] input = br.readLine().split(" ");
        for(int i = 0; i < input.length; i++){
            int idx = Integer.parseInt(input[i]);
            arr[idx]++;
        }

        for(int i = 1; i <= N; i++){
            answer = (answer * (arr[i] + 1)) % MOD;
        }
        System.out.println(answer - 1);

    }

}