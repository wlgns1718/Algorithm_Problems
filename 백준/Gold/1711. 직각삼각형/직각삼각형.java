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

    private static double get_dis(long x1, long y1, long x2, long y2){
        return (x1-x2) * (x1-x2) + (y1-y2) * (y1-y2);
    }
    private static boolean cal(double a, double b, double c){

        double l1 = Math.max(Math.max(a,b),c);
        double l2, l3;
        if(l1 == a){
            l2 = b;
            l3 = c;
        }
        else if(l1 == b){
            l2 = a;
            l3 = c;
        }
        else{
            l2 = a;
            l3 = b;
        }
//        System.out.println("l1 = " + l1 + " l2 = " + l2 + " l3 = " + l3);
        return l1 == l2 + l3;
    }
    private static void sol(int idx, int start){

        if(idx == 3){
            if(cal(get_dis(xrr[arr[0]], yrr[arr[0]], xrr[arr[1]], yrr[arr[1]]),
                    get_dis(xrr[arr[1]], yrr[arr[1]], xrr[arr[2]], yrr[arr[2]]),
                        get_dis(xrr[arr[0]], yrr[arr[0]], xrr[arr[2]], yrr[arr[2]]))){
                answer ++;
            }
            return;
        }

        for(int i = start; i < N; i++){
            arr[idx] = i;
            sol(idx + 1, i + 1);
        }
    }
}