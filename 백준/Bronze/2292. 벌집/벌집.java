import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int K = 1;
        long answer = 1;
        while(answer < N){
            K++;
            answer = 1 + 3L * (K-1) * K;
        }
        System.out.println(K);
    }
}