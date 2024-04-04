import javax.lang.model.element.NestingKind;
import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr = new int[15][15];

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        init();
        int TC = Integer.parseInt(br.readLine());
        for(int i = 0; i < TC; i++){
            int row = Integer.parseInt(br.readLine()) - 1;
            int col = Integer.parseInt(br.readLine());
            sb.append(arr[row][col]).append("\n");
        }

        System.out.println(sb);
    }
    private static void init(){
        for(int i = 0; i < 15; i++){
            for(int j = 1; j < 15; j++){
                if(i == 0){
                    arr[i][j] = arr[i][j-1] + j;
                }
                else{
                    arr[i][j] = arr[i-1][j] + arr[i][j-1];
                }
            }
        }
    }
}