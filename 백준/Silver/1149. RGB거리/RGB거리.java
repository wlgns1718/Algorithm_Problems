import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] house;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());
        house = new int[N][3];
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            if(i==0) {
                for (int j = 0; j < 3; j++) {
                    house[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            else{
                for(int j =0; j<3; j++){
                    house[i][j] = Integer.parseInt(st.nextToken());
                    if(j==0){
                        house[i][j] = Math.min(house[i][j]+house[i-1][1],house[i][j]+house[i-1][2]);
                    }
                    else if(j==1){
                        house[i][j] = Math.min(house[i][j]+house[i-1][0],house[i][j]+house[i-1][2]);
                    }
                    else{
                        house[i][j] = Math.min(house[i][j]+house[i-1][1],house[i][j]+house[i-1][0]);
                    }
                }
            }
        }
        System.out.println(Math.min(Math.min(house[N-1][0],house[N-1][1]),house[N-1][2]));
    }

}