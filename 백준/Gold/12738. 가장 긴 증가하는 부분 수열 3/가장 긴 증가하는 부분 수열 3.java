import java.util.*;
import java.io.*;


public class Main {
    static int N, arr[];
    static int[] lis;
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        arr = new int[N];
        lis = new int[N];
        int idx = 0;
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(input[i]);
        }
        lis[idx++] = arr[0];
        for(int i = 1; i < N; i++){
            if(lis[idx-1] < arr[i]){
                lis[idx++] = arr[i];
            }
            else{
                change(arr[i], idx);
            }
        }
        System.out.println(idx);

    }
    private static void change(int num, int idx){
        int start = 0;
        int end = idx - 1;
        while(start < end){
            int mid = (start + end)/2;
            if(lis[mid] >= num){
                end = mid;
            }
            else{
                start = mid + 1;
            }
        }
        lis[end] = num;
    }
}