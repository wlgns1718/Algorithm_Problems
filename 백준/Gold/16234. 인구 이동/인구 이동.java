import java.io.*;
import java.util.*;

public class Main {
    static int N, L, R, arr[][], answer = 0;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static class Data{
        int x;
        int y;

        public Data(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        L = Integer.parseInt(input[1]);
        R = Integer.parseInt(input[2]);

        arr = new int[N][N];
        for(int i = 0; i < N; i++){
            input = br.readLine().split(" ");
            for(int j = 0; j < N; j++){
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }
        while(sol()){
            answer++;
        }
        System.out.println(answer);
    }
    private static boolean sol(){
        boolean flag = false;
        int[][] brr = new int[N][N];
        int[] sum = new int[2501];
        int[] cnt = new int[2501];
        int num = 1;
        Queue<Data> queue = new ArrayDeque<>();

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(brr[i][j] != 0) continue;
                queue.offer(new Data(i,j));
                brr[i][j] = num;
                sum[num] += arr[i][j];
                cnt[num]++;
                while(!queue.isEmpty()){
                    Data data = queue.poll();
                    for(int idx = 0; idx < 4; idx++){

                        int nx = data.x + dx[idx];
                        int ny = data.y + dy[idx];

                        if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                        if(brr[nx][ny] != 0) continue;

                        if(Math.abs(arr[data.x][data.y] - arr[nx][ny]) >= L && Math.abs(arr[data.x][data.y] - arr[nx][ny]) <= R){
                            flag = true;
                            queue.offer(new Data(nx, ny));
                            brr[nx][ny] = num;
                            sum[num] += arr[nx][ny];
                            cnt[num] ++;
                        }
                    }
                }
                num++;
            }
        }
        if(!flag) return flag;

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                arr[i][j] = sum[brr[i][j]] / cnt[brr[i][j]];
            }
        }
        return flag;
    }
}