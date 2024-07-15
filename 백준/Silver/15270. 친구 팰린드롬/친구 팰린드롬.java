import java.io.*;
import java.util.*;

class Main {
    static int N, M, answer = 0;
    static int[][] rel;
    static boolean[] select;
    public static void main(String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        rel = new int[M][2];
        select = new boolean[N];

        for(int i = 0; i < M; i++){
            input = br.readLine().split(" ");
            int s = Integer.parseInt(input[0]) - 1;
            int e = Integer.parseInt(input[1]) - 1;
            rel[i][0] = s;
            rel[i][1] = e;
        }
        sol(0, 0);
        answer *= 2;

        if(answer < N) answer ++;
        System.out.println(answer);
    }
    private static void sol(int idx, int cnt){
        if(idx >= M){
            answer = Math.max(answer, cnt);
            return;
        }
        if(select[rel[idx][0]] || select[rel[idx][1]]){
            //둘 중에 이미 선택 되었다면
            sol(idx + 1, cnt);
        }
        else{
            //둘다 선택 안되었다면
            select[rel[idx][0]] = true;
            select[rel[idx][1]] = true;
            sol(idx + 1, cnt + 1);
            select[rel[idx][0]] = false;
            select[rel[idx][1]] = false;
            sol(idx + 1, cnt);
        }
    }
}