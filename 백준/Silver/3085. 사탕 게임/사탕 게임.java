import java.util.*;
import java.io.*;

public class Main {
    static char[][] arr;
    static int N;
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];
        for(int i = 0; i < N; i++){
            String temp = br.readLine();
            for(int j = 0; j < N; j++){
                arr[i][j] = temp.charAt(j);
            }
        }
        int answer = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N-1; j++){
                if(arr[i][j] != arr[i][j+1]){
                    change(i, j, i, j+1);
                    answer = Math.max(answer, search());
                    change(i, j+1, i, j);
                }
                if(arr[j][i] != arr[j + 1][i]){
                    change(j, i, j+1, i);
                    answer = Math.max(answer, search());
                    change(j + 1, i, j ,i);
                }
            }
        }
        System.out.println(answer);

    }
    private static void change(int x1, int y1, int x2, int y2){
        char temp = arr[x1][y1];
        arr[x1][y1] = arr[x2][y2];
        arr[x2][y2] = temp;
    }
    private static int search(){
        int res_row = 1;
        int res_col = 1;

        for(int i = 0; i < N; i++){
            char row = arr[i][0];
            char col = arr[0][i];
            int temp_row = 1;
            int temp_col = 1;
            for(int j = 1; j < N; j++){
                if(arr[i][j] == row){
                    temp_row++;
                }
                if(arr[i][j] != row){
                    row = arr[i][j];
                    res_row = Math.max(res_row, temp_row);
                    temp_row = 1;
                }
                if(arr[j][i] == col){
                    temp_col ++;
                }
                if(arr[j][i] != col){
                    col = arr[j][i];
                    res_col = Math.max(res_col, temp_col);
                    temp_col = 1;
                }
            }
            res_row = Math.max(res_row, temp_row);
            res_col = Math.max(res_col, temp_col);
        }
        return Math.max(res_col, res_row);
    }

}