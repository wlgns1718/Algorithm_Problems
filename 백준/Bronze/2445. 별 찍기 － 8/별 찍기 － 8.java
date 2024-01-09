import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        sol(1);
        System.out.println(sb.toString());

    }
    private static void sol(int n){
        if(n == N){
            sb.append("*".repeat(n)).append(" ".repeat(2*(N-n))).append("*".repeat(n)).append("\n");
            return;
        }
        sb.append("*".repeat(n)).append(" ".repeat(2*(N-n))).append("*".repeat(n)).append("\n");
        sol(n + 1);
        sb.append("*".repeat(n)).append(" ".repeat(2*(N-n))).append("*".repeat(n)).append("\n");
    }
}