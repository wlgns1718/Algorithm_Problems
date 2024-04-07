import java.io.*;
import java.util.*;

public class Main {
    static int N, ls[];

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        ls = new int[21];
        String[] input;

        for(int i = 0; i < N; i++){
            input = br.readLine().split(" ");
            if(input[0].equals("add")){
                ls[Integer.parseInt(input[1])] = 1;
            }
            else if(input[0].equals("remove")){
                ls[Integer.parseInt(input[1])] = 0;
            }
            else if(input[0].equals("check")){
                int idx = Integer.parseInt(input[1]);
                if(ls[idx] == 1) sb.append(1).append("\n");
                else sb.append(0).append("\n");
            }
            else if(input[0].equals("toggle")){
                int idx = Integer.parseInt(input[1]);
                if(ls[idx] == 1) ls[idx] = 0;
                else ls[idx] = 1;
            }
            else if(input[0].equals("all")){
                Arrays.fill(ls, 1);
            }
            else{
                Arrays.fill(ls,0);
            }
        }
        System.out.println(sb);
    }
}