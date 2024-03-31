import java.util.*;
import java.io.*;

public class Main {


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int cnt = 1;
        while(sb.length() < 100_000_000){
            sb.append(cnt++);
        }
        int a = Integer.parseInt(br.readLine());
        System.out.println(sb.charAt(a-1));
    }
}