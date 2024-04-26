import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];

        for(int i = 0; i < N; i++){
            String[] input = br.readLine().split(" ");
            for(int j = 0; j < N; j++){
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }
        for(int k = 0; k < N; k ++){
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(arr[i][k] == 1 && arr[k][j] == 1) arr[i][j] = 1;
                }
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                sb.append(arr[i][j]);
                if(j != N-1) sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

}