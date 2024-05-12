import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static char[][][] cube = new char[6][3][3];
    static char[] color = {'w', 'y', 'r', 'o', 'g', 'b'}, temp, temp1; //위 아래 앞 뒤 왼 오
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        String[] input;

        //임시 저장할 장소
        temp = new char[3];
        temp1 = new char[3];

        for(int i = 0; i < N; i++){
            init_cube();
            int count = Integer.parseInt(br.readLine());
            input = br.readLine().split(" ");
            for(String temp : input){
                char m = temp.charAt(0);
                char d = temp.charAt(1);
                sol(m, d);
            }
            answer_print(sb);
        }
        System.out.println(sb);
    }
    private static void init_cube(){
        //위 아래 앞 뒤 왼 오
        for(int i = 0; i < 6; i++){
            char c = color[i];
            for(int j = 0; j < 3; j++){
                for(int p = 0; p < 3; p++){
                    cube[i][j][p] = c;
                }

            }
        }
    }
    private static void answer_print(StringBuilder sb){
        //윗면의 색상 출략
        //위 아래 앞 뒤 왼 오
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                sb.append(cube[0][i][j]);
            }
            sb.append("\n");
        }
    }
    private static void print(){
        for(int i = 0; i < 6; i++){
            switch(i){
                case 0:
                    System.out.println("===윗면===");
                    break;
                case 1:
                    System.out.println("===아랫면===");
                    break;
                case 2:
                    System.out.println("===앞면===");
                    break;
                case 3:
                    System.out.println("===뒷면===");
                    break;
                case 4:
                    System.out.println("===왼쪽면===");
                    break;
                case 5:
                    System.out.println("==오른면===");
                    break;
            }
            for(int p = 0; p < 3; p++){
                System.out.println(Arrays.toString(cube[i][p]));
            }
        }
    }
    private static void sol(char m, char dir) {
        //위 아래 앞 뒤 왼 오

        if(m == 'U'){//위쪽

            if(dir == '+'){
                //시계방향
                rotate('+', 0);
                rotate1('+', 0);
            }
            else{
                //반시계 방향
                rotate('-', 0);
                rotate1('-', 0);
            }
        }
        else if (m == 'D') {//아래쪽

            if(dir == '+'){
                //시계방향
                rotate('+', 1);
                rotate1('+', 1);
            }
            else{
                //반시계 방향
                rotate('-', 1);
                rotate1('-', 1);
            }
        }
        else if(m == 'F'){//앞쪽

            if(dir == '+'){
                //시계방향
                rotate('+', 2);
                rotate1('+', 2);
            }
            else{
                //반시계 방향
                rotate('-', 2);
                rotate1('-', 2);
            }
        }
        else if(m == 'B'){//뒤쪽

            if(dir == '+'){
                //시계방향
                rotate('+', 3);
                rotate1('+', 3);
            }
            else{
                //반시계 방향
                rotate('-', 3);
                rotate1('-', 3);
            }
        }
        else if(m == 'L'){//왼쪽

            if(dir == '+'){
                //시계방향
                rotate('+', 4);
                rotate1('+', 4);
            }
            else{
                //반시계 방향
                rotate('-', 4);
                rotate1('-', 4);
            }
        }
        else if (m == 'R') {//오른쪽

            if(dir == '+'){
                //시계방향
                rotate('+', 5);
                rotate1('+', 5);
            }
            else{
                //반시계 방향
                rotate('-', 5);
                rotate1('-', 5);
            }
        }
    }
    private static void rotate(char dir, int m){
        if(dir == '+'){
            //시계방향
            temp[0] = cube[m][1][2];
            temp[1] = cube[m][2][2];
            cube[m][2][2] = cube[m][0][2];
            cube[m][1][2] = cube[m][0][1];
            cube[m][0][2] = cube[m][0][0];
            temp1[0] = cube[m][2][0];
            temp1[1] = cube[m][2][1];
            cube[m][2][0] = temp[1];
            cube[m][2][1] = temp[0];
            temp[0] = cube[m][1][0];
            cube[m][1][0] = temp1[1];
            cube[m][0][0] = temp1[0];
            cube[m][0][1] = temp[0];
        }
        else{
            //반시계
            temp[0] = cube[m][1][0];
            temp[1] = cube[m][2][0];
            cube[m][2][0] = cube[m][0][0];
            cube[m][1][0] = cube[m][0][1];
            cube[m][0][0] = cube[m][0][2];
            temp1[0] = cube[m][2][1];
            temp1[1] = cube[m][2][2];
            cube[m][2][1] = temp[0];
            cube[m][2][2] = temp[1];
            temp[0] = cube[m][1][2];
            cube[m][1][2] = temp1[0];
            cube[m][0][2] = temp1[1];
            cube[m][0][1] = temp[0];
        }
    }
    private static void rotate1(char dir, int m){
        //위 아래 앞 뒤 왼 오
        /*
        * 위나 아래일 경우 m = 2,3,4,5
        * 앞이나 뒤일 경우 m = 0,1,4,5
        * 왼이나 오일 경우 m = 0,1,2,3
        * */
        if(m == 0){
            if(dir == '+'){

                temp[0] = cube[5][0][0];
                temp[1] = cube[5][0][1];
                temp[2] = cube[5][0][2];
                cube[5][0][2] = cube[3][0][2];
                cube[5][0][1] = cube[3][0][1];
                cube[5][0][0] = cube[3][0][0];

                temp1[0] = cube[2][0][2];
                temp1[1] = cube[2][0][1];
                temp1[2] = cube[2][0][0];
                cube[2][0][2] = temp[2];
                cube[2][0][1] = temp[1];
                cube[2][0][0] = temp[0];

                temp[0] = cube[4][0][2];
                temp[1] = cube[4][0][1];
                temp[2] = cube[4][0][0];
                cube[4][0][2] = temp1[0];
                cube[4][0][1] = temp1[1];
                cube[4][0][0] = temp1[2];

                cube[3][0][2] = temp[0];
                cube[3][0][1] = temp[1];
                cube[3][0][0] = temp[2];
            }
            else{

                //위 아래 앞 뒤 왼 오
                temp[0] = cube[4][0][0];
                temp[1] = cube[4][0][1];
                temp[2] = cube[4][0][2];
                cube[4][0][0] = cube[3][0][0];
                cube[4][0][1] = cube[3][0][1];
                cube[4][0][2] = cube[3][0][2];

                temp1[0] = cube[2][0][0];
                temp1[1] = cube[2][0][1];
                temp1[2] = cube[2][0][2];
                cube[2][0][0] = temp[0];
                cube[2][0][1] = temp[1];
                cube[2][0][2] = temp[2];

                temp[0] = cube[5][0][0];
                temp[1] = cube[5][0][1];
                temp[2] = cube[5][0][2];
                cube[5][0][0] = temp1[0];
                cube[5][0][1] = temp1[1];
                cube[5][0][2] = temp1[2];

                cube[3][0][0] = temp[0];
                cube[3][0][1] = temp[1];
                cube[3][0][2] = temp[2];
            }
        }
        else if(m == 1){
            //위 아래 앞 뒤 왼 오
            if(dir == '+'){
                temp[0] = cube[5][2][0];
                temp[1] = cube[5][2][1];
                temp[2] = cube[5][2][2];
                cube[5][2][0] = cube[2][2][0];
                cube[5][2][1] = cube[2][2][1];
                cube[5][2][2] = cube[2][2][2];

                temp1[0] = cube[3][2][0];
                temp1[1] = cube[3][2][1];
                temp1[2] = cube[3][2][2];
                cube[3][2][0] = temp[0];
                cube[3][2][1] = temp[1];
                cube[3][2][2] = temp[2];

                temp[0] = cube[4][2][0];
                temp[1] = cube[4][2][1];
                temp[2] = cube[4][2][2];
                cube[4][2][0] = temp1[0];
                cube[4][2][1] = temp1[1];
                cube[4][2][2] = temp1[2];

                cube[2][2][0] = temp[0];
                cube[2][2][1] = temp[1];
                cube[2][2][2] = temp[2];
            }
            else{
                //위 아래 앞 뒤 왼 오

                temp[0] = cube[4][2][2];
                temp[1] = cube[4][2][1];
                temp[2] = cube[4][2][0];
                cube[4][2][2] = cube[2][2][2];
                cube[4][2][1] = cube[2][2][1];
                cube[4][2][0] = cube[2][2][0];

                temp1[0] = cube[3][2][2];
                temp1[1] = cube[3][2][1];
                temp1[2] = cube[3][2][0];
                cube[3][2][2] = temp[0];
                cube[3][2][1] = temp[1];
                cube[3][2][0] = temp[2];

                temp[0] = cube[5][2][2];
                temp[1] = cube[5][2][1];
                temp[2] = cube[5][2][0];
                cube[5][2][2] = temp1[0];
                cube[5][2][1] = temp1[1];
                cube[5][2][0] = temp1[2];

                cube[2][2][2] = temp[0];
                cube[2][2][1] = temp[1];
                cube[2][2][0] = temp[2];
            }
        }
        else if(m == 2){
            //위 아래 앞 뒤 왼 오
            if(dir == '+'){

                temp[0] = cube[5][0][0];
                temp[1] = cube[5][1][0];
                temp[2] = cube[5][2][0];
                cube[5][0][0] = cube[0][2][0];
                cube[5][1][0] = cube[0][2][1];
                cube[5][2][0] = cube[0][2][2];

                temp1[0] = cube[1][0][0];
                temp1[1] = cube[1][0][1];
                temp1[2] = cube[1][0][2];
                cube[1][0][2] = temp[0];
                cube[1][0][1] = temp[1];
                cube[1][0][0] = temp[2];

                temp[0] = cube[4][0][2];
                temp[1] = cube[4][1][2];
                temp[2] = cube[4][2][2];
                cube[4][0][2] = temp1[0];
                cube[4][1][2] = temp1[1];
                cube[4][2][2] = temp1[2];

                cube[0][2][0] = temp[2];
                cube[0][2][1] = temp[1];
                cube[0][2][2] = temp[0];

            }
            else{
                //위 아래 앞 뒤 왼 오

                temp[0] = cube[4][0][2];
                temp[1] = cube[4][1][2];
                temp[2] = cube[4][2][2];
                cube[4][0][2] = cube[0][2][2];
                cube[4][1][2] = cube[0][2][1];
                cube[4][2][2] = cube[0][2][0];

                temp1[0] = cube[1][0][0];
                temp1[1] = cube[1][0][1];
                temp1[2] = cube[1][0][2];
                cube[1][0][0] = temp[0];
                cube[1][0][1] = temp[1];
                cube[1][0][2] = temp[2];

                temp[0] = cube[5][0][0];
                temp[1] = cube[5][1][0];
                temp[2] = cube[5][2][0];
                cube[5][0][0] = temp1[2];
                cube[5][1][0] = temp1[1];
                cube[5][2][0] = temp1[0];

                cube[0][2][0] = temp[0];
                cube[0][2][1] = temp[1];
                cube[0][2][2] = temp[2];
            }
        }
        else if(m == 3){
            //위 아래 앞 뒤 왼 오
            if(dir == '+'){

                temp[0] = cube[4][0][0];
                temp[1] = cube[4][1][0];
                temp[2] = cube[4][2][0];
                cube[4][0][0] = cube[0][0][2];
                cube[4][1][0] = cube[0][0][1];
                cube[4][2][0] = cube[0][0][0];

                temp1[0] = cube[1][2][0];
                temp1[1] = cube[1][2][1];
                temp1[2] = cube[1][2][2];
                cube[1][2][0] = temp[0];
                cube[1][2][1] = temp[1];
                cube[1][2][2] = temp[2];

                temp[0] = cube[5][0][2];
                temp[1] = cube[5][1][2];
                temp[2] = cube[5][2][2];
                cube[5][0][2] = temp1[2];
                cube[5][1][2] = temp1[1];
                cube[5][2][2] = temp1[0];

                cube[0][0][0] = temp[0];
                cube[0][0][1] = temp[1];
                cube[0][0][2] = temp[2];
            }
            else{
                //위 아래 앞 뒤 왼 오

                temp[0] = cube[5][0][2];
                temp[1] = cube[5][1][2];
                temp[2] = cube[5][2][2];
                cube[5][0][2] = cube[0][0][0];
                cube[5][1][2] = cube[0][0][1];
                cube[5][2][2] = cube[0][0][2];

                temp1[0] = cube[1][2][0];
                temp1[1] = cube[1][2][1];
                temp1[2] = cube[1][2][2];
                cube[1][2][0] = temp[2];
                cube[1][2][1] = temp[1];
                cube[1][2][2] = temp[0];

                temp[0] = cube[4][0][0];
                temp[1] = cube[4][1][0];
                temp[2] = cube[4][2][0];
                cube[4][0][0] = temp1[0];
                cube[4][1][0] = temp1[1];
                cube[4][2][0] = temp1[2];

                cube[0][0][2] = temp[0];
                cube[0][0][1] = temp[1];
                cube[0][0][0] = temp[2];
            }

        }
        else if(m == 4){
            //위 아래 앞 뒤 왼 오
            if(dir == '+'){

                temp[0] = cube[2][0][0];
                temp[1] = cube[2][1][0];
                temp[2] = cube[2][2][0];
                cube[2][0][0] = cube[0][0][0];
                cube[2][1][0] = cube[0][1][0];
                cube[2][2][0] = cube[0][2][0];

                temp1[0] = cube[1][0][0];
                temp1[1] = cube[1][1][0];
                temp1[2] = cube[1][2][0];
                cube[1][0][0] = temp[0];
                cube[1][1][0] = temp[1];
                cube[1][2][0] = temp[2];

                temp[0] = cube[3][0][2];
                temp[1] = cube[3][1][2];
                temp[2] = cube[3][2][2];
                cube[3][0][2] = temp1[2];
                cube[3][1][2] = temp1[1];
                cube[3][2][2] = temp1[0];

                cube[0][0][0] = temp[2];
                cube[0][1][0] = temp[1];
                cube[0][2][0] = temp[0];

            }
            else{
                //위 아래 앞 뒤 왼 오

                temp[0] = cube[3][0][2];
                temp[1] = cube[3][1][2];
                temp[2] = cube[3][2][2];
                cube[3][0][2] = cube[0][2][0];
                cube[3][1][2] = cube[0][1][0];
                cube[3][2][2] = cube[0][0][0];

                temp1[0] = cube[1][2][0];
                temp1[1] = cube[1][1][0];
                temp1[2] = cube[1][0][0];
                cube[1][2][0] = temp[0];
                cube[1][1][0] = temp[1];
                cube[1][0][0] = temp[2];

                temp[0] = cube[2][0][0];
                temp[1] = cube[2][1][0];
                temp[2] = cube[2][2][0];
                cube[2][0][0] = temp1[2];
                cube[2][1][0] = temp1[1];
                cube[2][2][0] = temp1[0];

                cube[0][0][0] = temp[0];
                cube[0][1][0] = temp[1];
                cube[0][2][0] = temp[2];
            }
        }
        else{
            //위 아래 앞 뒤 왼 오
            if(dir == '+'){

                temp[0] = cube[3][0][0];
                temp[1] = cube[3][1][0];
                temp[2] = cube[3][2][0];
                cube[3][0][0] = cube[0][2][2];
                cube[3][1][0] = cube[0][1][2];
                cube[3][2][0] = cube[0][0][2];

                temp1[0] = cube[1][2][2];
                temp1[1] = cube[1][1][2];
                temp1[2] = cube[1][0][2];
                cube[1][2][2] = temp[0];
                cube[1][1][2] = temp[1];
                cube[1][0][2] = temp[2];

                temp[0] = cube[2][2][2];
                temp[1] = cube[2][1][2];
                temp[2] = cube[2][0][2];
                cube[2][0][2] = temp1[2];
                cube[2][1][2] = temp1[1];
                cube[2][2][2] = temp1[0];

                cube[0][0][2] = temp[2];
                cube[0][1][2] = temp[1];
                cube[0][2][2] = temp[0];

            }
            else{
                //위 아래 앞 뒤 왼 오

                temp[0] = cube[2][0][2];
                temp[1] = cube[2][1][2];
                temp[2] = cube[2][2][2];
                cube[2][0][2] = cube[0][0][2];
                cube[2][1][2] = cube[0][1][2];
                cube[2][2][2] = cube[0][2][2];

                temp1[0] = cube[1][0][2];
                temp1[1] = cube[1][1][2];
                temp1[2] = cube[1][2][2];
                cube[1][0][2] = temp[0];
                cube[1][1][2] = temp[1];
                cube[1][2][2] = temp[2];

                temp[0] = cube[3][2][0];
                temp[1] = cube[3][1][0];
                temp[2] = cube[3][0][0];
                cube[3][2][0] = temp1[0];
                cube[3][1][0] = temp1[1];
                cube[3][0][0] = temp1[2];

                cube[0][0][2] = temp[0];
                cube[0][1][2] = temp[1];
                cube[0][2][2] = temp[2];
            }
        }
    }
}