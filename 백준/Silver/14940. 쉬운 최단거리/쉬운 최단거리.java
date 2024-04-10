import java.io.*;
import java.util.*;

public class Main {
    static int N, M, arr[][];
    static int[] dx = {1,-1,0,0}, dy = {0,0,1,-1};
    static class Info{
        int x;
        int y;
        public Info(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        arr = new int[N][M];
        Queue<Info> queue = new ArrayDeque<>();
        for(int i = 0; i < N; i++){
            Arrays.fill(arr[i], Integer.MAX_VALUE);
            input = br.readLine().split(" ");
            for(int j = 0; j < M; j++){
                int temp = Integer.parseInt(input[j]);
                if(temp == 2){
                    queue.offer(new Info(i, j));
                    arr[i][j] = 0;
                }
                else if(temp == 0){
                    arr[i][j] = 0;
                }
            }

        }
        while(!queue.isEmpty()){
            Info cur = queue.poll();
            for(int idx = 0; idx < 4; idx++){
                int nx = cur.x + dx[idx];
                int ny = cur.y + dy[idx];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(arr[nx][ny] == 0) continue;
                if(arr[nx][ny] != Integer.MAX_VALUE) continue;

                arr[nx][ny] = arr[cur.x][cur.y] + 1;
                queue.offer(new Info(nx, ny));
            }
        }
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(arr[i][j] == Integer.MAX_VALUE) sb.append(-1);
                else sb.append(arr[i][j]);
                if(j != M - 1) sb.append(" ");
            }
            if(i != N - 1) sb.append("\n");
        }
        System.out.println(sb);
    }
}