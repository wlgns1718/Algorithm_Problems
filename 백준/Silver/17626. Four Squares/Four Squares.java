import java.io.*;
import java.util.*;

public class Main {
    static int N, answer = Integer.MAX_VALUE;
    static boolean flag = false;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        sol(0, 0, (int) Math.sqrt(N));
        System.out.println(answer);
    }
    private static void sol(int cnt, int num, int start){

        if(num + (start * start) * (4-cnt) < N ) return;
        if(cnt > 4 || cnt > answer) return;
        if(num == N){
            answer = Math.min(answer, cnt);
            return;
        }
        for(int i = start; i > 0; i--){
            if(num + (i*i) > N) continue;

            int temp = num + (i*i);
            sol(cnt + 1, temp, (int) Math.sqrt(N - temp));
        }
    }

}