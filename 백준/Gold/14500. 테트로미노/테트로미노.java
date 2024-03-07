import java.io.*;
import java.util.*;

public class Main {
    static int N,M, arr[][], answer;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
//        for(int i = 0; i < N; i++){
//            System.out.println(Arrays.toString(arr[i]));
//        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                case1(i,j);
                case2(i,j);
                case3(i,j);
                case4(i,j);
                case5(i,j);
                case6(i,j);
            }
        }
        System.out.println(answer);
    }

    private static void case1(int x, int y){
        // x,y는 시작 지점
        int temp1 = 0;
        int temp2 = 0;
        //가로로 4칸 놓을 수 있을 때
        if(y + 3 < M){
            for(int i = y; i <= y + 3; i++){
                temp1 += arr[x][i];
            }
        }
        //세로로 4칸 놓을 수 있을 때
        if(x + 3 < N){
            for(int i = x; i <= x + 3; i++){
                temp2 += arr[i][y];
            }
        }
        int temp = Math.max(temp1, temp2);
        if(answer < temp){
            answer = temp;
        }
    }
    private static void case2(int x, int y){
        int temp = 0;
        if(x + 1 < N && y + 1 < M){
            for(int i = x; i <= x + 1; i++){
                for(int j = y; j <= y + 1; j++){
                    temp += arr[i][j];
                }
            }
            if(answer < temp){
                answer = temp;
            }
        }
    }
    private static void case3(int x, int y){
        int temp1 = 0;
        int temp2 = 0;
        int temp3 = 0;
        int temp4 = 0;

        if(x + 2 < N && y + 1 < M){
            for(int i = x; i <= x + 2; i++){
                temp1 += arr[i][y];
            }
            temp1 += arr[x+2][y+1];
        }
        if(y + 2 < M && x + 1 < N){
            for(int i = y; i <= y + 2; i++){
                temp2 += arr[x][i];
            }
            temp2 += arr[x+1][y];
        }
        if(x + 2 < N && y + 1 < M){
            for(int i = x; i <= x + 2; i++){
                temp3 += arr[i][y + 1];
            }
            temp3 += arr[x][y];
        }

        if(x + 1 < N && y - 2 >= 0){ //TODO 조금 이상함
            for(int i = y; i >= y-2; i--){
                temp4 += arr[x+1][i];
            }
            temp4 += arr[x][y];
        }
        int temp = Math.max(Math.max(temp1,temp2), Math.max(temp3,temp4));
        if(answer < temp){
            answer = temp;
        }
    }
    private static void case4(int x, int y){
        int temp1 = 0;
        int temp2 = 0;
        int temp3 = 0;
        int temp4 = 0;

        if(x + 1 < N && y + 2 < M){
            for(int i = y; i <= y + 2; i++){
                temp1 += arr[x+1][i];
            }
            temp1 += arr[x][y];
        }
        if(x + 2 < N && y + 1 < M){
            for(int i = x; i <= x + 2; i++){
                temp2 += arr[i][y];
            }
            temp2 += arr[x][y + 1];
        }
        if(x + 1 < N && y + 2 < M){
            for(int i = y; i <= y + 2; i++){
                temp3 += arr[x][i];
            }
            temp3 += arr[x + 1][y + 2];
        }
        if(x - 2 >= 0 && y + 1 < M){
            for(int i = x; i >= x-2; i--){
                temp4 += arr[i][y+1];
            }
            temp4 += arr[x][y];
        }
        int temp = Math.max(Math.max(temp1,temp2), Math.max(temp3,temp4));
        if(answer < temp){
            answer = temp;
        }
    }
    private static void case5(int x, int y){
        int temp1 = 0;
        int temp2 = 0;
        int temp3 = 0;
        int temp4 = 0;

        if(x + 2 < N && y + 1 < M){
            temp1 += arr[x][y];
            temp1 += arr[x+1][y];
            temp1 += arr[x+1][y+1];
            temp1 += arr[x+2][y+1];
        }
        if(x-1 >= 0 && y + 2 < M){
            temp2 += arr[x][y];
            temp2 += arr[x][y+1];
            temp2 += arr[x-1][y+1];
            temp2 += arr[x-1][y+2];
        }
        if(x+1 < N && y+2 < M){
            temp3 += arr[x][y];
            temp3 += arr[x][y+1];
            temp3 += arr[x+1][y+1];
            temp3 += arr[x+1][y+2];
        }
        if(x+2 < N && y-1 >= 0){
            temp4 += arr[x][y];
            temp4 += arr[x+1][y];
            temp4 += arr[x+1][y-1];
            temp4 += arr[x+2][y-1];
        }
        int temp = Math.max(Math.max(temp1,temp2), Math.max(temp3,temp4));

        if(answer < temp){
            answer = temp;
        }
    }
    private static void case6(int x, int y){

        int temp1 = 0;
        int temp2 = 0;
        int temp3 = 0;
        int temp4 = 0;

        if(x+1 < N && y + 2 < M){
            temp1 += arr[x][y];
            temp1 += arr[x][y+1];
            temp1 += arr[x][y+2];
            temp1 += arr[x+1][y+1];
        }
        if(x - 1 >= 0 && y + 2 < M){
            temp2 += arr[x][y];
            temp2 += arr[x][y+1];
            temp2 += arr[x][y+2];
            temp2 += arr[x-1][y+1];
        }
        if(x+2 < N && y + 1 < M){
            temp3 += arr[x][y];
            temp3 += arr[x+1][y];
            temp3 += arr[x+2][y];
            temp3 += arr[x+1][y+1];
        }
        if(x+2 < N && y - 1>= 0){
            temp4 += arr[x][y];
            temp4 += arr[x+1][y];
            temp4 += arr[x+2][y];
            temp4 += arr[x+1][y-1];
        }
        int temp = Math.max(Math.max(temp1,temp2), Math.max(temp3,temp4));

        if(answer < temp){
            answer = temp;
        }
    }
}