import java.util.*;
import java.io.*;

public class Main {
    static int n;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        StringBuilder sb = new StringBuilder();
        for(String temp : input) {
            int t = Integer.parseInt(temp);

            if(t == 300) sb.append(1).append(" ");

            else if (t >= 275) sb.append(2).append(" ");

            else if (t >= 250) sb.append(3).append(" ");

            else sb.append(4).append(" ");
        }
        System.out.println(sb);

    }
}