import java.util.*;
import java.io.*;

public class Main {
    static final long MOD = (long) 18_446_744_073_709_551_616f;
    static int M, N, arr[],end = 0;
    static long answer = 0;
    static long sum = 0;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
            end = Math.max(end, arr[i]);
        }
        Arrays.sort(arr);
        sum -= M;
        long temp;
        for(int i = 0; i < N; i++){
            temp = Math.min(arr[i], sum/(N-i));
            sum -= temp;
            answer += (temp * temp) % MOD;
        }
        System.out.println(answer);
    }

}