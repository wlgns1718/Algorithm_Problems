import java.util.*;
import java.io.*;

public class Main {
    static int M, N, map[][], dir, dx[] = {1,-1,0,0}, dy[] = {0,0,1,-1};
    static boolean visit[][];
    static int answer = 1, cur_x, cur_y;
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
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visit = new boolean[N][M];

        st = new StringTokenizer(br.readLine());
        cur_x = Integer.parseInt(st.nextToken());
        cur_y = Integer.parseInt(st.nextToken());
        dir = Integer.parseInt(st.nextToken());
        
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visit[cur_x][cur_y] = true;
        Loop:

        while(true){
            if(check1()){
                //청소되지 않는 빈칸이 있는 경우
                while(true){
                    if(turn()) break;
                }
                go();
            }
            else{
                if(back()){
                    //뒤로 갈 수 있다면
                    continue;
                }
                else{
                    break Loop;
                }
            }
        }
        System.out.println(answer);
    }
    private static void go(){
        if(dir == 0){
            cur_x --;
            visit[cur_x][cur_y] = true;
            answer++;
        }
        else if(dir == 1){
            cur_y ++;
            visit[cur_x][cur_y] = true;
            answer++;
        }
        else if(dir == 2){
            cur_x ++;
            visit[cur_x][cur_y] = true;
            answer++;
        }
        else{
            cur_y --;
            visit[cur_x][cur_y] = true;
            answer++;
        }
    }
    private static boolean check1(){
        // 주변칸 중 청소되지 않는 빈칸 확인
        for(int i = 0; i < 4; i++){
            int nx = cur_x + dx[i];
            int ny = cur_y + dy[i];
            if(map[nx][ny] == 0 && !visit[nx][ny]) return true;
        }
        return false;
    }
    private static boolean back(){
        if(dir == 0){
            if(map[cur_x + 1][cur_y] == 1) return false;
            cur_x ++;
            return true;
        }
        else if(dir == 1){
            if(map[cur_x][cur_y - 1] == 1) return false;
            cur_y --;
            return true;
        }
        else if(dir == 2){
            if(map[cur_x - 1][cur_y] == 1)return false;
            cur_x --;
            return true;
        }else{
            if(map[cur_x][cur_y + 1] == 1) return false;
            cur_y ++;
            return true;
        }
    }
    private static boolean turn(){
        //북동남서
        if(dir == 0){
            dir = 3;
            return (map[cur_x][cur_y - 1] != 1 && !visit[cur_x][cur_y-1]);
        }
        else if(dir == 1){
            dir = 0;
            return (map[cur_x - 1][cur_y] != 1 && !visit[cur_x - 1][cur_y]);
        }
        else if(dir == 2){
            dir = 1;
            return (map[cur_x][cur_y + 1] != 1 && !visit[cur_x][cur_y+1]);
        }
        else{
            dir = 2;
            return (map[cur_x + 1][cur_y] != 1 && !visit[cur_x + 1][cur_y]);
        }
    }

}