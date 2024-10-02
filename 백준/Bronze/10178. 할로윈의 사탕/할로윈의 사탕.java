import java.io.*;
import java.util.*;

class Main {
    static int N, c, v;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String[] input;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            sb.append("You get ");
            input = br.readLine().split(" ");
            c = Integer.parseInt(input[0]);
            v = Integer.parseInt(input[1]);
            sb.append(c/v).append(" piece(s) and your dad gets ");
            sb.append(c % v).append(" piece(s).").append("\n");
        }
        System.out.println(sb);
    }

}