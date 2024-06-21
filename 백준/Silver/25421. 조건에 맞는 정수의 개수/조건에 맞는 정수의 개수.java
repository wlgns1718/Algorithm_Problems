import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static long[][] arr;
    static final int MOD = 987_654_321;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        arr = new long[N][9];

        for(int i = 0; i < 9; i++){
            arr[0][i] ++;
        }
        for(int i = 1; i < N; i++){
            for(int j = 0; j < 9; j++){
                for(int p = j-2; p <= j+2; p++){
                    if(p >= 0 && p <= 8){
                        arr[i][j] += arr[i-1][p];
                        arr[i][j] %= MOD;
                    }
                }
            }
        }
        long answer = 0;
        for(int i = 0; i < 9; i++){
            answer = (answer + arr[N-1][i]) % MOD;
        }
        System.out.println(answer);
    }
}