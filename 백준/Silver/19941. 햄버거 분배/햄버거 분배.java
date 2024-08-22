import java.io.*;
import java.util.*;

class Main {
    static int N, K;
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);

        String word = br.readLine();
        boolean[] visit = new boolean[N];
        int answer = 0;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(c == 'H') continue;
            visit[i] = true;
            Loop:
            for(int j = i - K; j <= i + K; j++){
                if(j < 0) continue;
                else if(j >= N) break Loop;
                if(visit[j]) continue;
                if(word.charAt(j) == 'H'){
                    visit[j] = true;
                    answer++;
                    break Loop;
                }
            }
        }
        System.out.println(answer);
    }
}