import java.io.*;
import java.util.*;

class Main {
    static int A, B, arr[], brr[];
    static String pw;
    static long answer = 0;
    public static void main(String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        Set<Integer> a = new HashSet<>();
        Set<Integer> b = new HashSet<>();
        A = Integer.parseInt(input[0]);
        B = Integer.parseInt(input[1]);
        input = br.readLine().split(" ");

        arr = new int[A];
        for(int i = 0; i < A; i++){
            arr[i] = Integer.parseInt(input[i]);
            a.add(arr[i]);

        }
        input = br.readLine().split(" ");
        brr = new int[B];
        for(int i = 0; i < B; i++){
            brr[i] = Integer.parseInt(input[i]);
            b.add(brr[i]);
        }
        int a_cnt = 0;
        int b_cnt = 0;
        for(int i = 0; i < A; i++){
            if(!b.contains(arr[i])) a_cnt ++;
        }
        for(int i = 0; i < B; i++){
            if(!a.contains(brr[i])) b_cnt ++;
        }
        System.out.println(a_cnt + b_cnt);
    }
}