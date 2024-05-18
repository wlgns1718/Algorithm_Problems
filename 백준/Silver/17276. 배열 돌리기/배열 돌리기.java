import java.util.*;
import java.io.*;

public class Main {
    static int N, deg, map[][];
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        String[] input;
        for(int tc = 0; tc < TC; tc++){
            input = br.readLine().split(" ");
            N = Integer.parseInt(input[0]);
            deg = Integer.parseInt(input[1]);
            map = new int[N][N];

            for(int i = 0; i < N; i++){
                input = br.readLine().split(" ");
                for(int j = 0; j < N; j++){
                    map[i][j] = Integer.parseInt(input[j]);
                }
            }
            spin(deg < 0 ? -1 : 1, Math.abs(deg) % 360);
            print(sb);
        }


        System.out.println(sb);

    }
    private static void print(StringBuilder sb){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
    }

    private static void spin(int dir, int degree){
        degree /= 45;

        if(dir == 1){
            if(degree == 0) return;
            sol(degree);
        }
        else{
            if(degree == 0) return;
            sol(8-degree);
        }
    }
    private static void spin_45_or_backspin_315(){
        int temp1;
        int temp2;
        for(int i = 0; i < N/2; i++){
            temp1 = map[i][N/2]; //중간 위
            map[i][N/2] = map[i][i];
            temp2 = map[i][N-i-1]; // 오른쪽 위
            map[i][N-1-i] = temp1;
            temp1 = map[N/2][N-i-1]; ///오른쪽
            map[N/2][N-i-1] = temp2;
            temp2 = map[N-1-i][N-1-i]; //오른쪽 아래
            map[N-1-i][N-1-i] = temp1;
            temp1 = map[N-1-i][N/2]; //중간 아래
            map[N-1-i][N/2] = temp2;
            temp2 = map[N-1-i][i]; //왼쪽 아래
            map[N-1-i][i] = temp1;
            temp1 = map[N/2][i]; //왼쪽
            map[N/2][i] = temp2;
            map[i][i] = temp1; //왼쪽 위
        }
    }
    private static void sol(int idx){
        for(int i = 0; i < idx; i++){
            spin_45_or_backspin_315();
        }
    }

}