import java.io.*;
import java.util.*;

class Main {
    static int N;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        System.out.println(N - 1946);
    }
}