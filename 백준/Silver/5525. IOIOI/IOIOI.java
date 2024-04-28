import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        sb.append("I");
        sb.append("OI".repeat(N));
        String IO = sb.toString();
        int l = Integer.parseInt(br.readLine());
        String temp = br.readLine();
        
        int answer = 0;
        int start = 0;
        while(true){
            temp = temp.substring(start);
            if(!temp.contains(IO)) break;
            answer++;
            start = temp.indexOf(IO) + 2;
        }
        System.out.println(answer);
    }
}