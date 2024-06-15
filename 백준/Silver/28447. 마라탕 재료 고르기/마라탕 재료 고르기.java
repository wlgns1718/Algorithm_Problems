import java.util.*;
import java.io.*;

public class Main {
    static int N, M, arr[][], answer = Integer.MIN_VALUE;
    static boolean[] visit;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        arr = new int[N][N];
        for(int i = 0; i < N; i++){
            input = br.readLine().split(" ");
            for(int j = 0; j < N; j++){
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }
        visit = new boolean[N];
        sol(0, 0);
        System.out.println(answer);
    }
    private static void sol(int idx, int start){
        if(idx == M){
            int temp = 0;
            for(int i = 0; i < N; i++){
                if(!visit[i]) continue;
                for(int j = i + 1; j < N; j++){
                    if(!visit[j]) continue;
                    temp += arr[i][j];
                }
            }
            answer = Math.max(answer, temp);
            return;
        }

        for(int i = start; i < N; i++){
            if(visit[i]) continue;
            visit[i] = true;
            sol(idx + 1, i + 1);
            visit[i] = false;
        }
    }
}