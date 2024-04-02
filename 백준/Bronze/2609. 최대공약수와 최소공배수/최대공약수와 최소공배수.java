import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] input = br.readLine().split(" ");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);
        int g = gcb(a,b);
        int G = a * b / g ;
        sb.append(g).append("\n").append(G);
        System.out.println(sb);
    }
    private static int gcb(int a, int b){
        if(a > b){
            int temp = a;
            a = b;
            b = temp;
        }
        while(b != 0){
            int remain = a % b;
            a = b;
            b = remain;
        }
        return a;
    }
}