import java.util.*;
import java.io.*;

public class Main {
    static final int MIN = Integer.MIN_VALUE, MAX = Integer.MAX_VALUE;
    static int[] dx = {-1,1, 0, 0}, dy = {0,0,-1, 1}, cor = {0, 0, 0, 0};
    static char cur = 'D';
    static class Info{
        int x;
        int y;
        public Info(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int cur_x, cur_y;
    static List<Info> ls = new ArrayList<>();
    static char[][] map;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        br.readLine();
        String order = br.readLine();
        cur_x = 0;
        cur_y = 0;
        ls.add(new Info(cur_x, cur_y));
        for(char o : order.toCharArray()){
            if(o == 'F'){
                go_forward();
            }
            else{
                if(o == 'R'){
                    turn_right();
                }
                else{
                    turn_left();
                }
            }
        }
        int row = cor[1] - cor[0] + 1;
        int col = cor[3] - cor[2] + 1;
        map = new char[row][col];
        
        int temp_x = 0, temp_y = 0;
        if(cor[0] < 0) temp_x = -cor[0];
        if(cor[2] < 0) temp_y = -cor[2];

        for(Info info : ls){
            map[info.x + temp_x][info.y + temp_y] = '.';
        }
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(map[i][j] == '.') sb.append('.');
                else sb.append('#');
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    private static void go_forward(){
        if(cur == 'U'){
            cur_x -= 1;
            ls.add(new Info(cur_x, cur_y));
            if(cor[0] > cur_x) cor[0] = cur_x;
        }
        else if(cur == 'D'){
            cur_x += 1;
            ls.add(new Info(cur_x, cur_y));
            if(cor[1] < cur_x) cor[1] = cur_x;
        }
        else if(cur == 'L'){
            cur_y -= 1;
            ls.add(new Info(cur_x, cur_y));
            if(cor[2] > cur_y) cor[2] = cur_y;
        }
        else{
            cur_y += 1;
            ls.add(new Info(cur_x, cur_y));
            if(cor[3] < cur_y) cor[3] = cur_y;
        }
    }
    private static void turn_right(){
        if(cur == 'U'){
            cur = 'R';
        }
        else if(cur == 'D'){
            cur = 'L';
        }
        else if(cur == 'L'){
            cur = 'U';
        }
        else{
            cur = 'D';
        }
    }
    private static void turn_left(){
        if(cur == 'U'){
            cur = 'L';
        }
        else if(cur == 'D'){
            cur = 'R';
        }
        else if(cur == 'L'){
            cur = 'D';
        }
        else{
            cur = 'U';
        }
    }
}