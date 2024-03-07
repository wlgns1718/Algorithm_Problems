import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static int N, answer = 0;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        for(int i = 0; i < N; i++){
            sol(i);
        }
        System.out.println(answer);
    }
    private static void sol(int idx){

        int start = 0;
        int end = N - 1;
        int target = arr[idx];

        while(start < end){
            if(start == idx){
                start ++;
                continue;
            }
            if(end == idx){
                end--;
                continue;
            }
            int val = arr[start] + arr[end];
            if(val < target){
                //start를 올리기
                start ++;
            }
            else if(val > target){
                end --;
            }
            else{
                answer++;
                return;
            }
        }
    }
}