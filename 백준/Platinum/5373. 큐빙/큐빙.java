import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static char[][][] cube = new char[6][3][3];
    static char[] color = {'w', 'y', 'r', 'o', 'g', 'b'}, temp, temp1;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        String[] input;

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
    private static void sol(char m, char dir) {
       

        if(m == 'U'){

            if(dir == '+'){
                
                rotate('+', 0);
                rotate1('+', 0);
            }
            else{
                
                rotate('-', 0);
                rotate1('-', 0);
            }
        }
        else if (m == 'D') {

            if(dir == '+'){
                
                rotate('+', 1);
                rotate1('+', 1);
            }
            else{
                
                rotate('-', 1);
                rotate1('-', 1);
            }
        }
        else if(m == 'F'){

            if(dir == '+'){
                
                rotate('+', 2);
                rotate1('+', 2);
            }
            else{
                
                rotate('-', 2);
                rotate1('-', 2);
            }
        }
        else if(m == 'B'){

            if(dir == '+'){
               
                rotate('+', 3);
                rotate1('+', 3);
            }
            else{
                
                rotate('-', 3);
                rotate1('-', 3);
            }
        }
        else if(m == 'L'){

            if(dir == '+'){
                
                rotate('+', 4);
                rotate1('+', 4);
            }
            else{
                
                rotate('-', 4);
                rotate1('-', 4);
            }
        }
        else if (m == 'R') {

            if(dir == '+'){
               
                rotate('+', 5);
                rotate1('+', 5);
            }
            else{
                
                rotate('-', 5);
                rotate1('-', 5);
            }
        }
    }
    private static void rotate(char dir, int m){
        if(dir == '+'){
            
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