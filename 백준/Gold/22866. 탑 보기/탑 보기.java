import java.io.*;
import java.util.*;

public class Main {

    static Stack<Data> left = new Stack<>();
    static Stack<Data> right = new Stack<>();
    static int idx;
    static int[] arr, left_cnt, right_cnt, leftIdx, rightIdx;
    static class Data{
        int idx;
        int height;

        public Data(int idx, int height){
            this.idx = idx;
            this.height = height;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "idx=" + idx +
                    ", height=" + height +
                    '}';
        }
    }
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //건물의 개수
        int N = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");

        arr = new int[N];
        left_cnt = new int[N];
        right_cnt = new int[N];
        leftIdx = new int[N];
        rightIdx = new int[N];

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(input[i]);
        }
        left.add(new Data(0,arr[0]));
        right.add(new Data(N-1,arr[N-1]));
        idx = N - 1;

        for(int i = 1; i < N; i++){
            //왼쪽에서 오른쪽
            sol_left(i);

            //오른쪽에서 왼쪽
            sol_right(i);
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        leftIdx[0] = Integer.MAX_VALUE;
        rightIdx[idx] = Integer.MAX_VALUE;
        for(int i = 0; i < N; i ++){
            if(right_cnt[i] + left_cnt[i] == 0){
                bw.write(0 +"\n");
                continue;
            }
            bw.write(right_cnt[i] + left_cnt[i] + " ");
            if(Math.abs(rightIdx[i] - i) == Math.abs(i - leftIdx[i])){
                bw.write(""+ (leftIdx[i] + 1));
            }
            else{
                if(Math.abs(rightIdx[i] - i) < Math.abs(i - leftIdx[i])){
                    bw.write(""+ (rightIdx[i] + 1));
                }
                else{
                    bw.write(""+ (leftIdx[i] + 1));
                }
            }
            bw.write("\n");
        }
        bw.flush();
    }
    private static void sol_left(int i){

        if(arr[i] >= left.peek().height){
            while(arr[i] >= left.peek().height){
                //기저조건
                left.pop();
                if(left.isEmpty()){
                    left.add(new Data(i,arr[i]));
                    left_cnt[i] = 0;
                    leftIdx[i] = Integer.MAX_VALUE;
                    return;
                }
            }
            left_cnt[i] = left.size();
            leftIdx[i] = left.peek().idx;
            left.add(new Data(i, arr[i]));
        }
        else{
            left_cnt[i] = left.size();
            leftIdx[i] = left.peek().idx;
            left.add(new Data(i,arr[i]));
        }
    }
    private static void sol_right(int i){

        if(arr[idx-i] >= right.peek().height){

            while(arr[idx - i] >= right.peek().height){
                //기저조건
                right.pop();
                if(right.isEmpty()){
                    right.add(new Data(idx - i,arr[idx - i]));
                    right_cnt[idx - i] = 0;
                    return;
                }
            }
            rightIdx[idx - i] = right.peek().idx;
            right_cnt[idx-i] = right.size();
            right.add(new Data(idx - i, arr[idx - i]));
        }
        else{
            right_cnt[idx - i] = right.size();
            rightIdx[idx - i] = right.peek().idx;
            right.add(new Data(idx - i,arr[idx - i]));
        }
    }

}