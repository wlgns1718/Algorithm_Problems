import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.Buffer;
import java.util.*;

public class Main {
    static int N,M,K,answer = 987654321;
    static int[][] white,black;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        white = new int[N][M];
        black = new int[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            String temp = st.nextToken();
            for(int j = 0; j < M; j++){
                char color = temp.charAt(j);
                if((i+j) % 2 == 0){
                    if(color == 'W'){
                        white[i][j] = 0;
                        black[i][j] = 1;
                    }else{
                        white[i][j] = 1;
                        black[i][j] = 0;
                    }
                }
                else{
                    if(color == 'W'){
                        black[i][j] = 0;
                        white[i][j] = 1;
                    }else{
                        black[i][j] = 1;
                        white[i][j] = 0;
                    }
                }
                //prefix 계산 해주기
                if(i == 0 && j == 0){
                    continue;
                }
                if(i == 0){
                    white[i][j] += white[i][j-1];
                    black[i][j] += black[i][j-1];
                    continue;
                }
                if(j == 0){
                    white[i][j] += white[i-1][j];
                    black[i][j] += black[i-1][j];
                    continue;
                }
                white[i][j] += white[i-1][j] + white[i][j-1] - white[i-1][j-1];
                black[i][j] += black[i-1][j] + black[i][j-1]-black[i-1][j-1];

            }
        }
        //체스판 생성
//        for(int i = 0; i < N; i++){
//            System.out.println(Arrays.toString(white[i]));
//        }
        //생성된 prefix로 정답구하기
        for(int i = K-1; i < N; i++){
            for(int j = K-1; j < M; j++){
                if(i == K - 1 && j == K - 1 ){
                    answer = Math.min(Math.min(white[i][j],black[i][j]),answer);
                    continue;
                }
                if(i == K-1){
                    answer = Math.min(Math.min(white[i][j] - white[i][j-K],black[i][j] - black[i][j-K]),answer);
                    continue;
                }
                if(j == K-1){
                    answer = Math.min(Math.min(white[i][j]-white[i-K][j],black[i][j]-black[i-K][j]),answer);
                    continue;
                }
                answer = Math.min(Math.min(white[i][j] - white[i-K][j] - white[i][j-K] + white[i-K][j-K],
                        black[i][j] - black[i-K][j] - black[i][j-K] + black[i-K][j-K]),answer);
            }
        }
        System.out.println(answer);
    }


}