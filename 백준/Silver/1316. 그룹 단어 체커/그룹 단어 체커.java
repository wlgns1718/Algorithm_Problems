import java.util.*;
import java.io.*;

public class Main {
    static int N;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        int answer = 0;
        for(int i = 0; i < N; i++){
            String input = br.readLine();
            answer += sol(input);
        }
        System.out.println(answer);
    }
    private static int sol(String word){
        boolean[] visit = new boolean[26];
        char pre = word.charAt(0);
        visit[pre - 'a'] = true;
        for(int i = 1; i < word.length(); i++){

            if(word.charAt(i) == pre)continue;
            if(word.charAt(i) != pre && visit[word.charAt(i) - 'a']) return 0;
            pre = word.charAt(i);
            visit[pre - 'a'] = true;
        }
        return 1;
    }
}