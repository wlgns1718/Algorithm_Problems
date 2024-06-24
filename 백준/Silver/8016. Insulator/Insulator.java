import java.util.*;
import java.io.*;

public class Main {
    static int answer = 0;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(br.readLine());
            answer += num;
            arr[i] = num;
        }
        Arrays.sort(arr);
        int end = N >> 1;
        for(int i = 0; i < end; i++){
            answer += arr[N-1-i] - arr[i];
        }
        System.out.println(answer);
    }

}