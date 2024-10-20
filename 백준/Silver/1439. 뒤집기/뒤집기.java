import java.util.*;
import java.io.*;

public class Main {
    static int[] arr = new int[2];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        char start = input.charAt(0);
        int answer = 0;
        for(char temp : input.toCharArray()){
            if(start == temp){
                continue;
            }
            answer++;
            start = temp;
        }

        if(answer % 2 == 1) answer++;
        System.out.println(answer/2);
    }
}