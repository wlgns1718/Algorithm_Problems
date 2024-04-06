import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int num = 666;
        int cnt = 0;
        int answer = 0;
        while(true){
            if(String.valueOf(num).contains("666")) cnt++;
            if(cnt == N){
                sb.append(num);
                break;
            }
            num++;

        }
        System.out.println(sb);
    }
}