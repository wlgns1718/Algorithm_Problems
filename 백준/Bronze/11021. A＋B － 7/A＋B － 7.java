import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        String[] input;
        int a, b;
        for(int i = 1; i <= n; i++){
            input = br.readLine().split(" ");
            a = Integer.parseInt(input[0]);
            b = Integer.parseInt(input[1]);
            sb.append("Case #").append(i).append(": ").append(a+b).append("\n");
        }
        System.out.println(sb);
    }
}