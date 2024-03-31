import java.util.*;
import java.io.*;

public class Main {

    static int N, K, arr[], brr[];
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        arr = new int[101];
        brr = new int[101];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cnt = 0;

        for(int i = 0; i < K; i++){

            int a = Integer.parseInt(st.nextToken());

            if(cnt < N || arr[a] != 0){
                if(arr[a] == 0){
                    brr[a] = i;
                    arr[a] ++;
                    cnt ++;
                }else{
                    arr[a] ++;
                }

            }
            else{

                int idx = 10000000;
                int val = 10000000;
                int del_idx = 0;

                for(int p = 1; p < 101; p++){

                    if(arr[p] == 0) continue;
                    if(val >= arr[p]){
                        if(val == arr[p]){
                            if(idx > brr[p]){
                                idx = brr[p];
                                del_idx = p;
                            }
                        }
                        else{
                            val = arr[p];
                            idx = brr[p];
                            del_idx = p;
                        }
                    }
                }
                arr[del_idx] = 0;
                arr[a] ++;
                brr[a] = i;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < 101; i++){
            if(arr[i] != 0){
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb);
    }
}