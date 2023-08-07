import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static int R,C,Q,r1,c1,r2,c2;
    static int[][] arr;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        arr = new int[R][C];
        int[][] brr = new int[R][C];
        for(int i = 0; i < R; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < C; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        brr[0][0] = arr[0][0];
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(i == 0){//0번째 행 값 설정
                    if(j==0){
                        continue;
                    }
                    brr[i][j] = brr[i][j - 1] + arr[i][j];

                }
                else if(j == 0){//0번째 열 값 설정
                    if(i == 0){
                        continue;
                    }
                    brr[i][j] = brr[i-1][j] + arr[i][j];
                }
                else{
                    brr[i][j] = brr[i-1][j] + brr[i][j-1] + arr[i][j] - brr[i-1][j-1];
                }
            }
        }
//        System.out.println();
//        for(int i = 0; i < R; i++){
//            System.out.println(Arrays.toString(brr[i]));
//        }
        for(int i = 0; i < Q; i++){
            st = new StringTokenizer(br.readLine());
            r1 = Integer.parseInt(st.nextToken());
            c1 = Integer.parseInt(st.nextToken());
            r2 = Integer.parseInt(st.nextToken());
            c2 = Integer.parseInt(st.nextToken());
            int sum = 0;
            int count = (r2-r1+1) * (c2-c1+1);
            if(r1-1 == 0 && c1 - 1 == 0){
                sum = brr[r2-1][c2-1];
            }
            else if(r1-1 == 0 && c1 - 1 != 0){
                sum = brr[r2-1][c2-1] - brr[r2-1][c1-2];
            }
            else if(c1 - 1 == 0 && r1-1 != 0){
                sum = brr[r2-1][c2-1] - brr[r1-2][c2-1];
            }
            else {
                sum = brr[r2 - 1][c2 - 1] - brr[r2 - 1][c1 - 2] - brr[r1 - 2][c2 - 1] + brr[r1 - 2][c1 - 2];
            }
            bw.write((sum/count) + "\n");
        }
        bw.flush();
        bw.close();

    }

}