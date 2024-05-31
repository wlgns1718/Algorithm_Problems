import java.util.*;
import java.io.*;

public class Main {
    static int N, K, answer = 0;
    static String[] words;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if(K < 5){
            System.out.println(0);
            return;
        }

        words = new String[N];

        for(int i = 0; i < N; i++){
            String input = br.readLine();
            input = input.substring(4, input.length() - 4);
            words[i] = input;
        }
        int word = 0;

        word |= 1;
        word |= (1 << ('n' - 'a'));
        word |= (1 << ('t' - 'a'));
        word |= (1 << ('i' - 'a'));
        word |= (1 << ('c' - 'a'));

        sol(0, word, 5);
        System.out.println(answer);
    }
    private static void sol(int idx, int word, int cnt){
        if(cnt == K){
            int temp = 0;
            for(int i = 0; i < N; i++){
                boolean tri = true;
                Loop1:
                for(int j = 0; j < words[i].length(); j++){
                    if( ((1 << words[i].charAt(j) - 'a') & word) == 0){
                        tri = false;
                        break Loop1;
                    }
                }
                if(tri) temp++;
            }
            answer = Math.max(answer, temp);
            return;
        }
        for(int i = idx; i < 26; i++){
            if((word & 1 << i) != 0) continue;
            sol(i + 1,word | (1 << i), cnt + 1);
        }
    }
}