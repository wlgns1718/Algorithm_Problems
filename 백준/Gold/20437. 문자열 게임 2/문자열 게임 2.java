import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < TC; i++){
            String word = br.readLine();
            int k = Integer.parseInt(br.readLine());
            int[] answer = sol(word, k);
            if(answer == null){
                sb.append(-1 + "\n");
            }
            else{
                sb.append((answer[0])).append(" ").append(answer[1]).append("\n");
            }
        }
        System.out.println(sb);
    }

    private static int[] sol(String word, int k){
        int[] answer = new int[2];
        int[][] visit = new int[26][2];
        answer[0] = 10001;
        answer[1] = -1;

        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);

            int idx = (int) ch - 97;

            if(visit[idx][0] == 0){
                visit[idx][1] = i;
            }
            visit[idx][0]++;

            if(visit[idx][0] == k){

                //가장 짧은지 비교
                answer[0] = Math.min(answer[0], i - visit[idx][1] + 1);
                //가장 긴 문자열인지 비교
                answer[1] = Math.max(answer[1], i - visit[idx][1] + 1);

                for(int j = visit[idx][1] + 1; j < word.length(); j++){
                    if(word.charAt(j) == ch){
                        visit[idx][1] = j;
                        visit[idx][0] --;
                        break;
                    }
                }
            }
        }
        if(answer[0] == 10001 || answer[1] == -1){
            return null;
        }
        return answer;
    }
}