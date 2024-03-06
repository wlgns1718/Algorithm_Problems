import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static double pre_right, cur_right, pre_left, cur_left;
    static int answer = 0;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        String[] input = br.readLine().split(" ");
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(input[i]);
        }
        
        for(int i = 0; i < N; i++){
            pre_right = Integer.MAX_VALUE;
            cur_right = Integer.MAX_VALUE;
            pre_left = Integer.MAX_VALUE;
            cur_left = Integer.MAX_VALUE;
            int right_cnt = 0;
            //오른쪽 계산
            for(int r = i + 1; r < N; r++){
                cur_right = cal(i + 1, arr[i], r + 1, arr[r]);
                if(pre_right == Integer.MAX_VALUE || pre_right < cur_right){
                    right_cnt ++;
                    pre_right = cur_right;
                }

            }
            int left_cnt = 0;
            //왼쪽 계산
            for(int l = i - 1; l >= 0; l--){
                cur_left = cal(l + 1, arr[l], i + 1, arr[i]);
                if(pre_left == Integer.MAX_VALUE || pre_left > cur_left){
                    left_cnt ++;
                    pre_left = cur_left;
                }
            }
            if(answer < (right_cnt + left_cnt)){
                answer = right_cnt + left_cnt;
            }
        }
        System.out.println(answer);
    }
    private static double cal(int x1, int y1, int x2, int y2){
        return (double) (y2 - y1) / (x2 - x1);
    }

}