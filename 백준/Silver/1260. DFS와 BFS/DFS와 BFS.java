import java.io.*;
import java.util.*;

public class Main {

    static int N, M, K;
    static int[][] arr;
    static boolean[] dfs_visit, bfs_visit;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        K = Integer.parseInt(input[2]);

        dfs_visit = new boolean[N+1];
        bfs_visit = new boolean[N+1];
        arr = new int[N+1][N+1];

        for(int i = 0; i < M; i++){
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            arr[a][b] = 1;
            arr[b][a] = 1;
        }
        DFS(K);
        sb.append("\n");
        BFS(K);
        System.out.println(sb);

    }
    private static void DFS(int idx){
        sb.append(idx).append(" ");
        dfs_visit[idx] = true;

        for(int i = 0; i <= N; i++){
            if(i == idx) continue;
            if(dfs_visit[i]) continue;
            if(arr[idx][i] == 1){
                DFS(i);
            }
        }
    }
    private static void BFS(int idx){
        sb.append(idx).append(" ");
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(idx);
        bfs_visit[idx] = true;

        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(int i = 0; i <= N; i++){
                if(bfs_visit[i]) continue;
                if(arr[cur][i] == 1){
                    queue.offer(i);
                    bfs_visit[i] = true;
                    sb.append(i).append(" ");
                }
            }
        }
    }
}