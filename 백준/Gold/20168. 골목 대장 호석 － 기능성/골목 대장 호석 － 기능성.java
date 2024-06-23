import java.util.*;
import java.io.*;

public class Main {
    static int[] input;
    static int[][] arr;
    static boolean[] visit;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] temp = br.readLine().split(" ");
        input = new int[5];
        for(int i = 0; i < 5; i++){
            input[i] = Integer.parseInt(temp[i]);
        }
        arr = new int[input[0]][input[0]];
        visit = new boolean[input[0]];

        for(int i = 0; i < input[1]; i++){
            temp = br.readLine().split(" ");
            int a = Integer.parseInt(temp[0]) - 1;
            int b = Integer.parseInt(temp[1]) - 1;
            int cost = Integer.parseInt(temp[2]);
            arr[a][b] = cost;
            arr[b][a] = cost;
        }
        int start = input[2] - 1;
        visit[start] = true;
        sol(start, 0, 0);

        if(answer == Integer.MAX_VALUE) sb.append(-1);
        else sb.append(answer);
        System.out.println(sb);
    }
    private static void sol(int cur, int cost, int max){
        if(cur == input[3] - 1){
            //현재가 목적지라면
            if(answer > max) answer = max;
            return;
        }
        //현재에서 갈 수 있는 곳 탐색
        for(int i = 0; i < input[0]; i++){
            if(arr[cur][i] == 0) continue;
            //가진 비용으로 갈 수 있는지 판단
            if(cost + arr[cur][i] > input[4]) continue;
            //이미 방문했는지 확인
            if(visit[i]) continue;
            //갈수 있다면
            visit[i] = true;
            sol(i, cost + arr[cur][i], Math.max(max, arr[cur][i]));
            visit[i] = false;
        }
    }

}