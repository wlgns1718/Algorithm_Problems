import java.util.*;
import java.io.*;


public class Main {
    static int N, K, T;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);
        T = Integer.parseInt(input[2]);
        long sum = 0L;
        input = br.readLine().split(" ");
        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(input[i]);
            sum += arr[i];
        }
        if(sum % K != 0){
            System.out.println("NO");
            return;
        }
        Arrays.sort(arr);
//        System.out.println(Arrays.toString(arr));

        int start = 0;
        int end = N - 1;
        long cnt = 0;
        int temp = 0;

        while(start < end){
            temp = arr[start];
            arr[start] = 0;

            while(temp > 0 && start < end){
                if(arr[end] + temp >= K){
                    temp -= (K - arr[end]);
                    cnt += (K - arr[end]);
                    arr[end] += (K - arr[end]);
                    if(arr[end] == K) arr[end] = 0;
                    end--;
                }
                else{
                    arr[end] += temp;
                    cnt += temp;
                    temp = 0;
                }
            }
            start++;
        }
//        System.out.println(Arrays.toString(arr));
        if(arr[end] != 0 || temp != 0 || cnt > T){
            System.out.println("NO");
        }
        else{
            System.out.println("YES");
        }
    }
}