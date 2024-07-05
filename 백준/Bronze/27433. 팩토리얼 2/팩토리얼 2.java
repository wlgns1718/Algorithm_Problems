import java.io.*;

public class Main {
    static int N;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        if(N == 0) System.out.println(1);
        else System.out.println(sol(N));
    }
    private static long sol(int n){
        if(n == 1) return 1;

        return n * sol(n-1);
    }
}