import javax.xml.transform.SourceLocator;
import java.util.*;
import java.io.*;


    public class Main {
    static int N, map[][], answer = 0;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        String[] input;
        for(int i = 0; i < N; i++){
            input = br.readLine().split(" ");
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(input[j]);
            }
        }
        sol(0, map, 0);
        System.out.println(answer);
    }
    private static void sol(int cnt, int[][] arr, int val){

        if(cnt == 5){
            answer = Math.max(answer, val);
            return;
        }
        int[][] up = new int[N][N];
        int[][] down = new int[N][N];
        int[][] right = new int[N][N];
        int[][] left = new int[N][N];
        copy(arr, up);
        copy(arr, down);
        copy(arr, left);
        copy(arr, right);

        int max_up = move_up(up);
        int max_down = move_down(down);
        int max_right = move_right(right);
        int max_left = move_left(left);

        sol(cnt + 1, up, max_up);
        sol(cnt + 1, down, max_down);
        sol(cnt + 1, left, max_left);
        sol(cnt + 1, right, max_right);

    }
    private static int move_up(int[][] arr){
        boolean[][] visit = new boolean[N][N];
        for(int i = 1; i < N; i++){
            for(int j = 0; j < N; j++){
                if(arr[i][j] != 0){
                    //위로 올릴 수 있으면 계속 올리기
                    int r = i;
                    while(r > 0 && arr[r-1][j] == 0){
                        arr[r-1][j] = arr[r][j];
                        arr[r][j] = 0;
                        r--;
                    }
                    if(r > 0 && !visit[r-1][j] && arr[r][j] == arr[r-1][j]){
                        arr[r][j] = 0;
                        arr[r-1][j] *= 2;
                        visit[r-1][j] = true;
//                        res = Math.max(res, arr[r-1][j]);
                    }
                }
            }
        }
        return find_max(arr);
    }
    private static int move_down(int[][] arr){
        boolean[][] visit = new boolean[N][N];

        for(int i = N-2; i >= 0; i--){
            for(int j = 0; j < N; j++){
                if(arr[i][j] != 0){
                    //위로 올릴 수 있으면 계속 올리기
                    int r = i;
                    while(r < N-1 && arr[r+1][j] == 0){
                        arr[r+1][j] = arr[r][j];
                        arr[r][j] = 0;
                        r ++;
                    }
                    if(r < N-1 && !visit[r + 1][j] && arr[r][j] == arr[r + 1][j]){
                        arr[r][j] = 0;
                        arr[r + 1][j] *= 2;
                        visit[r + 1][j] = true;
//                        res = Math.max(res, arr[r+1][j]);
                    }
                }
            }
        }
        return find_max(arr);
    }
    private static int move_left(int[][] arr){
        boolean[][] visit = new boolean[N][N];

        for(int i = 0; i < N; i++){
            for(int j = 1; j < N; j++){
                if(arr[i][j] != 0){
                    //위로 올릴 수 있으면 계속 올리기
                    int c = j;
                    while(c > 0 && arr[i][c - 1] == 0){
                        arr[i][c - 1] = arr[i][c];
                        arr[i][c] = 0;
                        c --;
                    }
                    if(c > 0 && !visit[i][c - 1] && arr[i][c] == arr[i][c - 1]){
                        arr[i][c] = 0;
                        arr[i][c - 1] *= 2;
                        visit[i][c - 1] = true;
                        //res = Math.max(res, arr[i][c - 1]);
                    }
                }
            }
        }
        return find_max(arr);
    }
    private static int move_right(int[][] arr){
        boolean[][] visit = new boolean[N][N];
        //int res = 0;
        for(int i = 0; i < N; i++){
            for(int j = N-2; j >= 0; j--){
                if(arr[i][j] != 0){
                    //위로 올릴 수 있으면 계속 올리기
                    int c = j;
                    while(c < N - 1 && arr[i][c + 1] == 0){
                        arr[i][c + 1] = arr[i][c];
                        arr[i][c] = 0;
                        c ++;
                    }
                    if(c < N-1 && !visit[i][c + 1] && arr[i][c] == arr[i][c + 1]){
                        arr[i][c] = 0;
                        arr[i][c + 1] *= 2;
                        visit[i][c + 1] = true;
                        //res = Math.max(res, arr[i][c + 1]);
                    }
                }
            }
        }
        return find_max(arr);
    }
    private static void print(int[][] arr){

        System.out.println("=======================================");
        for(int i = 0; i < N; i++){
            System.out.println(Arrays.toString(arr[i]));
        }
    }
    private static int find_max(int[][] arr){
        int res = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                res = Math.max(res, arr[i][j]);
            }
        }
        return res;
    }
    private static void copy(int[][] ori, int[][] co){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                co[i][j] = ori[i][j];
            }
        }
    }
}