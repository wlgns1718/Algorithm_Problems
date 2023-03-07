import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static int[][] paper = new int[101][101];
    static int cnt;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int N = Integer.parseInt(br.readLine());
        for(int i = 0, row, col; i<N; i++){
            st = new StringTokenizer(br.readLine());
            col = Integer.parseInt(st.nextToken());
            row = Integer.parseInt(st.nextToken());
            for(int x = row; x<row+10; x++){
                for(int y = col; y < col+10; y++){
                    paper[x][y] = 1;
                }
            }

        }
        for(int i =0; i<101;i++){
            for(int j =0; j<101; j++){
                if (paper[i][j]==1){
                    if(i==0 || j ==0 || i == 100 || j==100){
                        cnt++;
                    }
                    if(i-1>=0 && paper[i-1][j]==0){
                        cnt++;
                    }
                    if(i+1<101 && paper[i+1][j] ==0){
                        cnt++;
                    }
                    if(j-1>=0 && paper[i][j-1]==0){
                        cnt++;
                    }
                    if(j+1<101 && paper[i][j+1] ==0){
                        cnt++;
                    }

                }
            }
        }
        System.out.println(cnt);
    }
}
