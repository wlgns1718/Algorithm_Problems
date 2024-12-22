import java.util.*;
import java.io.*;

public class Main {
    static String input;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int temp = 1;
        while(true){
            input = br.readLine();
            if(input.equals("0")) break;
            System.out.println("Test " + temp++ + ": " + sol(input));
        }
    }

    private static String sol(String word){
        StringBuilder sb = new StringBuilder();

        while(word.length() % 2 == 0){
            sb.delete(0, sb.length());
            for(int i = 0; i < word.length(); i += 2){
                sb.append(String.valueOf(word.charAt(i+1)).repeat(Integer.parseInt(String.valueOf(word.charAt(i)))));
            }
            if(word.equals(sb.toString())) return word;
            word = sb.toString();
        }
        return word;

    }
}