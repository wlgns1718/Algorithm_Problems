import java.io.*;
import java.util.*;

public class Main {

    static long[] xrr, yrr;
    static int answer = 0, N, arr[];
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        xrr = new long[N];
        yrr = new long[N];
        arr = new int[3];
        for(int i = 0; i < N; i++){
            String[] input = br.readLine().split(" ");
            xrr[i] = Long.parseLong(input[0]);
            yrr[i] = Long.parseLong(input[1]);
        }
        sol(0,0);
        System.out.println(answer);
    }
    private static void sol(int idx, int start){

        if(idx == 3){
            long x1 = xrr[arr[0]];
            long y1 = yrr[arr[0]];
            long x2 = xrr[arr[1]];
            long y2 = yrr[arr[1]];
            long x3 = xrr[arr[2]];
            long y3 = yrr[arr[2]];
            
            long l1 = (x1-x2) * (x1-x2) + (y1-y2) * (y1-y2);
            long l2 = (x1-x3) * (x1-x3) + (y1-y3) * (y1-y3);
            long l3 = (x2-x3) * (x2-x3) + (y2-y3) * (y2-y3);
            
            if(l1+l2 == l3 || l2+l3 == l1 || l1+l3 == l2){
                answer++;
            }
            return;
        }

        for(int i = start; i < N; i++){
            arr[idx] = i;
            sol(idx + 1, i + 1);
        }
    }
}