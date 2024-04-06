import java.io.*;
import java.util.*;

public class Main {
    static int N, M, B, min = Integer.MAX_VALUE, max = 0;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                min = Math.min(min, arr[i][j]);
                max= Math.max(max, arr[i][j]);
            }
        }
        int height = -1;
        int time = 987654321;

        for(int i = min; i <= max; i++){
            int temp_time = 0, block = B;
            for(int x = 0; x < N; x++){
                for(int y = 0; y < M; y++){
                    if(arr[x][y] > i){
                        block += (arr[x][y] - i);
                        temp_time += (arr[x][y] - i) * 2;
                    }
                    else if(arr[x][y] < i){
                        block -= (i - arr[x][y]);
                        temp_time += (i - arr[x][y]);
                    }
                }
            }
            if(block >= 0 && temp_time <= time && height < i){
                height = i;
                time = temp_time;
            }
        }
        sb.append(time).append(" ").append(height);
        System.out.println(sb);
    }
}