import java.io.*;
import java.util.*;

class Main {
    static int N, M;
    static long[] nums;
    public static void main(String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        nums = new long[N];
        input = br.readLine().split(" ");
        for(int i = 0; i < N; i++){
            nums[i] = Long.parseLong(input[i]);
        }
        Arrays.sort(nums);

        for(int i = 0; i < M; i++){
            input = br.readLine().split(" ");
            if(input[0].equals("1")){
                long k = Long.parseLong(input[1]);
                int target = find_idx_equal(k);
                if(target >= N) sb.append(0).append("\n");
                else if(nums[target] >= k) sb.append(N-target).append("\n");
                else sb.append(N - 1 - target).append("\n");

            }
            else if(input[0].equals("2")){
                long k = Long.parseLong(input[1]);
                int target = find_idx_not_equal(k);

                if(target >= N) sb.append(0).append("\n");
                else if(nums[target] > k) sb.append(N-target).append("\n");
                else sb.append(N - 1 - target).append("\n");
            }
            else{
                long s = Long.parseLong(input[1]);
                long e = Long.parseLong(input[2]);

                int s_idx = find_idx_equal(s);
                int e_idx = find_idx_not_equal(e);
                if(e_idx >= N) e_idx = N-1;
                if(s_idx >= N) sb.append(0).append("\n");
                else if(nums[e_idx] > e){
                    sb.append(e_idx - s_idx).append("\n");
                }
                else{
                    sb.append(e_idx - s_idx + 1).append("\n");
                }
            }

        }
        System.out.println(sb);
    }
    private static int find_idx_equal(long target){

        int start = 0;
        int end = N-1;
        int res = 0;

        while(start <= end){
            int mid = (start + end) / 2;
            if(nums[mid] >= target){
                res = mid;
                end = mid - 1;
            }
            else{
                start = mid + 1;
                res = start;
            }
        }
        return res;
    }
    private static int find_idx_not_equal(long target){

        int start = 0;
        int end = N-1;
        int res = 0;

        while(start <= end){
            int mid = (start + end) / 2;
            if(nums[mid] > target){
                res = mid;
                end = mid - 1;
            }
            else{
                start = mid + 1;
                res = start;
            }
        }
        return res;
    }
}