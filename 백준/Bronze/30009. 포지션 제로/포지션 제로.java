import java.io.*;
import java.util.*;

class Main {
    static int N, X, Y, R;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] answer = new int[2];
        String[] input = br.readLine().split(" ");

        X = Integer.parseInt(input[0]);
        Y = Integer.parseInt(input[1]);
        R = (int) Math.pow(Integer.parseInt(input[2]), 2);
        for(int i = 0; i < N; i++){
            int x = Integer.parseInt(br.readLine());
            int res = Math.abs((int) Math.pow(x - X, 2));
            if(R - res == 0) answer[1]++;
            if(R - res > 0) answer[0] ++;
        }
        System.out.println(answer[0] + " " + answer[1]);
    }
}