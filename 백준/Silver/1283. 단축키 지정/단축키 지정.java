import java.util.*;
import java.io.*;

public class Main {
    static final int IDX = 65;
    static int N;
    static boolean[] visit;
    static String word;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visit = new boolean[58];
        sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            word = br.readLine();
            if(check1()) continue;
            if(check2()) continue;
            sb.append(word).append("\n");
        }
        System.out.println(sb);

    }
    private static boolean check1(){
        //첫글자 대문자 검사
        String[] input = word.split(" ");
        for(int i = 0; i < input.length; i++){
            String temp = input[i];
            char letter = temp.charAt(0);
            int a = Character.toUpperCase(letter);
            int b = Character.toLowerCase(letter);
            if(visit[a-IDX] || visit[b-IDX]) continue;
            visit[a-IDX] = true;
            visit[b-IDX] = true;
            for(int j = 0; j < input.length; j++){
                if(j == i){
                    sb.append("[").append(input[j].charAt(0)).append("]")
                            .append(input[j].substring(1));
                }
                else{
                    sb.append(input[j]);
                }
                if(j != input.length - 1) sb.append(" ");
            }
            sb.append("\n");
            return true;
        }
        return false;
    }
    private static boolean check2(){
        for(int i = 0; i < word.length(); i++){
            if(word.charAt(i) == ' ') continue;
            if(visit[word.charAt(i) - IDX]) continue;
            int a = Character.toUpperCase(word.charAt(i));
            int b = Character.toLowerCase(word.charAt(i));
            visit[a-IDX] = true;
            visit[b-IDX] = true;

            for(int j = 0; j < word.length(); j++){
                if(i != j){
                    sb.append(word.charAt(j));
                }
                else{
                    sb.append("[").append(word.charAt(i)).append("]");
                }

            }
            sb.append("\n");
            return true;
        }
        return false;
    }
}