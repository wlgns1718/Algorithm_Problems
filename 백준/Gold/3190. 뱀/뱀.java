import java.util.*;
import java.io.*;

public class Main {
    static int N, map[][], time = 0, cur_x = 0, cur_y = 0;
    static boolean[][] visit;
    static class Info{
        int x;
        int y;
        char D;

        public Info(int x, char D){
            this.x = x;
            this.D = D;
        }

    }
    static class Snake{
        int x;
        int y;
        public Snake(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static Info[] infos;
    static char dir = 'R';
    static Queue<Snake> q = new ArrayDeque<>();
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        visit = new boolean[N][N];
        map = new int[N][N];
        int K = Integer.parseInt(br.readLine());
        String[] input;
        for(int i = 0; i < K; i++){
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]) - 1;
            int b = Integer.parseInt(input[1]) - 1;
            map[a][b] = 1;
        }

        int L = Integer.parseInt(br.readLine());
        infos = new Info[L];
        for(int i = 0; i < L; i++){
            input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            char D = input[1].charAt(0);
            infos[i] = new Info(x, D);
        }
        int idx = 0;
        q.offer(new Snake(cur_x, cur_y));
        while(true){
            if(move()){
                time++;
//                print();
                if(idx < L && infos[idx].x == time){
                    turn(infos[idx++].D);
                }
            }
            else break;
        }
        System.out.println(time + 1);
    }
    private static boolean move(){
        if(dir == 'R'){
            if(cur_y + 1 >= N || visit[cur_x][cur_y + 1]) return false;
            cur_y ++;
            visit[cur_x][cur_y] = true;
            q.offer(new Snake(cur_x, cur_y));
            if(map[cur_x][cur_y] == 1){
                map[cur_x][cur_y] = 0;
                return true;
            }
            Snake tail = q.poll();
            visit[tail.x][tail.y] = false;
        }
        else if(dir == 'D'){
            if(cur_x + 1 >= N || visit[cur_x + 1][cur_y]) return false;
            cur_x ++;
            visit[cur_x][cur_y] = true;
            q.offer(new Snake(cur_x, cur_y));
            if(map[cur_x][cur_y] == 1){
                map[cur_x][cur_y] = 0;
                return true;
            }

            Snake tail = q.poll();
            visit[tail.x][tail.y] = false;
        }
        else if(dir == 'L'){
            if(cur_y - 1 < 0 || visit[cur_x][cur_y - 1]) return false;
            cur_y --;
            visit[cur_x][cur_y] = true;
            q.offer(new Snake(cur_x, cur_y));
            if(map[cur_x][cur_y] == 1){
                map[cur_x][cur_y] = 0;
                return true;
            }
            Snake tail = q.poll();
            visit[tail.x][tail.y] = false;
        }
        else if (dir == 'U') {
            if(cur_x - 1 < 0 || visit[cur_x - 1][cur_y]) return false;
            cur_x --;
            visit[cur_x][cur_y] = true;
            q.offer(new Snake(cur_x, cur_y));
            if(map[cur_x][cur_y] == 1){
                map[cur_x][cur_y] = 0;
                return true;
            }
            Snake tail = q.poll();
            visit[tail.x][tail.y] = false;
        }
        return true;
    }
    private static void turn(char d){
        if(d == 'L'){
            if(dir == 'U'){
                dir = 'L';
            }
            else if(dir == 'D'){
                dir = 'R';
            }
            else if(dir == 'L'){
                dir = 'D';
            }
            else{
                dir = 'U';
            }
        }
        else{
            if(dir == 'U'){
                dir = 'R';
            }
            else if(dir == 'D'){
                dir = 'L';
            }
            else if(dir == 'L'){
                dir = 'U';
            }
            else{
                dir = 'D';
            }
        }
    }
    private static void print(){
        System.out.println();
        for(int i = 0; i < N; i++){
            System.out.println(Arrays.toString(visit[i]));
        }
        System.out.println();
    }
}