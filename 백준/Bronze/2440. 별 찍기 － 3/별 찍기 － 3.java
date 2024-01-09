import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static BufferedWriter bw;
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        sol(n);
        bw.flush();

    }
    private static void sol(int n) throws Exception{
        if(n == 0){
            return;
        }
        bw.write("*".repeat(n) + "\n");
        sol(n - 1);
    }
}