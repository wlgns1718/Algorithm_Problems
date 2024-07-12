import java.io.*;
import java.util.*;

class Main {
    static int N;
    static char[][] arr;
    public static void main(String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder row_sb = new StringBuilder();
        StringBuilder col_sb = new StringBuilder();
        while(true){
            N = Integer.parseInt(br.readLine());
            if(N == 0) break;
            arr = new char[N][N];
            for(int i = 0; i < N; i++){
                String input = br.readLine();
                for(int j = 0; j < N; j++){
                    arr[i][j] = input.charAt(j);
                }
            }

            for(int i = 0; i < N; i++){
                int row = 0;
                int col = 0;
                boolean row_flag = true;
                boolean col_flag = true;
                for(int j = 0; j < N; j++){
                    if(arr[i][j] == 'X'){
                        row++;
                        row_flag = false;
                    }
                    if(row != 0 && arr[i][j] == '.'){
                        row_sb.append(row).append(" ");
                        row = 0;
                    }
                    if(arr[j][i] == 'X'){
                        col++;
                        col_flag = false;
                    }
                    if(col != 0 && arr[j][i] == '.'){
                        col_sb.append(col).append(" ");
                        col = 0;
                    }
                }
                if(row != 0)row_sb.append(row);
                if(col != 0)col_sb.append(col);

                if(row_flag)row_sb.append(0);
                if(col_flag)col_sb.append(0);

                row_sb.append("\n");
                col_sb.append("\n");
            }
            row_sb.append(col_sb);
            col_sb.delete(0, col_sb.length());
        }
        System.out.println(row_sb);
    }

}