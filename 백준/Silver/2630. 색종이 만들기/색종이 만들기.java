import java.io.*;
import java.util.*;

public class Main {
    static int N, arr[][],answer[], temp;
    static boolean[][] visit;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visit = new boolean[N][N];
        answer = new int[2];

        for(int i = 0; i < N; i++){
            String[] input = br.readLine().split(" ");
            for(int j = 0; j < N;j++){
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }
        int len = N;
        while(len > 0 ){
            for(int i = 0; i < N; i += len){
                for(int j = 0; j < N; j += len){
                    if(visit[i][j]) continue;
                    sol(i, j, len);
                }
            }
            len /= 2;
        }
        System.out.println(answer[0]);
        System.out.println(answer[1]);
    }
    private static void sol(int x, int y, int l){
        temp = arr[x][y];
        for(int i = x; i < x + l; i++){
            for(int j = y; j < y + l; j++){
                if(arr[i][j] != temp) return;
            }
        }
        for(int i = x; i < x + l; i++){
            for(int j = y; j < y + l; j++){
                visit[i][j] = true;
            }
        }
        answer[temp]++;
    }

}