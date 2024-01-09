import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        sol(N);
        System.out.println(sb.toString());

    }
    private static void sol(int n){
        if(n == 0){
            return;
        }
        sb.append(" ".repeat(N-n)).append("*".repeat(2*(n-1) + 1)).append("\n");
        sol(n - 1);
    }
}