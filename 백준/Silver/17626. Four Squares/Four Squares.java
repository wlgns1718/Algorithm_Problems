import java.io.*;
import java.util.*;

public class Main {
    static int N;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        System.out.println(sol((int) Math.sqrt(N)));
    }
    private static int sol(int start){
        if(start * start == N) return 1;

        for(int i = 1; i <= start; i++){
            int temp = N - (i * i);
            if(Math.sqrt(temp) == (int) Math.sqrt(temp)) return 2;
        }
        
        for(int i = 1; i <= start; i++){
            Loop3:
            for(int j = 1; j <= start; j++){
                int temp = N - (i*i) - (j*j);
                if(temp < 0) break Loop3;
                if(Math.sqrt(temp) == (int) Math.sqrt(temp)) return 3;
            }
        }

        return 4;
    }

}