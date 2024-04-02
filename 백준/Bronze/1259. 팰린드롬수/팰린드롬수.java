import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input;
        boolean flag;
        while(true){
            input = br.readLine();
            if(input.equals("0")) break;

            flag = true;
            int start = 0;
            int end = input.length() - 1;

            while(start < end){
                if(input.charAt(start) != input.charAt(end)){
                    flag = false;
                    break;
                }
                start ++;
                end --;
            }
            if(flag){
                sb.append("yes").append("\n");
            }
            else{
                sb.append("no").append("\n");
            }
        }
        System.out.println(sb);
    }
}