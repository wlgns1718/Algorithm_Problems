import java.util.*;
import java.io.*;

public class Main {
    static int N, nums[];
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        String[] input = br.readLine().split(" ");
        long sum = 0;
        for(int i = 0; i < N; i++){
            nums[i] = Integer.parseInt(input[i]);
            sum += nums[i];
        }
        Arrays.sort(nums);
        int idx = N % 2 == 0 ?  N/2 - 1 : N/2;
        sb.append(nums[idx]).append(" ");
        if(sum % N == 0){
            sb.append(sum/N);
        }
        else{
            long case1 = sum/N;
            long case2 = sum/N + 1;
            long answer = 0;
            long total1 = 0;
            long total2 = 0;
            for(int i = 0; i < N; i++){
                total1 += (long) Math.pow((nums[i] - case1), 2);
                total2 += (long) Math.pow((nums[i] - case2), 2);

            }
            answer = (total1 <= total2) ? case1 : case2;
            sb.append(answer);
        }
        System.out.println(sb);
    }
}