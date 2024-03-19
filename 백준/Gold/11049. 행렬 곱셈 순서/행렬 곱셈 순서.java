import java.io.*;
import java.util.*;


/*
* dp[i][j] = Math.min(dp[i][j-1] + A[i].x * A[j].x * A[j].y, dp[i+1][j] + A[i].x * A[i].y * A[j].y)
*
*
* */

class Main {
    static int N, dp[][];
    static class Matrix{
        int x;
        int y;
        public Matrix(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static List<Matrix> ls = new ArrayList<>();
    public static void main (String[] operations) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N][N];
        StringTokenizer st = null;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            ls.add(new Matrix(x,y));
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            dp[i][i] = 0;
        }

        for(int i = 1; i < N; i++){
            for(int j = 0; j < N - i; j++){

                int ny = i + j;
                for(int t = j; t < ny; t++){
                    dp[j][ny] = Math.min(dp[j][ny], dp[j][t] + dp[t+1][ny] + (ls.get(j).x * ls.get(t).y * ls.get(ny).y));
                }
            }
        }
//        for(int i = 0; i < N; i++){
//            System.out.println(Arrays.toString(dp[i]));
//        }
        System.out.println(dp[0][N-1]);
    }

}