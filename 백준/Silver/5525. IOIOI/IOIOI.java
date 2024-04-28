import java.io.*;
import java.util.*;

public class Main {
    static String IO, word;
    static int l;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        l = 2 * N + 1;

        StringBuilder sb = new StringBuilder();
        sb.append("I");
        sb.append("OI".repeat(N));
        IO = sb.toString();

        int len = Integer.parseInt(br.readLine());
        word = br.readLine();

        int start = find(0);
        if(start == -1){
            System.out.println(0);
            return;
        }
        int end = start + l - 1;
        int answer = 1;

        while(true){
            if(end + 2 >= len) break;

            if(word.charAt(end + 1) == 'O' && word.charAt(end + 2) == 'I'){
                end += 2;
                answer ++;
                continue;
            }

            start = find(end + 1);
            if(start == -1)break;
            end = start + l - 1;
            if(end >= len) break;
            answer++;

        }
        System.out.println(answer);

    }
    private static int find(int start){

        while(word.charAt(start) != 'I'){
            start++;
            if(start == word.length()) return -1;
        }
        while(start + l - 1 < word.length()){
            int idx = 1;
            Loop1:
            for(int i = start + 1; i < start + l; i++){

                if(IO.charAt(idx++) != word.charAt(i)){
                    start = i;
                    break Loop1;
                }
                if(i == start + l - 1) return start;
            }
            while(word.charAt(start) != 'I'){
                start++;
                if(start == word.length()) return -1;
            }
        }
        return -1;
    }
}