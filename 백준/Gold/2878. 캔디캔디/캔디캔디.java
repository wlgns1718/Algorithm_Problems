import java.util.*;
import java.io.*;

public class Main {
    static final long MOD = (long)18_446_744_073_709_551_616D;
    static int M, N,end = 0;
    static long answer = 0;
    static long sum = 0, arr[];
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new long[N];
        for(int i = 0; i < N; i++){
            arr[i] = Long.parseLong(br.readLine());
            sum += arr[i];
        }
        Arrays.sort(arr);
        sum -= M;
        long temp;
        for(int i = 0; i < N; i++){
            temp = Math.min(arr[i], sum/(N-i));
            sum -= temp;
            answer += (temp * temp);
            answer %= MOD;
        }
        System.out.println(answer);
    }

}