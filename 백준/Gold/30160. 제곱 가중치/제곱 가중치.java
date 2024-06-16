import java.util.*;
import java.io.*;

public class Main {
    static int N, arr[];
    static boolean[] visit;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        String[] input = br.readLine().split(" ");
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(input[i]);
        }
        long[] prefix = new long[N];
        long[] val = new long[N];
        prefix[0] = arr[0];
        val[0] = arr[0];
        long[] answer = new long[N];
        for(int i = 1; i < N; i++){
            prefix[i] = prefix[i-1] + arr[i];
            val[i] = val[i - 1] + (2L * i + 1) * arr[i];
        }
        answer[0] = arr[0];
        for(int i = 1; i < N; i++){
            int temp = i + 1;
            long preval = answer[i-1];
            long result = 2 * temp * prefix[i] - val[i];
            answer[i] = preval + result;
        }
        for(long a : answer){
            sb.append(a).append(" ");
        }
        System.out.println(sb);
    }
}