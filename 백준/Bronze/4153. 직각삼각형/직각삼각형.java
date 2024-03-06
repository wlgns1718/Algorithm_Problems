import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true){
            String[] input = br.readLine().split(" ");
            long a = Long.parseLong(input[0]);
            long b = Long.parseLong(input[1]);
            long c = Long.parseLong(input[2]);
            if(a == 0 && b == 0 && c == 0) break;
            a *= a;
            b *= b;
            c *= c;
            if(a+b == c || a+c == b || b+c == a){
                sb.append("right").append("\n");
            }
            else{
                sb.append("wrong").append("\n");
            }

        }
        System.out.println(sb);
    }
}