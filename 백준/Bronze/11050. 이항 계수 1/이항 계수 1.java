import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] input = br.readLine().split(" ");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);
        sb.append(sol(a,b));
        System.out.println(sb);
    }
    private static int sol(int a, int b){
        if(a > b){
            int temp = a;
            a = b;
            b = temp;
        }
        int numerator = 1;
        int denominator = 1;

        for(int i = 0; i < a; i++){
            numerator *= (b-i);
            denominator *= (i+1);
        }
        return numerator / denominator;
    }
}