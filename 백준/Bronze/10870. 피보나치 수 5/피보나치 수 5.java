import java.io.*;

public class Main {
    static int N;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        System.out.println(sol(N));
    }
    private static long sol(int n){
        if(n == 1 || n == 0) return n;

        return sol(n-1) + sol(n-2);
    }
}