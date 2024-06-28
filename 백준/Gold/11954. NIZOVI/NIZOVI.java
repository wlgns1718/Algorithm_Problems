import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int space = 0;
        String word = br.readLine();
        boolean flag = true;
        for(char a : word.toCharArray()){
            if(a == '{'){
                sb.append(" ".repeat(space)).append('{').append("\n");
                space += 2;
            }
            else if(a == '}'){
                space -= 2;
                if(sb.charAt(sb.length() - 2) != '{') sb.append("\n");
                sb.append(" ".repeat(space)).append('}');
            }
            else if(a == ','){
                sb.append(',').append("\n");
            }
            else{
                if(sb.charAt(sb.length()-1) == '\n') sb.append(" ".repeat(space));
                sb.append(a);
            }
        }
        System.out.println(sb);
    }

}