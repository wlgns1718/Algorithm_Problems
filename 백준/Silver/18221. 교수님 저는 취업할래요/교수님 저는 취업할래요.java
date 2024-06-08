import java.util.*;
import java.io.*;

public class Main {
    static int sx,sy,ex,ey;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        

        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][N];
        String[] input;
        for(int i = 0; i < N; i++){
            input = br.readLine().split(" ");
            for(int j = 0; j < N; j++){
                arr[i][j] = Integer.parseInt(input[j]);
                if(arr[i][j] == 5){
                    sx = i;
                    sy = j;
                }
                if(arr[i][j] == 2){
                    ex = i;
                    ey = j;
                }
            }
        }
        int dis = (int) Math.pow(sx - ex,2) + (int) Math.pow(sy - ey,2);
        if(dis < 25){
            System.out.println(0);
            return;
        }
        int a = Math.min(sx, ex);
        int b = Math.min(sy, ey);
        int c = Math.max(sx, ex);
        int d = Math.max(sy, ey);
        int cnt = 0;
        for(int i = a; i <= c; i++){
            for(int j = b; j <= d; j++){
                if(arr[i][j] == 1)cnt++;
            }
        }
        if(cnt >= 3){
            System.out.println(1);
        }
        else{
            System.out.println(0);
        }

    }

}