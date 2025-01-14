import java.util.*;
class Solution {
    static char[][] map = new char[3][3];
    public int solution(String[] board) {
        int answer = -1;
        int cnt_o = 0, cnt_x = 0;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                map[i][j] = board[i].charAt(j);
                if(map[i][j] == 'O') cnt_o ++;
                else if(map[i][j] == 'X') cnt_x ++;
            }
        }
        char temp = check();
        if(temp == 'N') answer = 0;
        else{
            if(cnt_x > cnt_o || cnt_o - cnt_x >= 2) answer = 0;
            else if(temp == 'o'){
                if(cnt_o == 5 && cnt_x == 4) answer = 1;
                else answer = 0;
            }
            else if(temp == 'O'){
                //O가 이긴 경우
                if(cnt_o - cnt_x == 1) answer = 1;
                else answer = 0;
            }
            else if(temp == 'X'){
                if(cnt_x == cnt_o) answer = 1;
                else answer = 0;
            }
            else{
                //아무도 이긴 사람이 없을 때
                if(cnt_o == cnt_x || cnt_o - cnt_x == 1) answer = 1;
                else answer = 0;
            }
        }
        return answer;
    }
    private static char check(){
        
        int o = 0, x = 0;
        //가로 체크
        for(int i = 0; i < 3; i++){
            char temp = map[i][0];
            if(temp == '.') continue;
            boolean flag = true;
            Loop:
            for(int j = 1; j < 3; j++){
                if(map[i][j] != temp){
                    flag = false;
                    break Loop;
                }
            }
            if(flag){
                if(temp == 'O') o++;
                else x++;
            }
        }
        //세로 체크
        for(int i = 0; i < 3; i++){
            char temp = map[0][i];
            if(temp == '.') continue;
            boolean flag = true;
            Loop:
            for(int j = 1; j < 3; j++){
                if(map[j][i] != temp){
                    flag = false;
                    break Loop;
                }
            }
            if(flag){
                if(temp == 'O') o++;
                else x++;
            }
        }
        //대각선 체크
        char left = map[0][0];
        char right = map[0][2];
        if(left != '.'){
            if(map[1][1] == left && map[2][2] == left){
                if(left == 'O') o++;
                else x++;
            }
        }
        if(right != '.'){
            if(map[1][1] == right && map[0][2] == right){
                if(right == 'O') o++;
                else x++;
            }
        }
        if(o >= 2) return 'o';
        if(o + x >= 2) return 'N';
        else if(o == 1) return 'O';
        else if(x == 1) return 'X';
        return '0';
    }
}