import java.util.*;
import java.io.*;


public class Main {
    static int N, M, RX, RY, BX, BY, answer = Integer.MAX_VALUE;
    static char[][] map;
    static int[][] red, blue;
    static boolean[][][][] visit;
    static class Info{
        int rx;
        int ry;
        int bx;
        int by;
        boolean flag;
        public Info(int rx, int ry, int bx, int by, boolean flag){
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
            this.flag = flag;
        }
    }
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        init(br);
        sol(map, RX, RY, BX, BY, 0);
        if(answer >= 11){
            System.out.println(-1);
        }
        else{
            System.out.println(answer);
        }

    }
    private static void init(BufferedReader br) throws Exception{

        map = new char[N][M];
        for(int i = 0; i < N; i++){
            String input = br.readLine();
            for(int j = 0; j < M; j++){
                map[i][j] = input.charAt(j);
                if(map[i][j] == 'R'){
                    RX = i;
                    RY = j;
                }
                if(map[i][j] == 'B'){
                    BX = i;
                    BY = j;
                }
            }
        }
        red = new int[N][M];
        blue = new int[N][M];
        visit = new boolean[N][M][N][M];
    }
    private static void print(char[][] ls){
        System.out.println();
        for(int i = 0; i < N; i++){
            System.out.println(Arrays.toString(ls[i]));
        }
        System.out.println();
    }
    private static void sol(char[][] ls, int rx, int ry, int bx, int by, int cnt){

        if(cnt >= 10) return;
        //이미 확인한 형태라면 반환
        if(visit[rx][ry][bx][by]) return;

        //방문하지 않았다면 방문처리 하기
        visit[rx][ry][bx][by] = true;

        char[][] up = new char[N][M];
        char[][] down = new char[N][M];
        char[][] left = new char[N][M];
        char[][] right = new char[N][M];

        //기존 형태 복사
        copy(ls, up);
        copy(ls, down);
        copy(ls, right);
        copy(ls, left);

        Info info_up = updown(-1, rx, ry, bx, by, up);
        Info info_down = updown(1, rx, ry, bx, by, down);
        Info info_left = leftright(-1, rx, ry, bx, by, left);
        Info info_right = leftright(1, rx, ry, bx, by, right);

        //null인 경우 파란공이 빠진것
        fun(info_up, up, cnt);
        fun(info_down, down, cnt);
        fun(info_left, left, cnt);
        fun(info_right, right, cnt);

        //원래 상태로 돌리기
        visit[rx][ry][bx][by] = false;
    }
    private static void fun(Info info, char[][] ls, int cnt){
        if(info != null){
            if(info.flag){
                //빨간공이 빠졌다면
                if(answer > cnt + 1){
                    answer = cnt + 1;
                }
            }
            else{
                sol(ls, info.rx, info.ry, info.bx, info.by, cnt + 1);
            }
        }
    }
    private static Info updown(int direct, int rx, int ry, int bx, int by, char[][] ls){

        boolean flag = false;

        if(direct == -1){
            //위 방향
            if(rx < bx){
                //빨간공 먼저 움직이기
                rx = move_up(rx, ry, ls);
                //만약 빨간공이 빠진다면
                if(ls[rx - 1][ry] == 'O'){
                    ls[rx][ry] = '.';
                    flag = true;
                }
                bx = move_up(bx, by, ls);
                if(ls[bx - 1][by] == 'O'){
                    return null;
                }
            }
            else{
                //파란공 먼저 움직이기
                bx = move_up(bx, by, ls);
                if(ls[bx - 1][by] == 'O'){
                    return null;
                }
                rx = move_up(rx, ry, ls);
                if(ls[rx - 1][ry] == 'O'){
                    ls[rx][ry] = '.';
                    flag = true;
                }
            }
        }
        else{
            //아래 방향
            if(rx > bx){
                //빨간공 먼저
                rx = move_down(rx, ry, ls);
                //만약 빨간공이 빠진다면
                if(ls[rx + 1][ry] == 'O'){
                    ls[rx][ry] = '.';
                    flag = true;
                }
                bx = move_down(bx, by, ls);
                if(ls[bx + 1][by] == 'O'){
                    return null;
                }
            }
            else{
                //파란공 먼저
                bx = move_down(bx, by, ls);
                if(ls[bx + 1][by] == 'O'){
                    return null;
                }
                rx = move_down(rx, ry, ls);
                //만약 빨간공이 빠진다면
                if(ls[rx + 1][ry] == 'O'){
                    ls[rx][ry] = '.';
                    flag = true;
                }
            }
        }
        return new Info(rx, ry, bx, by, flag);
    }
    private static int move_up(int x, int y, char[][] ls){
        while(ls[x-1][y] == '.'){
            char temp = ls[x][y];
            ls[x][y] = ls[x-1][y];
            ls[x-1][y] = temp;
            x--;
        }
        return x;
    }
    private static int move_down(int x, int y, char[][] ls){
        while(ls[x+1][y] == '.'){
            char temp = ls[x][y];
            ls[x][y] = ls[x+1][y];
            ls[x+1][y] = temp;
            x++;
        }
        return x;
    }

    private static Info leftright(int direct, int rx, int ry, int bx, int by, char[][] ls){

        boolean flag = false;

        if(direct == -1){
            //왼쪽
            if(ry < by){
                //빨간공 먼저 움직이기
                ry = move_left(rx, ry, ls);
                if(ls[rx][ry - 1] == 'O'){
                    ls[rx][ry] = '.';
                    flag = true;
                }
                by = move_left(bx, by, ls);
                if(ls[bx][by-1] == 'O'){
                    return null;
                }
            }
            else{
                //파란공 먼저 움직이기
                by = move_left(bx, by, ls);
                if(ls[bx][by-1] == 'O'){
                    return null;
                }
                ry = move_left(rx, ry, ls);
                if(ls[rx][ry - 1] == 'O'){
                    ls[rx][ry] = '.';
                    flag = true;
                }
            }
        }
        else{
            //오른쪽
            if(ry > by){
                //빨간공 먼저
                ry = move_right(rx, ry, ls);
                if(ls[rx][ry+1] == 'O'){
                    ls[rx][ry] = '.';
                    flag = true;
                }
                by = move_right(bx, by, ls);
                if(ls[bx][by+1] == 'O'){
                    return null;
                }
            }
            else{
                by = move_right(bx, by, ls);
                if(ls[bx][by+1] == 'O'){
                    return null;
                }
                ry = move_right(rx, ry, ls);
                if(ls[rx][ry+1] == 'O'){
                    ls[rx][ry] = '.';
                    flag = true;
                }
            }

        }
        return new Info(rx, ry, bx, by, flag);
    }
    private static int move_left(int x, int y, char[][] ls){
        while(ls[x][y-1] == '.'){
            char temp = ls[x][y];
            ls[x][y] = ls[x][y-1];
            ls[x][y-1] = temp;
            y--;
        }
        return y;
    }
    private static int move_right(int x, int y, char[][] ls){
        while(ls[x][y+1] == '.'){
            char temp = ls[x][y];
            ls[x][y] = ls[x][y + 1];
            ls[x][y + 1] = temp;
            y++;
        }
        return y;
    }
    private static void copy(char[][] ori, char[][] cp) {

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                cp[i][j] = ori[i][j];
            }
        }
    }
}