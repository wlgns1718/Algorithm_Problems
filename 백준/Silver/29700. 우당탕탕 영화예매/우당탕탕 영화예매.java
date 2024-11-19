import java.util.*;
import java.io.*;

public class Main {
    static int N, M, K;
    static char map[][];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        K = Integer.parseInt(input[2]);

        map = new char[N][M];
        String temp;
        for(int i = 0; i < N; i++){
            temp = br.readLine();
            for(int j = 0; j < M; j++){
                map[i][j] = temp.charAt(j);
            }
        }
        int answer = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j <= M - K; j++){
                if(map[i][j] == '1') continue;

                Loop1:
                for(int p = j; p < j + K; p++){
                    if(map[i][p] == '1') break Loop1;
                    if(p == j + K - 1) answer ++;
                }
            }
        }
        System.out.println(answer);
    }
}