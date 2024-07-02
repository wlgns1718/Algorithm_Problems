import java.util.*;
import java.io.*;

public class Main {
    static char[] arr = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Set<Character> vowels = new HashSet<>();
        for(char temp : arr){
            vowels.add(temp);
        }

        while(true){
            String input = br.readLine();
            if(input.equals("#")) break;
            int cnt = 0;
            for(char temp : input.toCharArray()){
                if(vowels.contains(temp)) cnt++;
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}