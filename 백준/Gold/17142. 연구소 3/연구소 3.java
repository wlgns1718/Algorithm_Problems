import java.io.*;
import java.util.*;

public class Main {
    static int N, M, arr[][], answer = Integer.MAX_VALUE, target = 0;
    static int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};

    static List<Virus> ls = new ArrayList<>();
    static class Virus{
        int x;
        int y;
        public Virus(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static boolean[] select;
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
                if(arr[i][j] == 2){
                    ls.add(new Virus(i, j));
                }
                else if(arr[i][j] == 0) target++;
            }
        }
        select = new boolean[ls.size()];
        choice(0, 0);

        System.out.println(answer != Integer.MAX_VALUE ? answer : -1);
    }
    private static void choice(int cnt, int start) {
        if (cnt == M) {
            int res = spread();
            answer = Math.min(answer, res);
            return;
        }

        for (int i = start; i < select.length; i++) {
            if (select[i]) continue;
            select[i] = true;
            choice(cnt + 1, i + 1);
            select[i] = false;
        }
    }
    private static int spread(){
        int cnt = 0;
        Queue<Virus> q = new ArrayDeque<>();
        int[][] temp = new int[N][N];

        boolean[][] visit = new boolean[N][N];
        copy(arr, temp);
        int res = 0;
        for(int i = 0; i < select.length; i++){
            if(select[i]){
                Virus virus = ls.get(i);
                q.offer(virus);
                visit[virus.x][virus.y] = true;
            }
        }
        if(cnt == target) return 0;
        Loop:
        while(!q.isEmpty()){
            int l = q.size();

            for(int i = 0; i < l; i++){

                Virus cur = q.poll();

                for(int idx = 0; idx < 4; idx++){
                    int nx = cur.x + dx[idx];
                    int ny = cur.y + dy[idx];
                    if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                    if(temp[nx][ny] == 1 || visit[nx][ny]) continue;
                    visit[nx][ny] = true;
                    if(temp[nx][ny] == 0) cnt++;
                    if(cnt == target) return res + 1;
                    q.offer(new Virus(nx, ny));
                }
            }
            res ++;
        }

        return cnt == target ? res - 1 : Integer.MAX_VALUE;
    }
    private static void copy(int[][] ori, int[][] co){

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                co[i][j] = ori[i][j];
            }
        }
    }
}