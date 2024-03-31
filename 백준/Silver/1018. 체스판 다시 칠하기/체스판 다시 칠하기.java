import javax.xml.transform.SourceLocator;
import java.util.*;
import java.io.*;


    public class Main {
    static int N, M, answer = Integer.MAX_VALUE;
    static char[][] map;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        for(int i = 0; i < N; i++){
            String input = br.readLine();
            for(int j = 0; j < M; j++){
                map[i][j] = input.charAt(j);
            }
        }
        for(int i = 0; i < N-7; i++){
            for(int j = 0; j < M - 7; j++){
                char chess = map[i][j];
                sol(chess, i, j);
                sol2(chess, i, j);
            }
        }
        System.out.println(answer);
    }
    private static void sol(char chess, int x, int y){
        int cnt = 0;
        for(int i = x; i < x + 8; i++){
            for(int j = y; j < y + 8; j++){
                if(i == x && j == y) continue;
                if(chess == 'B'){
                    if(map[i][j] != 'W'){
                        cnt++;
                    }
                    chess = 'W';
                }
                else{
                    if(map[i][j] != 'B'){
                        cnt ++;
                    }
                    chess = 'B';
                }
            }
            if(chess == 'W') chess = 'B';
            else chess = 'W';
        }
        answer = Math.min(answer, cnt);
    }
        private static void sol2(char chess, int x, int y){
            int cnt = 1;
            if (chess == 'W') chess = 'B';
            else chess = 'W';

            for(int i = x; i < x + 8; i++){
                for(int j = y; j < y + 8; j++){
                    if(i == x && j == y) continue;
                    if(chess == 'B'){
                        if(map[i][j] != 'W'){
                            cnt++;
                        }
                        chess = 'W';
                    }
                    else{
                        if(map[i][j] != 'B'){
                            cnt ++;
                        }
                        chess = 'B';
                    }
                }
                if(chess == 'W') chess = 'B';
                else chess = 'W';
            }
            answer = Math.min(answer, cnt);
        }
}