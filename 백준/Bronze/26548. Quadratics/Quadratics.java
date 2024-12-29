import java.util.*;
import java.io.*;

public class Main {
    static int N;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String[] input;
        double a, b, c;
        double res1, res2;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            input = br.readLine().split(" ");
            a = Float.parseFloat(input[0]) * 1000;
            b = Float.parseFloat(input[1]) * 1000;
            c = Float.parseFloat(input[2]) * 1000;
            double a1 = Math.sqrt((b * b) - (4 * a * c));
            res1 = (-b + a1) / (2 * a);
            res2 = (-b - a1) / (2 * a);
//            System.out.println(res1);
            sb.append(String.format("%.3f", res1)).append(", ").append(String.format("%.3f", res2)).append("\n");
        }
        System.out.println(sb);
    }
}