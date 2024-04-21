import java.io.*;
import java.util.*;

public class Main {
    static int answer, combi[] = new int[3], N;
    static String[] input;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < TC; tc++) {
            N = Integer.parseInt(br.readLine());
            if(N > 32){
                br.readLine();
                sb.append(0).append("\n");
                continue;
            }
            input = br.readLine().split(" ");
            answer = Integer.MAX_VALUE;
            
            sol(0, 0);
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
    private static void sol(int idx, int start){

        if(idx == 3){
            int temp = 0;
            for(int i = 0; i < 3; i++){
                for(int j = i+1; j < 3; j++){

                    for(int p = 0; p < 4; p++){
                        if(input[combi[i]].charAt(p) != input[combi[j]].charAt(p)) temp++;
                    }
                }
            }
            if(answer > temp) answer = temp;
            return;
        }

        for(int i = start; i < N; i++){
            combi[idx] = i;
            sol(idx + 1, i + 1);
        }
    }
}