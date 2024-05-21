import java.util.*;
import java.io.*;

public class Main {
    static int N, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    static int[] nums, oper, select;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        nums = new int[N];
        oper = new int[4];
        select = new int[N-1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++){
            oper[i] = Integer.parseInt(st.nextToken());
        }
        sol(0);
        System.out.println(max);
        System.out.println(min);
    }
    private static void sol(int idx){
        if(idx == N-1){
            int res = nums[0];
            for(int i = 1; i < N; i++){
                int temp = select[i-1];
                if(temp == 0){
                    res += nums[i];
                } else if (temp == 1) {
                    res -= nums[i];
                }
                else if (temp == 2){
                    res *= nums[i];
                }else{
                    res /= nums[i];
                }
            }
            max = Math.max(max, res);
            min = Math.min(min, res);
            return;
        }

        for(int j = 0; j < 4; j++){
            if(oper[j] > 0){
                oper[j] --;
                select[idx] = j;
                sol(idx + 1);
                oper[j] ++;
            }
        }
    }
}