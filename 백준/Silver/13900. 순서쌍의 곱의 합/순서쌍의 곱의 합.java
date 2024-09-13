import java.io.*;
import java.util.*;

class Main {
    static int N, nums[], prefix[];
    static long answer = 0;
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        prefix = new int[N];
        String[] input = br.readLine().split(" ");
        for(int i = 0; i < N; i++){
            nums[i] = Integer.parseInt(input[i]);
            if(i == 0) prefix[i] = nums[i];
            else prefix[i] = prefix[i-1] + nums[i];
        }
        for(int i = 0; i < N; i++){
            answer += ((long) nums[i] * (prefix[N-1] - prefix[i]));
        }
        System.out.println(answer);
    }

}