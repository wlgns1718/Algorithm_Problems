import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static char[][] bulb;
    static boolean[] visit;
    static int answer = 0;
    static int min = Integer.MAX_VALUE;
    static int[] select;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        bulb = new char[N][2];
        visit = new boolean[N];
        select = new int[N];

        for(int i = 0; i < N; i++){
            int temp = 0;
            String input = br.readLine();
            char pre = input.charAt(0);
            for(int j = 1; j < input.length(); j++){
                if(pre != input.charAt(j)){
                    temp++;
                    pre = input.charAt(j);
                }
            }
            bulb[i][0] = input.charAt(0);
            bulb[i][1] = input.charAt(input.length()-1);
            answer += temp;
        }
        sol(0);
        System.out.println(answer + min);
    }
    private static void sol(int idx){
        if(idx == N){
            int temp = 0;
            for(int i = 0; i < N-1; i++){
                if(bulb[select[i]][1] != bulb[select[i+1]][0]) temp++;
            }
            min = Math.min(min, temp);
            return;
        }
        for(int i = 0; i < N; i++){
            if(visit[i]) continue;
            visit[i] = true;
            select[idx] = i;
            sol(idx + 1);
            visit[i] = false;
        }
    }
}